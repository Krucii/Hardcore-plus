package me.ziomki.hardcoreplus.Listeners.EntityToggleGlideEvents;

import me.ziomki.hardcoreplus.Commands.Wyjebka;
import me.ziomki.hardcoreplus.Lists.DifficultiesList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import org.bukkit.event.entity.EntityToggleGlideEvent;

public class RandomFallingDown {

    public RandomFallingDown(EntityToggleGlideEvent e, DifficultiesList icon_parameters) {
        if (e.getEntity() instanceof Player p) {
            if (Wyjebka.wyjebany.contains(p))
                if (!e.isGliding())
                    e.setCancelled(true);
        }
    }
}
