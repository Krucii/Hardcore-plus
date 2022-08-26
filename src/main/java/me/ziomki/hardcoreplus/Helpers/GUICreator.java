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

    private int theGap = 10;

    private final Inventory GUI;

    public GUICreator(Player invOwner, int invSize, String invName) {
        this.invOwner = invOwner;
        GUI = Bukkit.createInventory(invOwner, invSize, invName);
    }

    public void fillGlass() {
        ItemStack voidGlass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta voidGlassMeta = voidGlass.getItemMeta();
        assert voidGlassMeta != null;
        voidGlassMeta.setDisplayName(" ");
        voidGlass.setItemMeta(voidGlassMeta);
        for (int i = 0; i < GUI.getSize(); i++)
            GUI.setItem(i, voidGlass);
    }

    public void addToGUI(ItemStack icon) {
        GUI.setItem(theGap, icon);

        if (theGap == 16 || theGap == 24) theGap += 4;
        else theGap += 2;
    }

    public void addPageInfo(int pageNumber, List<String> lore) {
        ItemStack page = new ItemStack(Material.PAPER);
        ItemMeta pageMeta = page.getItemMeta();
        assert pageMeta != null;
        pageMeta.setDisplayName(ChatColor.WHITE + "Strona " + pageNumber);
        pageMeta.setLore(lore);
        page.setItemMeta(pageMeta);

        GUI.setItem(40, page);
    }

    public void addNextPage() {
        ItemStack nextPage = new ItemStack(Material.ARROW);
        ItemMeta nextPageMeta = nextPage.getItemMeta();
        assert nextPageMeta != null;
        nextPageMeta.setDisplayName(ChatColor.WHITE + "Następna strona");
        nextPage.setItemMeta(nextPageMeta);

        GUI.setItem(44, nextPage);
    }

    public void addPreviousPage() {
        ItemStack previousPage = new ItemStack(Material.ARROW);
        ItemMeta previousPageMeta = previousPage.getItemMeta();
        assert previousPageMeta != null;
        previousPageMeta.setDisplayName(ChatColor.WHITE + "Poprzednia strona");
        previousPage.setItemMeta(previousPageMeta);

        GUI.setItem(36, previousPage);
    }

    public void displayInventory() {
        invOwner.openInventory(GUI);
    }

    public ItemStack getIcon(int slot) {
        return GUI.getItem(slot);
    }

    public int getPageNumber(Inventory inv) {
        String pageInfo = Objects.requireNonNull(Objects.requireNonNull(inv.getItem(40)).getItemMeta()).getDisplayName().replaceAll("[^0-9]", "");
        return Integer.parseInt(pageInfo);
    }

    public String getPageType(Inventory inv) {
        return Objects.requireNonNull(Objects.requireNonNull(Objects.requireNonNull(inv.getItem(40)).getItemMeta()).getLore()).get(2);
    }


    public static List<String> fancyLore(String lore, Double chance) {
        StringBuilder sb = new StringBuilder("\n" + ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "\"" + lore + "\"\n");
        int i = 0;

        while (i + 35 < sb.length() && (i = sb.lastIndexOf(" ", i + 35)) != -1)
            sb.replace(i, i + 1, "\n" + ChatColor.DARK_GRAY + "" + ChatColor.ITALIC);

        if (chance == 100.0) sb.append("\n" + ChatColor.GOLD + "Efekt permamentny");
        else sb.append("\n" + ChatColor.YELLOW + "Szansa wystąpienia: " + ChatColor.GOLD).append(chance).append("0%");
        return Arrays.asList(sb.toString().split("\n"));
    }

    public static List<String> fancyLore(String lore) {
        StringBuilder sb = new StringBuilder("\n" + ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "\"" + lore + "\"\n");
        int i = 0;

        while (i + 35 < sb.length() && (i = sb.lastIndexOf(" ", i + 35)) != -1)
            sb.replace(i, i + 1, "\n" + ChatColor.DARK_GRAY + "" + ChatColor.ITALIC);

        return Arrays.asList(sb.toString().split("\n"));
    }
}
