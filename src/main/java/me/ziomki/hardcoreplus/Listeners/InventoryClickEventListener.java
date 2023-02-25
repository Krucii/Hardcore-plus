package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import static me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader.executeOnEvent;

public class InventoryClickEventListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        executeOnEvent(ClassLoader.ClassTypes.InventoryClick, e);
    }
}
