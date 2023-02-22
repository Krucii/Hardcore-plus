package me.ziomki.hardcoreplus.Modifications.EntityDamage;

import me.ziomki.hardcoreplus.Helpers.ActionBarMessage;
import me.ziomki.hardcoreplus.Helpers.ChanceCalculator;
import me.ziomki.hardcoreplus.Modifications.Modification;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BoneBreak extends Modification {
    @Override
    public void onEvent(Event e) {
        EntityDamageEvent event = (EntityDamageEvent) e;
        if (event.getEntity() instanceof Player p) {
            if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
                float fallDistance = p.getFallDistance();
                if (fallDistance < 5) {
                    if (ChanceCalculator.getChance(5))
                        boneBreak(p, 40*20, 2);
                }
                else if (fallDistance < 8 && fallDistance > 5) {
                    if (ChanceCalculator.getChance(5 * 4))
                        boneBreak(p, 80*20, 2);
                }
                else if (fallDistance < 12 && fallDistance > 8) {
                    if (ChanceCalculator.getChance(5 * 8))
                        boneBreak(p, 160*20, 2);
                }
                else {
                    if (ChanceCalculator.getChance(5 * 16))
                        boneBreak(p, 320*20, 3);
                }
            }
        }
    }

    public static void boneBreak(Player p, int dur, int ampl) {
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, dur, ampl));
        ActionBarMessage.sendActionBarMessage(p, ChatColor.RED + "Złamałeś nogę");
    }
}
