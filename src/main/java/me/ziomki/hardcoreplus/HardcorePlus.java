package me.ziomki.hardcoreplus;

import me.ziomki.hardcoreplus.Listeners.*;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

import static me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader.loadEventClasses;

public class HardcorePlus extends JavaPlugin {

    private static HardcorePlus instance;

    public static HardcorePlus getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        loadEventClasses();

        addListener(new BlockBreakEventListener());
        addListener(new CreatureSpawnEventListener());
        addListener(new EntityDamageEventListener());
        addListener(new EntityTargetEventListener());
        addListener(new FoodLevelChangeEventListener());
        addListener(new LightningStrikeEventListener());
        addListener(new PlayerDeathEventListener());
        addListener(new PlayerMoveEventListener());

        //ModuleController.setEnabled(BoneBreak.class, false);

//
//        addCommand("chance", new CheckPercentageTest());
//        addCommand("utrudnienia", new CheckDifficulties());
//
//
//        addListener(new GUIClicking());
//
//        darkness();
    }

    void addListener(Listener lis) {
        getServer().getPluginManager().registerEvents(lis, this);
    }

    void addCommand(String command, CommandExecutor exec) {
        Objects.requireNonNull(getCommand(command)).setExecutor(exec);
    }
}
