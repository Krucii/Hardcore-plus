package me.ziomki.hardcoreplus.Modules.PlayerDeath;

import me.ziomki.hardcoreplus.Helpers.ChanceCalculator;
import me.ziomki.hardcoreplus.Modules.PluginModule;
import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class DeathEraseItems extends PluginModule {
    @Override
    public void onEvent(Event e) {
        PlayerDeathEvent event = (PlayerDeathEvent) e;
        for (int i = 0; i < event.getDrops().size(); i++) {
            if (ChanceCalculator.getChance(50))
                event.getDrops().set(i, new ItemStack(Material.AIR));
        }
    }
}
