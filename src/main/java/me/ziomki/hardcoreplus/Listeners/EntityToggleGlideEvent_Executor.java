package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Listeners.EntityToggleGlideEvents.RandomFallingDown;
import me.ziomki.hardcoreplus.Lists.DifficultiesList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;

public class EntityToggleGlideEvent_Executor implements Listener {

    // Do wystylowania
    DifficultiesList gui_icon_1 = new DifficultiesList(100.0, Material.POTION, ChatColor.AQUA, "Głodne poczwary", "Wszystkie goniące graczy potwory są szybsze.");

    @EventHandler
    public void onEntityToggleGlide(EntityToggleGlideEvent e) {
        new RandomFallingDown(e, gui_icon_1);
    }
}
