package me.ziomki.hardcoreplus.Listeners.BlockBreakEvents;

import me.ziomki.hardcoreplus.Lists.DifficultiesList;
import me.ziomki.hardcoreplus.Helpers.ChanceCalculator;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

public class FastBreakingTools {

    public FastBreakingTools(BlockBreakEvent e, DifficultiesList icon_parameters) {
        Player p = e.getPlayer();
        ItemStack itemInHand = p.getInventory().getItemInMainHand();
        if (EnchantmentTarget.TOOL.includes(itemInHand)) {// sprawdzam, czy item w rece to narzedzie
            Damageable d = (Damageable) itemInHand.getItemMeta();
            if (ChanceCalculator.getChance(icon_parameters.getChance())) {
                assert d != null;
                d.setDamage(d.getDamage() + 1);
            }
            itemInHand.setItemMeta(d);
        }
    }
}
