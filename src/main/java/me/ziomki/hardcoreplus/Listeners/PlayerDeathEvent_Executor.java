package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Listeners.PlayerDeathEvents.DeathEraseItems;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathEvent_Executor implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        DeathEraseItems.onDeath(e);
    }
}
