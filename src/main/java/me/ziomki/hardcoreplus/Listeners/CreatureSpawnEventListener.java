package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import static me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader.executeOnEvent;

public class CreatureSpawnEventListener implements Listener {

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent e) {
        executeOnEvent(ClassLoader.ClassTypes.CreatureSpawn, e);
    }
}
