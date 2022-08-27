package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Helpers.Chance;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.LightningStrikeEvent;

import java.util.Random;

public class Lightning implements Listener {

    @EventHandler
    public void onLightning(LightningStrikeEvent e) {
        if (e.getCause() == LightningStrikeEvent.Cause.CUSTOM) return;
        if (Chance.chance(5)) {
            World w = e.getWorld();
            e.setCancelled(true);
            Player randomPlayer = (Player) Bukkit.getOnlinePlayers().toArray()[new Random().nextInt(Bukkit.getOnlinePlayers().size())];
            w.strikeLightning(Bukkit.getPlayer(randomPlayer.getUniqueId()).getLocation());
        }
    }
}
