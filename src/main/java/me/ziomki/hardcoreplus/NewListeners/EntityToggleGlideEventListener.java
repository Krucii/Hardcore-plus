package me.ziomki.hardcoreplus.NewListeners;

import me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;

import static me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader.executeOnEvent;

public class EntityToggleGlideEventListener implements Listener {

    // Do wystylowania
    //DifficultiesList gui_icon_1 = new DifficultiesList(100.0, Material.POTION, ChatColor.AQUA, "Głodne poczwary", "Wszystkie goniące graczy potwory są szybsze.");

    @EventHandler
    public void onEntityToggleGlide(EntityToggleGlideEvent e) {
        executeOnEvent(ClassLoader.ClassTypes.EntityToggleGlide, e);
        //new RandomFallingDown(e, gui_icon_1);
    }
}
