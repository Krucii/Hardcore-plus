package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Listeners.EntityToggleGlideEvents.RandomFallingDown;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;

public class EntityToggleGlideEvent_Executor implements Listener {

    @EventHandler
    public void onEntityToggleGlide(EntityToggleGlideEvent e) {
        RandomFallingDown.onFall(e);
    }
}
