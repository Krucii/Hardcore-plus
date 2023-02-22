package me.ziomki.hardcoreplus.NewListeners;

import me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import static me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader.executeOnEvent;

public class CreatureSpawnEventListener implements Listener {

    //DifficultiesList gui_icon_1 = new DifficultiesList(5.0, Material.CREEPER_HEAD, ChatColor.DARK_GREEN, "Bombowa imprezka", "Naelektryzowane creepery nie są już tak rzadkim widokiem.");

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent e) {
        executeOnEvent(ClassLoader.ClassTypes.CreatureSpawn, e);
        //new SpawnPoweredCreepers(e, gui_icon_1);
    }
}
