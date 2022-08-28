package me.ziomki.hardcoreplus.Listeners.BlockBreakEvents;

import me.ziomki.hardcoreplus.Lists.DifficultiesList;
import me.ziomki.hardcoreplus.Helpers.ChanceCalculator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

public class FastBreakingTools {

    static DifficultiesList adding = new DifficultiesList(30.0, Material.IRON_AXE, ChatColor.GRAY, "Liche narzędzia", "Narzędzia zużywają się szybciej.");

    public static void fastBreaking(BlockBreakEvent e) {
        Player p = e.getPlayer();
        ItemStack itemInHand = p.getInventory().getItemInMainHand();
        if (EnchantmentTarget.TOOL.includes(itemInHand)) {// sprawdzam, czy item w rece to narzedzie
            Damageable d = (Damageable) itemInHand.getItemMeta();
            if(ChanceCalculator.getChance(adding.getChance())) {
                assert d != null;
                d.setDamage(d.getDamage() + 1);
            }
            itemInHand.setItemMeta(d);
        }
    }
}
