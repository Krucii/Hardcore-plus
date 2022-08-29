package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Listeners.EntityTargetEvents.VeryFastMonsters;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

public class EntityTargetEvent_Executor implements Listener {

    @EventHandler
    public void onEntityTarget(EntityTargetEvent e) {
        VeryFastMonsters.onMonsterAttack(e);
    }
}
