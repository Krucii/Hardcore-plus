package me.ziomki.hardcoreplus.Listeners;

import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChange implements Listener {

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e) {
        if (!(e.getEntity() instanceof Player p)) return;

        for (Biomy b : Biomy.values())
        {
            if (p.getWorld().getBiome(p.getLocation()) == b.b) {
                int oldFoodLevel = p.getFoodLevel();
                int newFoodLevel = e.getFoodLevel();

                if(oldFoodLevel > newFoodLevel) {
                    e.setFoodLevel(e.getFoodLevel() - 1);
                }
            }
        }
    }

    enum Biomy {
        DESERT(Biome.DESERT),
        BADLANDS(Biome.BADLANDS),
        WOODED_BADLANDS(Biome.WOODED_BADLANDS),
        ERODED_BADLANDS(Biome.ERODED_BADLANDS);

        final private Biome b; //dodalem ten final przed commitem wiec nie wiem czy dziala pzdr xD
        Biomy(Biome b) {
            this.b = b;
        }
    }
}
