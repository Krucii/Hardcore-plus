package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Listeners.CreatureSpawnEvents.SpawnPoweredCreepers;
import me.ziomki.hardcoreplus.Lists.DifficultiesList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class CreatureSpawnEvent_Executor implements Listener {

    DifficultiesList gui_icon_1 = new DifficultiesList(5.0, Material.CREEPER_HEAD, ChatColor.DARK_GREEN, "Bombowa imprezka", "Naelektryzowane creepery nie są już tak rzadkim widokiem.");

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent e) {
        new SpawnPoweredCreepers(e, gui_icon_1);
    }
}
