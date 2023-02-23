package me.ziomki.hardcoreplus.Modules.CreatureSpawn;

import me.ziomki.hardcoreplus.Helpers.ChanceCalculator;
import me.ziomki.hardcoreplus.Modules.Module;
import org.bukkit.entity.Creeper;
import org.bukkit.event.Event;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class SpawnPoweredCreeper extends Module {
    @Override
    public void onEvent(Event e) {
        CreatureSpawnEvent event = (CreatureSpawnEvent) e;
        if (event.getEntity() instanceof Creeper c) {
            if (ChanceCalculator.getChance(5))
                c.setPowered(true);
        }
    }
}
