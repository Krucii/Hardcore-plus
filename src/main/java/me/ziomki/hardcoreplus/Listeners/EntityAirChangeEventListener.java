package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityAirChangeEvent;

import static me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader.executeOnEvent;

public class EntityAirChangeEventListener implements Listener {

    @EventHandler
    public void onEntityAirChange(EntityAirChangeEvent e) {
        executeOnEvent(ClassLoader.ClassTypes.EntityAirChange, e);
    }
}
