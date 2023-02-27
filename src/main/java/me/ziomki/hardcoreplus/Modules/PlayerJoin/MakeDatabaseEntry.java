package me.ziomki.hardcoreplus.Modules.PlayerJoin;

import me.ziomki.hardcoreplus.HardcorePlus;
import me.ziomki.hardcoreplus.Modules.PluginModule;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.SQLException;

public class MakeDatabaseEntry extends PluginModule {
    @Override
    public void onEvent(Event e) {
        PlayerJoinEvent event = (PlayerJoinEvent) e;
        Player p = event.getPlayer();
        try {
            if (HardcorePlus.getDatabase().playerExists(p.getName()) == 0) {
                HardcorePlus.getDatabase().addToDatabase(p.getName());
            }
        } catch (SQLException ignored) {
        }
    }
}
