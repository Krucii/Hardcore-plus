package me.ziomki.hardcoreplus;

import me.ziomki.hardcoreplus.Commands.Wyjebka;
import me.ziomki.hardcoreplus.Commands.CheckDifficulties;
import me.ziomki.hardcoreplus.Commands.CheckPercentageTest;
import me.ziomki.hardcoreplus.Events.GUIClicking;
import me.ziomki.hardcoreplus.Listeners.BlockBreakEvent_Executor;
import me.ziomki.hardcoreplus.Listeners.BlockBreakEvents.FastBreakingTools;
import me.ziomki.hardcoreplus.Listeners.CreatureSpawnEvent_Executor;
import me.ziomki.hardcoreplus.Listeners.CreatureSpawnEvents.SpawnPoweredCreepers;
import me.ziomki.hardcoreplus.Listeners.EntityDamageEvents.TwistedAnkleEvent;
import me.ziomki.hardcoreplus.Listeners.EntityTargetEvents.VeryFastMonsters;
import me.ziomki.hardcoreplus.Listeners.EntityToggleGlideEvents.WyjebkaE;
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

        addListener(new VeryFastMonsters());
        addListener(new DeathEraseItems());
        addListener(new TwistedAnkleEvent());
        addListener(new BlockBreakEvent_Executor());
        addListener(new FoodLevelDowngrade());
        addListener(new CreatureSpawnEvent_Executor());
        addListener(new DangerousDarkness());
        addListener(new HugeLightningTarget());
        addListener(new WyjebkaE());

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
