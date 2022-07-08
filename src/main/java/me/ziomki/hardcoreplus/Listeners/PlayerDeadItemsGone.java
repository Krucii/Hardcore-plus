package me.ziomki.hardcoreplus.Listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class PlayerDeadItemsGone implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        int randomNum;
        List<ItemStack> drops = e.getDrops();
        e.getDrops().clear();
        for (ItemStack drop : drops) {
            System.out.println("1111");
            randomNum = ThreadLocalRandom.current().nextInt(1, 100 + 1);
            System.out.println(randomNum);
            if (randomNum > 50) {
                e.getDrops().add(drop);
                System.out.println("bbb " + drop);
            }
        }
    }
}
