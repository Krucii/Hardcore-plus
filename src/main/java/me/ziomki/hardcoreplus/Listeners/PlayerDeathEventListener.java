package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import static me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader.executeOnEvent;

public class PlayerDeathEventListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        executeOnEvent(ClassLoader.ClassTypes.PlayerDeath, e);
    }
}
