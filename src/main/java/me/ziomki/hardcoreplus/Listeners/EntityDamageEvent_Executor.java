package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Listeners.EntityDamageEvents.TwistedAnkleEvent;
import me.ziomki.hardcoreplus.Lists.DifficultiesList;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageEvent_Executor implements Listener {

    DifficultiesList gui_icon_1 = new DifficultiesList(5.0, Material.DIRT, org.bukkit.ChatColor.GREEN, "Łamaga", "Pojawia się rosnąca wraz z wysokością szansa na skręcenie kostki podczas upadku.");

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        new TwistedAnkleEvent(e, gui_icon_1);
    }
}
