package me.ziomki.hardcoreplus.Listeners;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MobFocus implements Listener {

    @EventHandler
    public void onAttack(EntityTargetEvent e) {
        if (!(e instanceof Monster)) return;
        Monster mob = (Monster) e;
        PotionEffect drug = new PotionEffect(PotionEffectType.SPEED, 20*20, 2);
        mob.addPotionEffect(drug);
    }
}
