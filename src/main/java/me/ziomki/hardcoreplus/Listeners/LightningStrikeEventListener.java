package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.LightningStrikeEvent;

import static me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader.executeOnEvent;

public class LightningStrikeEventListener implements Listener {

    @EventHandler
    public void onLightningStrike(LightningStrikeEvent e) {
        executeOnEvent(ClassLoader.ClassTypes.LightningStrike, e);
    }
}