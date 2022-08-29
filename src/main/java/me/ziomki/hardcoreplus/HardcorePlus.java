package me.ziomki.hardcoreplus;

import me.ziomki.hardcoreplus.Commands.Wyjebka;
import me.ziomki.hardcoreplus.Commands.CheckDifficulties;
import me.ziomki.hardcoreplus.Commands.CheckPercentageTest;
import me.ziomki.hardcoreplus.Events.GUIClicking;
import me.ziomki.hardcoreplus.Listeners.*;
import me.ziomki.hardcoreplus.Listeners.EntityTargetEvents.VeryFastMonsters;
import me.ziomki.hardcoreplus.Listeners.EntityToggleGlideEvents.RandomFallingDown;
import me.ziomki.hardcoreplus.Listeners.FoodLevelChangeEvents.FoodLevelDowngrade;
import me.ziomki.hardcoreplus.Listeners.LightningStrikeEvents.HugeLightningTarget;
import me.ziomki.hardcoreplus.Listeners.PlayerDeathEvents.DeathEraseItems;
import me.ziomki.hardcoreplus.Listeners.PlayerMoveEvents.DangerousDarkness;
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

        addListener(new BlockBreakEvent_Executor());
        addListener(new CreatureSpawnEvent_Executor());
        addListener(new EntityDamageEvent_Executor());
        addListener(new EntityTargetEvent_Executor());
        addListener(new EntityToggleGlideEvent_Executor());
        addListener(new FoodLevelChangeEvent_Executor());
        addListener(new LightningStrikeEvent_Executor());
        addListener(new PlayerDeathEvent_Executor());
        addListener(new PlayerMoveEvent_Executor());

        addCommand("chance", new CheckPercentageTest());
        addCommand("utrudnienia", new CheckDifficulties());
        
        addCommand("wyjebka", new Wyjebka()); //test command

        addListener(new GUIClicking());

        darkness();
    }

    void addListener(Listener lis) {
        getServer().getPluginManager().registerEvents(lis, this);
    }

    void addCommand(String command, CommandExecutor exec) {
        Objects.requireNonNull(getCommand(command)).setExecutor(exec);
    }
}
