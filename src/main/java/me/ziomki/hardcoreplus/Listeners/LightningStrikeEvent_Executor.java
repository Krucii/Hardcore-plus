package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Listeners.LightningStrikeEvents.HugeLightningTarget;
import me.ziomki.hardcoreplus.Lists.DifficultiesList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.LightningStrikeEvent;

public class LightningStrikeEvent_Executor implements Listener {

    DifficultiesList gui_icon_1 = new DifficultiesList(5.0, Material.LIGHTNING_ROD, ChatColor.RED, "Wkurzony Zeus", "Zwiększona szansa na zostanie trafionym piorunem.");

    @EventHandler
    public void onLightningStrike(LightningStrikeEvent e) {
        new HugeLightningTarget(e, gui_icon_1);
    }
}
