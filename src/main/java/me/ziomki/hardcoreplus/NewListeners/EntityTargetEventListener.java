package me.ziomki.hardcoreplus.NewListeners;

import me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

import static me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader.executeOnEvent;

public class EntityTargetEventListener implements Listener {

    //DifficultiesList gui_icon_1 = new DifficultiesList(100.0, Material.POTION, ChatColor.AQUA, "Głodne poczwary", "Wszystkie goniące graczy potwory są szybsze.");

    @EventHandler
    public void onEntityTarget(EntityTargetEvent e) {
        executeOnEvent(ClassLoader.ClassTypes.EntityTarget, e);
        //new VeryFastMonsters(e, gui_icon_1);
    }
}
