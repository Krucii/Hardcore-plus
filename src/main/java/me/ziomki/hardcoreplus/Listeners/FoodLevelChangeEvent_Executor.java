package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Listeners.FoodLevelChangeEvents.FoodLevelDowngrade;
import me.ziomki.hardcoreplus.Lists.DifficultiesList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChangeEvent_Executor implements Listener {

    DifficultiesList gui_icon_1 = new DifficultiesList(100.0, Material.DEAD_BUSH, ChatColor.GRAY, "Susza", "Zwiększony spadek poziomu nasycenia na pustyni.");

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e) {
        new FoodLevelDowngrade(e, gui_icon_1);
    }
}
