package me.ziomki.hardcoreplus.Listeners.CreatureSpawnEvents;

import me.ziomki.hardcoreplus.Lists.DifficultiesList;
import me.ziomki.hardcoreplus.Helpers.ChanceCalculator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class SpawnPoweredCreepers {

    public SpawnPoweredCreepers(CreatureSpawnEvent e, DifficultiesList icon_parameters) {
        if (e.getEntity() instanceof Creeper c) {
            if (ChanceCalculator.getChance(icon_parameters.getChance()))
                c.setPowered(true);
        }
    }
}
