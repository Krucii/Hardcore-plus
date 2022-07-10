package me.ziomki.hardcoreplus.Listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.ThreadLocalRandom;

public class PlayerDeadItemsGone implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        for (int i = 0; i < e.getDrops().size(); i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(1, 100 + 1);
            if (randomNum > 50)
                e.getDrops().set(i, new ItemStack(Material.AIR));
        }

    }
}
