package me.ziomki.hardcoreplus.Modifications.EntityTarget;

import me.ziomki.hardcoreplus.Modifications.Modification;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Monster;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FasterMonsters extends Modification {
    public static boolean enabled = true;
    @Override
    public void onEvent(Event e) {
        if (!enabled) return;
        EntityTargetEvent event = (EntityTargetEvent) e;
        if (!(event.getEntity() instanceof Monster entity)) return;
        if ((event.getEntity() instanceof Creeper)) return;
        PotionEffect drug = new PotionEffect(PotionEffectType.SPEED, 20*20, 2);
        entity.addPotionEffect(drug);
    }
}
