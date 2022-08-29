package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Listeners.EntityTargetEvents.VeryFastMonsters;
import me.ziomki.hardcoreplus.Lists.DifficultiesList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

public class EntityTargetEvent_Executor implements Listener {

    DifficultiesList gui_icon_1 = new DifficultiesList(100.0, Material.POTION, ChatColor.AQUA, "Głodne poczwary", "Wszystkie goniące graczy potwory są szybsze.");

    @EventHandler
    public void onEntityTarget(EntityTargetEvent e) {
        new VeryFastMonsters(e, gui_icon_1);
    }
}
