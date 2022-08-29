package me.ziomki.hardcoreplus.Listeners.LightningStrikeEvents;

import me.ziomki.hardcoreplus.Helpers.RandomPlayer;
import me.ziomki.hardcoreplus.Lists.DifficultiesList;
import me.ziomki.hardcoreplus.Helpers.ChanceCalculator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.LightningStrikeEvent;

public class HugeLightningTarget {

    public HugeLightningTarget(LightningStrikeEvent e, DifficultiesList icon_parameters) {
        if (e.getCause() == LightningStrikeEvent.Cause.CUSTOM) return;
        if (ChanceCalculator.getChance(icon_parameters.getChance())) {
            e.setCancelled(true);
            World w = e.getWorld();
            Player randomPlayer = RandomPlayer.getPlayer();
            w.strikeLightning(Bukkit.getPlayer(randomPlayer.getUniqueId()).getLocation());
        }
    }
}
