package me.ziomki.hardcoreplus.Listeners.CreatureSpawnEvents;

import me.ziomki.hardcoreplus.Lists.DifficultiesList;
import me.ziomki.hardcoreplus.Helpers.ChanceCalculator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class SpawnPoweredCreepers {

    static DifficultiesList adding = new DifficultiesList(5.0, Material.CREEPER_HEAD, ChatColor.DARK_GREEN, "Bombowa imprezka", "Naelektryzowane creepery nie są już tak rzadkim widokiem.");

    public static void onCreeperSpawn(CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Creeper c) {
            if (ChanceCalculator.getChance(adding.getChance()))
                c.setPowered(true);
        }
    }
}
