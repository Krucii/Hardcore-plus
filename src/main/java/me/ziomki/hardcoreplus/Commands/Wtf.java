package me.ziomki.hardcoreplus.Commands;

import me.ziomki.hardcoreplus.HardcorePlus;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Wtf implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            p.setFlySpeed((float)-0.2);
            Bukkit.getScheduler().scheduleSyncDelayedTask(HardcorePlus.getInstance(), () -> p.setFlySpeed(0.2f), 20*5);
            return true;
        }
        return false;
    }
}
