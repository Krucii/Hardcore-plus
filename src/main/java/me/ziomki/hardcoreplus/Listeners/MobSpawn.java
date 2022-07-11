package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Helpers.Chance;
import org.bukkit.entity.Creeper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class MobSpawn implements Listener {

    @EventHandler
    public void onMobSpawn(CreatureSpawnEvent e) {
        if (e.getEntity() instanceof Creeper) {
            if (Chance.chance(5)) {
                Creeper creeper = (Creeper)e.getEntity();
                creeper.setPowered(true);
            }
        }
    }
}
