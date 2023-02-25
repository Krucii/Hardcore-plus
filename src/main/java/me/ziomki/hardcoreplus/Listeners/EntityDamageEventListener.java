package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import static me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader.executeOnEvent;

public class EntityDamageEventListener implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        executeOnEvent(ClassLoader.ClassTypes.EntityDamage, e);
    }
}
