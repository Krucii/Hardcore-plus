package me.ziomki.hardcoreplus.Helpers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Random;

public class RandomPlayer {

    public static Player getPlayer() {
        return (Player) Bukkit.getOnlinePlayers().toArray()[new Random().nextInt(Bukkit.getOnlinePlayers().size())];
    }
}
