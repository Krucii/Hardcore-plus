package me.ziomki.hardcoreplus.Modules.PlayerDeath;

import me.ziomki.hardcoreplus.HardcorePlus;
import me.ziomki.hardcoreplus.Helpers.DatabaseController.Database;
import me.ziomki.hardcoreplus.Modules.PluginModule;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.sql.SQLException;

public class KillDeathCounter extends PluginModule {
    @Override
    public void onEvent(Event e) {
        PlayerDeathEvent event = (PlayerDeathEvent) e;
        Database db = HardcorePlus.getDatabase();

        Player dead = event.getEntity();
        Player killer = dead.getKiller();

        if (killer != null) {
            try { db.addToStats(killer.getName(), Database.Stat.kills); }
            catch (SQLException ignored) {}
        }

        try { db.addToStats(dead.getName(), Database.Stat.deaths); }
        catch (SQLException ignored) {}
    }
}
