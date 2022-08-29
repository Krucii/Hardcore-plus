package me.ziomki.hardcoreplus.Events.GUIClickingList;

import me.ziomki.hardcoreplus.Helpers.GUICreator;
import me.ziomki.hardcoreplus.Lists.DifficultiesList;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class DifficultiesClickingList {

    private final InventoryClickEvent e;

    public DifficultiesClickingList(InventoryClickEvent e) {
        this.e = e;
    }

    public void difficultiesMenu() {
        GUICreator gui = new GUICreator((Player) e.getWhoClicked(), 45, ChatColor.RED + "" + ChatColor.BOLD + "Piekielne utrudnienia");
        final String whatPageType = gui.getPageLore(Objects.requireNonNull(e.getClickedInventory()), 40);
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
        else if (Objects.equals(whatPageType, ChatColor.GREEN + "utrudnienia permanentne")) {
            menu = DifficultiesList.getDifficultiesPermanentList();
            whatPageType_real = "permanent";
            lore.add(ChatColor.GREEN + "utrudnienia permanentne");
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

            if (nextPage < pages) gui.addNextPage();
            gui.addPreviousPage();
            gui.addPageInfo(nextPage, lore);

            gui.displayInventory();
        }

        else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Poprzednia strona")) {
            int prevPage = gui.getPageNumber(e.getClickedInventory()) - 1;

            gui.fillGlass();

            for (int i = 1 + 11 * prevPage - 11; i < 1 + 11 * prevPage; i++) {
                ItemStack icon = DifficultiesList.createDiffIcon(i, whatPageType_real);
                gui.addToGUI(icon);
            }

            gui.addNextPage();
            if (prevPage != 1) gui.addPreviousPage();
            gui.addPageInfo(prevPage, lore);

            gui.displayInventory();
        }
    }
}
