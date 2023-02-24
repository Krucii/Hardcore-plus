package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import static me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader.executeOnEvent;

public class PlayerDeathEventListener implements Listener {

    //DifficultiesList gui_icon_1 = new DifficultiesList(100.0, Material.CANDLE, ChatColor.DARK_PURPLE, "Bolesna śmierć", "Podczas śmierci połowa przedmiotów znika.");

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        executeOnEvent(ClassLoader.ClassTypes.PlayerDeath, e);
    }
}
