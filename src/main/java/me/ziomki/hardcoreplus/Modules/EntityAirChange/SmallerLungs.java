package me.ziomki.hardcoreplus.Modules.EntityAirChange;

import me.ziomki.hardcoreplus.Modules.PluginModule;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityAirChangeEvent;

public class SmallerLungs extends PluginModule {

    @Override
    public void onEvent(Event e) {
        EntityAirChangeEvent event = (EntityAirChangeEvent) e;
        if (!(event.getEntity() instanceof Player p)) return;
        if (!p.isInWater()) return;
        if (event.getAmount() >= 151) {
            event.setAmount(150);
        }
    }
}
