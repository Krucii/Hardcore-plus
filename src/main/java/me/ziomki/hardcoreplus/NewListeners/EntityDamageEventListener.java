package me.ziomki.hardcoreplus.NewListeners;

import me.ziomki.hardcoreplus.Modifications.EntityDamage.BoneBreak;
import me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import static me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader.executeOnEvent;

public class EntityDamageEventListener implements Listener {

    //DifficultiesList gui_icon_1 = new DifficultiesList(5.0, Material.DIRT, org.bukkit.ChatColor.GREEN, "Łamaga", "Pojawia się rosnąca wraz z wysokością szansa na skręcenie kostki podczas upadku.");

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e) {
        executeOnEvent(ClassLoader.ClassTypes.EntityDamage, e);
    }
}
