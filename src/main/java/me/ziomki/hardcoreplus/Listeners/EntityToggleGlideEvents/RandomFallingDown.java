package me.ziomki.hardcoreplus.Listeners.EntityToggleGlideEvents;

import me.ziomki.hardcoreplus.Commands.Wyjebka;
import me.ziomki.hardcoreplus.Lists.DifficultiesList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;

public class RandomFallingDown implements Listener {

    // Do wystylowania
    static DifficultiesList adding = new DifficultiesList(100.0, Material.POTION, ChatColor.AQUA, "Głodne poczwary", "Wszystkie goniące graczy potwory są szybsze.");

    public static void onFall(EntityToggleGlideEvent e) {
        if (e.getEntity() instanceof Player p) {
            if (Wyjebka.wyjebany.contains(p))
                if (!e.isGliding())
                    e.setCancelled(true);
        }
    }
}
