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

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "" + ChatColor.BOLD + "Piekielne utrudnienia")) {
            e.setCancelled(true);
            onClick.difficultiesMenu();
        }
    }
}
