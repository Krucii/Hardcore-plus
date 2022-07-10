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
        LivingEntity entity = (LivingEntity) e.getEntity();
        if (!(entity instanceof Monster)) return;
        PotionEffect drug = new PotionEffect(PotionEffectType.SPEED, 20*20, 2);
        entity.addPotionEffect(drug);
    }
}
