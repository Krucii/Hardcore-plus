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

public class HugeLightningTarget implements Listener {

    static DifficultiesList adding = new DifficultiesList(5.0, Material.LIGHTNING_ROD, ChatColor.RED, "Wkurzony Zeus", "Zwiększona szansa na zostanie trafionym piorunem.");

    public static void onLightning(LightningStrikeEvent e) {
        if (e.getCause() == LightningStrikeEvent.Cause.CUSTOM) return;
        if (ChanceCalculator.getChance(adding.getChance())) {
            e.setCancelled(true);
            World w = e.getWorld();
            Player randomPlayer = RandomPlayer.getPlayer();
            w.strikeLightning(Bukkit.getPlayer(randomPlayer.getUniqueId()).getLocation());
        }
    }
}
