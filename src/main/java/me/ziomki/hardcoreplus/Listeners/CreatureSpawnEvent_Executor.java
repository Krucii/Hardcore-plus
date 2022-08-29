package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Listeners.CreatureSpawnEvents.SpawnPoweredCreepers;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class CreatureSpawnEvent_Executor implements Listener {

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent e) {
        SpawnPoweredCreepers.onCreeperSpawn(e);
    }
}
