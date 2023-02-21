package me.ziomki.hardcoreplus.Events;

import me.ziomki.hardcoreplus.Events.GUIClickingList.DifficultiesClickingList;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUIClicking implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getCurrentItem() == null) return;

        DifficultiesClickingList onClick = new DifficultiesClickingList(e);

        // Menu list
        final String DIFF_CHECK_LIST = ChatColor.RED + "" + ChatColor.BOLD + "Piekielne utrudnienia";

        if (e.getView().getTitle().equalsIgnoreCase(DIFF_CHECK_LIST)) {
            e.setCancelled(true);
            onClick.difficultiesMenu();
        }
    }
}
