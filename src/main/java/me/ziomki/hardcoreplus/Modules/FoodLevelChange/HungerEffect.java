package me.ziomki.hardcoreplus.Modules.FoodLevelChange;

import me.ziomki.hardcoreplus.Modules.PluginModule;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class HungerEffect extends PluginModule {
    @Override
    public void onEvent(Event e) {
        FoodLevelChangeEvent event = (FoodLevelChangeEvent) e;
        if (!(event.getEntity() instanceof Player p)) return;

        for (HungerEffect.Biomy b : HungerEffect.Biomy.values())
        {
            if (p.getWorld().getBiome(p.getLocation()) == b.b) {
                int oldFoodLevel = p.getFoodLevel();
                int newFoodLevel = event.getFoodLevel();

                if(oldFoodLevel > newFoodLevel) {
                    event.setFoodLevel(event.getFoodLevel() - 1);
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
