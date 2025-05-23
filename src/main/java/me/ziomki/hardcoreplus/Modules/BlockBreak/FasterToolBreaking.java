package me.ziomki.hardcoreplus.Modules.BlockBreak;

import me.ziomki.hardcoreplus.Helpers.ChanceCalculator;
import me.ziomki.hardcoreplus.Modules.PluginModule;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

public class FasterToolBreaking extends PluginModule {

    @Override
    public void onEvent(Event e) {
        BlockBreakEvent event = (BlockBreakEvent) e;
        Player p = event.getPlayer();
        ItemStack itemInHand = p.getInventory().getItemInMainHand();
        if (EnchantmentTarget.TOOL.includes(itemInHand)) {// sprawdzam, czy material w rece to narzedzie
            Damageable d = (Damageable) itemInHand.getItemMeta();
            if (ChanceCalculator.getChance(30)) {
                assert d != null;
                d.setDamage(d.getDamage() + 1);
            }
            itemInHand.setItemMeta(d);
        }
    }
}
