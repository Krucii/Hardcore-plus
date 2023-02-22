package me.ziomki.hardcoreplus.Modifications.CreatureSpawn;

import me.ziomki.hardcoreplus.Helpers.ChanceCalculator;
import me.ziomki.hardcoreplus.Modifications.Modification;
import org.bukkit.entity.Creeper;
import org.bukkit.event.Event;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class SpawnPoweredCreeper extends Modification {
    @Override
    public void onEvent(Event e) {
        CreatureSpawnEvent event = (CreatureSpawnEvent) e;
        if (event.getEntity() instanceof Creeper c) {
            if (ChanceCalculator.getChance(5))
                c.setPowered(true);
        }
    }
}
