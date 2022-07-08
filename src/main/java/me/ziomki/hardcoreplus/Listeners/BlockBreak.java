package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Helpers.Chance;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

public class BlockBreak implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        ItemStack itemInHand = p.getInventory().getItemInMainHand();
        if (EnchantmentTarget.TOOL.includes(itemInHand)) {// sprawdzam, czy item w rece to narzedzie
            Damageable d = (Damageable) itemInHand.getItemMeta();
            if(Chance.chance(30))
                d.setDamage(d.getDamage() + 1);
            itemInHand.setItemMeta(d);
        }
    }
}
