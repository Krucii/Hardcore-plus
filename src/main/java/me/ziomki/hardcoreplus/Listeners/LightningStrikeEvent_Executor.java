package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Listeners.LightningStrikeEvents.HugeLightningTarget;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.LightningStrikeEvent;

public class LightningStrikeEvent_Executor implements Listener {

    @EventHandler
    public void onLightningStrike(LightningStrikeEvent e) {
        HugeLightningTarget.onLightning(e);
    }
}
