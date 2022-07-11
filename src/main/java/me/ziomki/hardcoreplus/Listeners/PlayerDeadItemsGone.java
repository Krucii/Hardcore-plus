package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Helpers.Chance;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerDeadItemsGone implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        for (int i = 0; i < e.getDrops().size(); i++) {
            if (Chance.chance(50))
                e.getDrops().set(i, new ItemStack(Material.AIR));
        }

    }
}
