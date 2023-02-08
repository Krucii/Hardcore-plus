package me.ziomki.hardcoreplus.Helpers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GUICreator {

    private final Player invOwner;
    private int itemSlot = 10;
    private final Inventory GUI;

    public GUICreator(Player invOwner, int invSize, String invName) {
        this.invOwner = invOwner;
        GUI = Bukkit.createInventory(invOwner, invSize, invName);
    }

    // Wypełnia pustą przestrzeń szarym szkłem
    public void fillGlass() {
        ItemStack voidGlass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta voidGlassMeta = voidGlass.getItemMeta();
        assert voidGlassMeta != null;
        voidGlassMeta.setDisplayName(" ");
        voidGlass.setItemMeta(voidGlassMeta);
        for (int i = 0; i < GUI.getSize(); i++)
            GUI.setItem(i, voidGlass);
    }

    // Dodaje przedmiot, ikonę do GUI
    public void addToGUI(ItemStack icon) {
        GUI.setItem(itemSlot, icon);

        if (itemSlot == 16 || itemSlot == 24) itemSlot += 4;
        else itemSlot += 2;
    }

    // Dodaje informację o numerze strony
    public void addPageInfo(int pageNumber) {
        ItemStack page = new ItemStack(Material.PAPER);
        ItemMeta pageMeta = page.getItemMeta();
        pageMeta.setDisplayName(ChatColor.WHITE + "Strona " + pageNumber);
        page.setItemMeta(pageMeta);

        GUI.setItem(40, page);
    }

    // Dodaje informację o numerze strony + lore
    public void addPageInfo(int pageNumber, List<String> lore) {
        addPageInfo(pageNumber);
        ItemStack page = GUI.getItem(40);
        ItemMeta pageMeta = page.getItemMeta();
        pageMeta.setLore(lore);
        page.setItemMeta(pageMeta);
    }

    // Dodaje przycisk - następna strona
    public void addNextPageButton() {
        ItemStack nextPage = new ItemStack(Material.ARROW);
        ItemMeta nextPageMeta = nextPage.getItemMeta();
        assert nextPageMeta != null;
        nextPageMeta.setDisplayName(ChatColor.WHITE + "Następna strona");
        nextPage.setItemMeta(nextPageMeta);

        GUI.setItem(44, nextPage);
    }

    // Dodaje przycisk - poprzednia strona
    public void addPreviousPageButton() {
        ItemStack previousPage = new ItemStack(Material.ARROW);
        ItemMeta previousPageMeta = previousPage.getItemMeta();
        assert previousPageMeta != null;
        previousPageMeta.setDisplayName(ChatColor.WHITE + "Poprzednia strona");
        previousPage.setItemMeta(previousPageMeta);

        GUI.setItem(36, previousPage);
    }

    // Otwiera GUI
    public void displayGUI() {
        invOwner.openInventory(GUI);
    }

    // Zwraca przedmiot z GUI
    public ItemStack getIcon(int slot) {
        return GUI.getItem(slot);
    }

    // Zwraca numer strony
    public int getPageNumber(Inventory inv) {
        String pageInfo = Objects.requireNonNull(Objects.requireNonNull(inv.getItem(40)).getItemMeta()).getDisplayName().replaceAll("[^0-9]", "");
        return Integer.parseInt(pageInfo);
    }

    // Zwraca konkretnę linię lore strony
    public String getPageLore(Inventory inv, int i) {
        if (!inv.getItem(i).getItemMeta().hasLore()) return "";
        else return inv.getItem(i).getItemMeta().getLore().get(2);
    }

    // Układa lore w ładny sposób (opis + szansa)
    public static List<String> fancyLore(String lore, Double chance) {
        StringBuilder sb = new StringBuilder("\n" + ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "\"" + lore + "\"\n");
        int i = 0;

        while (i + 35 < sb.length() && (i = sb.lastIndexOf(" ", i + 35)) != -1)
            sb.replace(i, i + 1, "\n" + ChatColor.DARK_GRAY + "" + ChatColor.ITALIC);

        if (chance == 100.0) sb.append("\n" + ChatColor.GOLD + "Efekt permanentny");
        else sb.append("\n" + ChatColor.YELLOW + "Szansa wystąpienia: " + ChatColor.GOLD).append(chance).append("0%");
        return Arrays.asList(sb.toString().split("\n"));
    }

    // Układa lore w ładny sposób (opis)
    public static List<String> fancyLore(String lore) {
        StringBuilder sb = new StringBuilder("\n" + ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "\"" + lore + "\"\n");
        int i = 0;

        while (i + 35 < sb.length() && (i = sb.lastIndexOf(" ", i + 35)) != -1)
            sb.replace(i, i + 1, "\n" + ChatColor.DARK_GRAY + "" + ChatColor.ITALIC);

        return Arrays.asList(sb.toString().split("\n"));
    }
}
