package me.ziomki.hardcoreplus;

import me.ziomki.hardcoreplus.Commands.PercentageTest;
import me.ziomki.hardcoreplus.Commands.Wtf;
import me.ziomki.hardcoreplus.Commands.Wyjebka;
import me.ziomki.hardcoreplus.Listeners.*;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

import static me.ziomki.hardcoreplus.Schedulers.DarknessScheduler.darkness;

public class HardcorePlus extends JavaPlugin {

    private static HardcorePlus instance;

    public static HardcorePlus getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        addListener(new MobFocus());
        addListener(new PlayerDeadItemsGone());
        addListener(new PlayerFall());
        addListener(new BlockBreak());
        addListener(new FoodLevelChange());
        addListener(new MobSpawn());
        addListener(new PlayerMove());
        addListener(new Lightning());
        addListener(new WyjebkaE());

        addCommand("chance", new PercentageTest());
        addCommand("wyjebka", new Wyjebka());
        addCommand("wtf", new Wtf());

        darkness();
    }

    void addListener(Listener lis) {
        getServer().getPluginManager().registerEvents(lis, this);
    }

    void addCommand(String command, CommandExecutor exec) {
        Objects.requireNonNull(getCommand(command)).setExecutor(exec);
    }
}
