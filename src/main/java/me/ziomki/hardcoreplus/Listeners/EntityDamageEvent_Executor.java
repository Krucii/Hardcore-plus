package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Listeners.EntityDamageEvents.TwistedAnkleEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageEvent_Executor implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        TwistedAnkleEvent.onPlayerFall(e);
    }
}
