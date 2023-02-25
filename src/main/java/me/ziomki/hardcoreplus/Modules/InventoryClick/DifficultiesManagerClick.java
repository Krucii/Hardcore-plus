package me.ziomki.hardcoreplus.Modules.InventoryClick;

import me.ziomki.hardcoreplus.Helpers.GUICreator;
import me.ziomki.hardcoreplus.Modules.PluginModule;
import me.ziomki.hardcoreplus.OldLists.DifficultiesList;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class DifficultiesManagerClick extends PluginModule {
    @Override
    public void onEvent(Event e) {
        final InventoryClickEvent event = (InventoryClickEvent) e;
        final String gui_title = ChatColor.RED + "" + ChatColor.BOLD + "Piekielne utrudnienia";

        if (!event.getView().getTitle().equals(gui_title)) return;
        if (event.getCurrentItem() == null) return;
        event.setCancelled(true);

        final GUICreator newGUI = new GUICreator((Player) event.getWhoClicked(), 45, gui_title);
        final String pageName = event.getCurrentItem().getItemMeta().getDisplayName();
        final double pages = Math.ceil(DifficultiesList.getDifficultiesList().size() / 11.0);

        if (
            pageName.equals(ChatColor.WHITE + "Następna strona") ||
            pageName.equals(ChatColor.WHITE + "Poprzednia strona")
        ) {
            assert event.getClickedInventory() != null;
            final int pageNumber = pageName.equals(ChatColor.WHITE + "Następna strona") ? newGUI.getPageNumber(event.getClickedInventory()) + 1 : newGUI.getPageNumber(event.getClickedInventory()) - 1;
            newGUI.fillGlass();

            for (int i = 1 + 11 * pageNumber - 11; i < 1 + 11 * pageNumber; i++) {
                ItemStack icon = DifficultiesList.createDiffIcon(i);
                newGUI.addToGUI(icon);
            }

            if (pageNumber < pages) newGUI.addNextPageButton();
            if (pageNumber != 1) newGUI.addPreviousPageButton();
            newGUI.addPageInfo(pageNumber);
            newGUI.displayGUI();
        }

    }
}
