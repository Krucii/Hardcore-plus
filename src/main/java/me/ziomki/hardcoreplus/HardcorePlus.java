package me.ziomki.hardcoreplus;

import me.ziomki.hardcoreplus.Commands.InfoCommand;
import me.ziomki.hardcoreplus.Helpers.DatabaseController.Database;
import me.ziomki.hardcoreplus.Helpers.DatabaseController.SQLite;
import me.ziomki.hardcoreplus.Helpers.RecordMaker;
import me.ziomki.hardcoreplus.Listeners.*;
import me.ziomki.hardcoreplus.Commands.DifficultiesManagerCommand;
import me.ziomki.hardcoreplus.Schedulers.DarknessDamageScheduler;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.Objects;

import static me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader.loadEventClasses;

public class HardcorePlus extends JavaPlugin {

    private static HardcorePlus instance;

    public static HardcorePlus getInstance() {
        return instance;
    }

    private static Database db;

    @Override
    public void onEnable() {
        instance = this;

        if (!instance.getDataFolder().exists()) {
            try {
                Files.createDirectory(instance.getDataFolder().toPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        db = new SQLite(this);
        db.load();

        loadEventClasses();

        addListener(new BlockBreakEventListener());
        addListener(new CreatureSpawnEventListener());
        addListener(new EntityDamageEventListener());
        addListener(new EntityTargetEventListener());
        addListener(new FoodLevelChangeEventListener());
        addListener(new InventoryClickEventListener());
        addListener(new LightningStrikeEventListener());
        addListener(new PlayerDeathEventListener());
        addListener(new PlayerJoinEventListener());
        addListener(new PlayerMoveEventListener());

        DarknessDamageScheduler.start();
        RecordMaker.addAll();

        addCommand("utrudnienia", new DifficultiesManagerCommand());
        addCommand("info", new InfoCommand());
    }

    @Override
    public void onDisable() {
        DarknessDamageScheduler.stop();
    }

    public static Database getDatabase() {
        return db;
    }

    void addListener(Listener lis) {
        getServer().getPluginManager().registerEvents(lis, this);
    }

    void addCommand(String command, CommandExecutor exec) {
        Objects.requireNonNull(getCommand(command)).setExecutor(exec);
    }
}
