package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Listeners.PlayerMoveEvents.DangerousDarkness;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveEvent_Executor implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        DangerousDarkness.onMove(e);
    }
}
