package me.ziomki.hardcoreplus.Schedulers;

import me.ziomki.hardcoreplus.HardcorePlus;
import me.ziomki.hardcoreplus.Helpers.ActionBarMessage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class DarknessDamageScheduler {

    private static int taskId = 0;
    public static Boolean running = true;

    public static void start() {
        taskId = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(HardcorePlus.getInstance(), DarknessDamageScheduler::damagePlayers, 0, 20);
        running = true;
    }

    public static void stop() {
        Bukkit.getServer().getScheduler().cancelTask(taskId);
        running = false;
    }

    public static void damagePlayers() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            int light_level = player.getLocation().getBlock().getLightLevel();
            if (light_level < 6) {
                player.damage(1);
                ActionBarMessage.sendActionBarMessage(player, ChatColor.RED + "Jesteś w ciemności, otrzymujesz obrażenia.");
            }
        }
    }
}
