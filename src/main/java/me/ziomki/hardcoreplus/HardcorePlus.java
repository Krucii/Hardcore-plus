package me.ziomki.hardcoreplus;

import me.ziomki.hardcoreplus.Commands.PercentageTest;
import me.ziomki.hardcoreplus.Listeners.MobFocus;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class HardcorePlus extends JavaPlugin {

    @Override
    public void onEnable() {
        addListener(new MobFocus());
        addCommand("chance", new PercentageTest());
    }

    void addListener(Listener lis) {
        getServer().getPluginManager().registerEvents(lis, this);
    }

    void addCommand(String command, CommandExecutor exec) {
        Objects.requireNonNull(getCommand(command)).setExecutor(exec);
    }
}
