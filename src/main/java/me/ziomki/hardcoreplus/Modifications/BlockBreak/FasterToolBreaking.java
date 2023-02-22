package me.ziomki.hardcoreplus.Modifications.BlockBreak;

import me.ziomki.hardcoreplus.Helpers.ChanceCalculator;
import me.ziomki.hardcoreplus.Modifications.Modification;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

public class FasterToolBreaking implements Modification {
    @Override
    public void onEvent(Event e) {
        BlockBreakEvent event = (BlockBreakEvent) e;
        Player p = event.getPlayer();
        ItemStack itemInHand = p.getInventory().getItemInMainHand();
        if (EnchantmentTarget.TOOL.includes(itemInHand)) {// sprawdzam, czy item w rece to narzedzie
            Damageable d = (Damageable) itemInHand.getItemMeta();
            if (ChanceCalculator.getChance(30)) {
                assert d != null;
                d.setDamage(d.getDamage() + 1);
            }
            itemInHand.setItemMeta(d);
        }
    }
}
