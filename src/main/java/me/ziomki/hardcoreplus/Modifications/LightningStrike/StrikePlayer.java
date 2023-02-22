package me.ziomki.hardcoreplus.Modifications.LightningStrike;

import me.ziomki.hardcoreplus.Helpers.ChanceCalculator;
import me.ziomki.hardcoreplus.Helpers.RandomPlayer;
import me.ziomki.hardcoreplus.Modifications.Modification;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.weather.LightningStrikeEvent;

public class StrikePlayer implements Modification {

    @Override
    public void onEvent(Event e) {
        LightningStrikeEvent event = (LightningStrikeEvent) e;
        if (event.getCause() == LightningStrikeEvent.Cause.CUSTOM) return;
        if (ChanceCalculator.getChance(5)) {
            event.setCancelled(true);
            World w = event.getWorld();
            Player randomPlayer = RandomPlayer.getPlayer();
            w.strikeLightning(Bukkit.getPlayer(randomPlayer.getUniqueId()).getLocation());
        }
    }
}
