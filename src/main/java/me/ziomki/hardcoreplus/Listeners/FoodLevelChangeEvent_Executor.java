package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Listeners.FoodLevelChangeEvents.FoodLevelDowngrade;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChangeEvent_Executor implements Listener {

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e) {
        FoodLevelDowngrade.onDrought(e);
    }
}
