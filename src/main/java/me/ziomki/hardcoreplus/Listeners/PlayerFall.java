package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Helpers.ActionBarMessage;
import me.ziomki.hardcoreplus.Helpers.Chance;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerFall implements Listener {

    @EventHandler
    public void onPlayerFall(EntityDamageEvent e) {
        if (e.getEntity().getType() == EntityType.PLAYER) {
            if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
                float fallDistance = e.getEntity().getFallDistance();
                if (fallDistance < 5) {
                    if (Chance.chance(5))
                        boneBreak((Player)e.getEntity(), 40*20, 2);
                }
                else if (fallDistance < 8 && fallDistance > 5) {
                    if (Chance.chance(20))
                        boneBreak((Player)e.getEntity(), 80*20, 2);
                }
                else if (fallDistance < 12 && fallDistance > 8) {
                    if (Chance.chance(40))
                        boneBreak((Player)e.getEntity(), 160*20, 2);
                }
                else {
                    if (Chance.chance(80))
                        boneBreak((Player)e.getEntity(), 320*20, 3);
                }
            }
        }
    }

    public void boneBreak(Player p, int dur, int ampl) {
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, dur, ampl));
        ActionBarMessage.sendActionBarMessage(p, ChatColor.RED + "Zlamales noge");
    }
}
