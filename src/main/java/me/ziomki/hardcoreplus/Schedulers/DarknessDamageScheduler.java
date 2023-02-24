package me.ziomki.hardcoreplus.Schedulers;

import me.ziomki.hardcoreplus.HardcorePlus;
import me.ziomki.hardcoreplus.Helpers.ActionBarMessage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import static me.ziomki.hardcoreplus.Modules.PlayerMove.DarknessDamage.lightDamage;

public class DarknessDamageScheduler {

    private static int taskId = 0;

    public static void start() {
        taskId = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(HardcorePlus.getInstance(), DarknessDamageScheduler::damagePlayers, 0, 20);
        Bukkit.getLogger().info("Task started: " + taskId);
    }

    public static void stop() {
        Bukkit.getServer().getScheduler().cancelTask(taskId);
    }

    public static void damagePlayers() {
        lightDamage.forEach((player -> {
            player.damage(1);
            ActionBarMessage.sendActionBarMessage(player, ChatColor.RED + "Jestes w ciemnosci, otrzymujesz obrazenia.");
        }));
    }
}
