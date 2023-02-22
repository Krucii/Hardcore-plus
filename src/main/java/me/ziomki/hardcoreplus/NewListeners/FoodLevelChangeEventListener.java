package me.ziomki.hardcoreplus.NewListeners;

import me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import static me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader.executeOnEvent;

public class FoodLevelChangeEventListener implements Listener {

    //DifficultiesList gui_icon_1 = new DifficultiesList(100.0, Material.DEAD_BUSH, ChatColor.GRAY, "Susza", "Zwiększony spadek poziomu nasycenia na pustyni.");

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e) {
        executeOnEvent(ClassLoader.ClassTypes.FoodLevelChange, e);
        //new FoodLevelDowngrade(e, gui_icon_1);
    }
}
