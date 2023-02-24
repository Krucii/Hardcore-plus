package me.ziomki.hardcoreplus.Modules.EntityDamage;

import me.ziomki.hardcoreplus.Modules.PluginModule;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageEvent;

public class InfiniteFire extends PluginModule {
    @Override
    public void onEvent(Event e) {
        EntityDamageEvent event = (EntityDamageEvent) e;
        if (!(event.getEntity() instanceof Player)) return;

        if (event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) {
            event.getEntity().setFireTicks(100);
        }
    }
}
