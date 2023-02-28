package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader.executeOnEvent;

public class PlayerJoinEventListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        executeOnEvent(ClassLoader.ClassTypes.PlayerJoin, e);
    }
}
