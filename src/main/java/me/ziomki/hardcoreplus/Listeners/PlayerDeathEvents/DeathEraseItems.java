package me.ziomki.hardcoreplus.Listeners.PlayerDeathEvents;

import me.ziomki.hardcoreplus.Lists.DifficultiesList;
import me.ziomki.hardcoreplus.Helpers.ChanceCalculator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class DeathEraseItems {

    public DeathEraseItems(PlayerDeathEvent e, DifficultiesList icon_parameters) {
        for (int i = 0; i < e.getDrops().size(); i++) {
            if (ChanceCalculator.getChance(50))
                e.getDrops().set(i, new ItemStack(Material.AIR));
        }

    }
}
