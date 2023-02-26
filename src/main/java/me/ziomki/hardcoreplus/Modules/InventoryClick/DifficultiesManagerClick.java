package me.ziomki.hardcoreplus.Modules.InventoryClick;

import me.ziomki.hardcoreplus.Helpers.GUICreator;
import me.ziomki.hardcoreplus.Helpers.NBT;
import me.ziomki.hardcoreplus.Modules.PluginModule;
import me.ziomki.hardcoreplus.Modules.PluginModuleController;
import me.ziomki.hardcoreplus.OldLists.DifficultiesList;
import me.ziomki.hardcoreplus.Schedulers.DarknessDamageScheduler;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

import static me.ziomki.hardcoreplus.Helpers.RecordMaker.gui_icon;

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
        final double pages = Math.ceil(DifficultiesList.difficultiesList.size() / 11.0);

        if (
                pageName.equals(ChatColor.WHITE + "Następna strona") ||
                        pageName.equals(ChatColor.WHITE + "Poprzednia strona")
        ) {
            assert event.getClickedInventory() != null;
            final int pageNumber = pageName.equals(ChatColor.WHITE + "Następna strona") ? newGUI.getPageNumber(event.getClickedInventory()) + 1 : newGUI.getPageNumber(event.getClickedInventory()) - 1;
            newGUI.fillGlass();

            for (int i = 1 + 11 * pageNumber - 11; i < 1 + 11 * pageNumber; i++) {
                ItemStack icon = DifficultiesList.makeItem(i);
                newGUI.addToGUI(icon);
            }

            if (pageNumber < pages) newGUI.addNextPageButton();
            if (pageNumber != 1) newGUI.addPreviousPageButton();
            newGUI.addPageInfo(pageNumber);
            newGUI.displayGUI();
        }

        if (Objects.requireNonNull(((Player) event.getWhoClicked()).getPlayer()).isOp()) {
            Material clickedIcon = event.getCurrentItem().getType();

            for (var entry : gui_icon) {
                if (entry.material().equals(clickedIcon)) {
                    toggleEvent(entry.classPointer());
                    int slot = event.getSlot();
                    event.getClickedInventory().setItem(slot, DifficultiesList.makeItem((Integer) NBT.getValue(event.getCurrentItem(), "ID", PersistentDataType.INTEGER)));
                }
            }
        }
    }

    private void toggleEvent(Class<?> c) {
        if (c != DarknessDamageScheduler.class) {
            Boolean enabled = PluginModuleController.getEnabled(c);
            PluginModuleController.setEnabled(c, !enabled);
        } else {
            if (DarknessDamageScheduler.running) DarknessDamageScheduler.stop();
            else DarknessDamageScheduler.start();
        }
    }
}
