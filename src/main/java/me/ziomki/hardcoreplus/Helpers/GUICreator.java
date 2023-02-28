package me.ziomki.hardcoreplus.Helpers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class GUICreator {

    private final Player invOwner;
    private final Inventory GUI;
    // Pierwszy slot, w którym pojawi się przedmiot (pierwszy wiersz pusty)
    private int itemSlot = 10;

    public GUICreator(Player invOwner, int invSize, String invName) {
        this.invOwner = invOwner;
        GUI = Bukkit.createInventory(invOwner, invSize, invName);
    }

    // Układa lore w ładny sposób (opis + szansa)
    public static List<String> fancyLore(String lore, Double chance) {
        StringBuilder formattedLore = new StringBuilder("\n" + ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "\"" + lore + "\"\n");
        int i = 0;

        while (i + 35 < formattedLore.length() && (i = formattedLore.lastIndexOf(" ", i + 35)) != -1) {
            formattedLore.replace(i, i + 1, String.format("\n%s%s", ChatColor.DARK_GRAY, ChatColor.ITALIC));
        }

        if (chance == 100.0) formattedLore.append(String.format("\n%sEfekt permanentny", ChatColor.GOLD));
        else formattedLore.append(String.format("\n%sSzansa wystąpienia: %s%s0%%", ChatColor.YELLOW, ChatColor.GOLD, chance));

        return List.of(formattedLore.toString().split("\n"));
    }

    public static ItemStack makeVoidGlass() {
        ItemStack voidGlass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta voidGlassMeta = voidGlass.getItemMeta();
        assert voidGlassMeta != null;
        voidGlassMeta.setDisplayName(" ");
        voidGlass.setItemMeta(voidGlassMeta);
        return voidGlass;
    }

    // Wypełnia pustą przestrzeń szarym szkłem - ładniejsze GUI
    public void fillGlass() {
        for (int i = 0; i < GUI.getSize(); i++) GUI.setItem(i, makeVoidGlass());
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
        ArrayList<String> pageLore = new ArrayList<>();
        pageLore.add(" ");
        pageLore.add(ChatColor.GREEN + "Ta lista zawiera");
        pageLore.add(ChatColor.GREEN + "wszystkie utrudnienia");
        pageMeta.setLore(pageLore);
        page.setItemMeta(pageMeta);
        GUI.setItem(40, page);
    }

    // Dodaje przycisk - następna strona
    public void addNextPageButton() {
        addButton("Następna strona", 44);
    }

    // Dodaje przycisk - poprzednia strona
    public void addPreviousPageButton() {
        addButton("Poprzednia strona", 36);
    }

    public void addButton(String displayName, int slot) {
        ItemStack button = new ItemStack(Material.ARROW);
        ItemMeta buttonMeta = button.getItemMeta();
        assert buttonMeta != null;
        buttonMeta.setDisplayName(ChatColor.WHITE + displayName);
        button.setItemMeta(buttonMeta);

        GUI.setItem(slot, button);
    }


    // Otwiera GUI
    public void displayGUI() {
        invOwner.openInventory(GUI);
    }

    // Zwraca numer strony
    public int getPageNumber(Inventory inv) {
        String pageInfo = Objects.requireNonNull(Objects.requireNonNull(inv.getItem(40)).getItemMeta()).getDisplayName().replaceAll("[^0-9]", "");
        return Integer.parseInt(pageInfo);
    }
}
