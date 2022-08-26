package me.ziomki.hardcoreplus.Events;

import me.ziomki.hardcoreplus.Lists.DifficultiesList;
import me.ziomki.hardcoreplus.Helpers.GUICreator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

public class GUIClicking implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        // anty error
        if (e.getCurrentItem() == null) return;
        // Lista inventory
        String inv1 = ChatColor.RED + "" + ChatColor.BOLD + "Piekielne utrudnienia";

        if (e.getView().getTitle().equalsIgnoreCase(inv1)) {
            e.setCancelled(true);
            difficultiesMenu(inv1, e);
        }
    }

    // Lista utrudnień - GUI
    public void difficultiesMenu(String inv1, InventoryClickEvent e) {
        GUICreator gui = new GUICreator((Player) e.getWhoClicked(), 45, inv1);
        final String whatPageType = gui.getPageType(Objects.requireNonNull(e.getClickedInventory()));
        String whatPageType_real;
        HashMap<Integer, List<Object>> menu;

        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GREEN + "Ta lista zawiera");
        if (Objects.equals(whatPageType, ChatColor.GREEN + "utrudnienia procentowe")) {
            menu = DifficultiesList.getDifficultiesChanceList();
            whatPageType_real = "chance";
            lore.add(ChatColor.GREEN + "utrudnienia procentowe");
        }
        else if (Objects.equals(whatPageType, ChatColor.GREEN + "utrudnienia permamentne")) {
            menu = DifficultiesList.getDifficultiesPermamentList();
            whatPageType_real = "permament";
            lore.add(ChatColor.GREEN + "utrudnienia permamentne");
        }
        else {
            menu = DifficultiesList.getDifficultiesList();
            whatPageType_real = "";
            lore.add(ChatColor.GREEN + "wszystkie utrudnienia");
        }

        final double pages = Math.ceil(menu.size() / 11.0);

        if (Objects.requireNonNull(Objects.requireNonNull(e.getCurrentItem()).getItemMeta()).getDisplayName().equals(ChatColor.WHITE + "Następna strona")) {
            int nextPage = gui.getPageNumber(e.getClickedInventory()) + 1;

            gui.fillGlass();

            for (int i = 1 + 11 * nextPage - 11; i < 1 + 11 * nextPage; i++) {
                ItemStack icon = DifficultiesList.createDiffIcon(i, whatPageType_real);
                gui.addToGUI(icon);
            }

            if (nextPage < pages) {
                gui.addNextPage();
                gui.addPreviousPage();
                gui.addPageInfo(nextPage, lore);
            }
            else {
                gui.addPreviousPage();
                gui.addPageInfo(nextPage, lore);
            }

            gui.displayInventory();
        }

        else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Poprzednia strona")) {
            int prevPage = gui.getPageNumber(e.getClickedInventory()) - 1;

            gui.fillGlass();

            for (int i = 1 + 11 * prevPage - 11; i < 1 + 11 * prevPage; i++) {
                ItemStack icon = DifficultiesList.createDiffIcon(i, whatPageType_real);
                gui.addToGUI(icon);
            }

            if (prevPage == 1) {
                gui.addNextPage();
                gui.addPageInfo(prevPage, lore);
            }
            else {
                gui.addNextPage();
                gui.addPreviousPage();
                gui.addPageInfo(prevPage, lore);
            }

            gui.displayInventory();
        }
    }
}
