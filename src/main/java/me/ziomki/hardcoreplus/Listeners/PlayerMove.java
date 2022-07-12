package me.ziomki.hardcoreplus.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashMap;

public class PlayerMove implements Listener {

    public static HashMap<Player, Boolean> lightDamage = new HashMap<>();

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        if(e.getTo().distanceSquared(e.getFrom()) == 0) return;

        int light = e.getPlayer().getLocation().getBlock().getLightLevel();

        if (light < 6)
            lightDamage.put(e.getPlayer(), true);
        else
            lightDamage.remove(e.getPlayer());
    }
}
