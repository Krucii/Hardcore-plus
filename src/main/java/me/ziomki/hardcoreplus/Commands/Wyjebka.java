package me.ziomki.hardcoreplus.Commands;

import me.ziomki.hardcoreplus.HardcorePlus;
import me.ziomki.hardcoreplus.Helpers.ActionBarMessage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class Wyjebka implements CommandExecutor {

    public static List<Player> wyjebany = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            if (!wyjebany.contains(p)) {
                wyjebany.add(p);
                p.setGliding(true);
                p.sendMessage("true");
                Bukkit.getScheduler().scheduleSyncDelayedTask(HardcorePlus.getInstance(), () -> wyjebany.remove(p), 20*5);
                ActionBarMessage.sendActionBarMessage(p, ChatColor.RED+"Wyjebales sie XD");
                Vector dir = p.getLocation().getDirection().multiply(2);
                for (ItemStack i : p.getInventory().getStorageContents()) {
                    if (i != null) {
                        p.getWorld().dropItemNaturally(p.getLocation().add(dir), i);
                        p.getInventory().remove(i);
                    }
                }
                ItemStack offhand = p.getInventory().getItemInOffHand();
                if (offhand != null) {
                    p.getWorld().dropItemNaturally(p.getLocation().add(dir), offhand);
                    p.getInventory().setItemInOffHand(new ItemStack(Material.AIR));
                }
            }
            return true;
        }
        return false;
    }
}
