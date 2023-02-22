package me.ziomki.hardcoreplus.NewListeners;

import me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.LightningStrikeEvent;

import static me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader.executeOnEvent;

public class LightningStrikeEventListener implements Listener {

    //DifficultiesList gui_icon_1 = new DifficultiesList(5.0, Material.LIGHTNING_ROD, ChatColor.RED, "Wkurzony Zeus", "Zwiększona szansa na zostanie trafionym piorunem.");

    @EventHandler
    public void onLightningStrike(LightningStrikeEvent e) {
        executeOnEvent(ClassLoader.ClassTypes.LightningStrike, e);
        //new HugeLightningTarget(e, gui_icon_1);
    }
}