package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

import static me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader.executeOnEvent;

public class EntityTargetEventListener implements Listener {

    @EventHandler
    public void onEntityTarget(EntityTargetEvent e) {
        executeOnEvent(ClassLoader.ClassTypes.EntityTarget, e);
    }
}
