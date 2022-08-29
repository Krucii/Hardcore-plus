package me.ziomki.hardcoreplus.Listeners.EntityTargetEvents;

import me.ziomki.hardcoreplus.Lists.DifficultiesList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Monster;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class VeryFastMonsters {

    public VeryFastMonsters(EntityTargetEvent e, DifficultiesList icon_parameters) {
        if (!(e.getEntity() instanceof Monster entity)) return;
        if ((e.getEntity() instanceof Creeper)) return;
        PotionEffect drug = new PotionEffect(PotionEffectType.SPEED, 20*20, 2);
        entity.addPotionEffect(drug);
    }
}
