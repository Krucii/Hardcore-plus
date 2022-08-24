package me.ziomki.hardcoreplus.Helpers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUICreator {

    private final Player invOwner;
    private final int invSize;
    private final String invName;

    private int theGap = 10;

    private final Inventory GUI;

    public GUICreator(Player invOwner, int invSize, String invName) {
        this.invOwner = invOwner;
        this.invSize = invSize;
        this.invName = invName;
        GUI = Bukkit.createInventory(invOwner, invSize, invName);
    }

        //Inventory hardcoreMenu = Bukkit.createInventory(p, 45, ChatColor.RED + "" + ChatColor.BOLD + "Piekielne utrudnienia");

    public void fillGlass() {
        ItemStack voidGlass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta voidGlassMeta = voidGlass.getItemMeta();
        voidGlassMeta.setDisplayName(" ");
        voidGlass.setItemMeta(voidGlassMeta);
        for (int i = 0; i < GUI.getSize(); i++)
            GUI.setItem(i, voidGlass);
    }

    public void addToGUI(ItemStack icon) {
        if (theGap > 34) {
            addPageInfo(1);
            return;
        }
        GUI.setItem(theGap, icon);

        if (theGap == 16 || theGap == 24) theGap += 4;
        else theGap += 2;
    }

    public void addPageInfo(int pageNumber) {
        ItemStack page = new ItemStack(Material.PAPER);
        ItemMeta pageMeta = page.getItemMeta();
        pageMeta.setDisplayName(ChatColor.WHITE + "Strona " + pageNumber);
        page.setItemMeta(pageMeta);

        GUI.setItem(40, page);
    }

    public void addNextPage() {
        ItemStack nextPage = new ItemStack(Material.ARROW);
        ItemMeta nextPageMeta = nextPage.getItemMeta();
        nextPageMeta.setDisplayName(ChatColor.WHITE + "Następna strona");
        nextPage.setItemMeta(nextPageMeta);

        GUI.setItem(44, nextPage);
    }

    public void addPreviousPage() {
        ItemStack previousPage = new ItemStack(Material.ARROW);
        ItemMeta previousPageMeta = previousPage.getItemMeta();
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
        String pageInfo = inv.getItem(40).getItemMeta().getDisplayName().replaceAll("[^0-9]", "");
        return Integer.parseInt(pageInfo);
    }
}
