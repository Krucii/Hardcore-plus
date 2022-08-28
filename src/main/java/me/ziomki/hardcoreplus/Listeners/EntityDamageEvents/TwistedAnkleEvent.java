package me.ziomki.hardcoreplus.Listeners.EntityDamageEvents;

import me.ziomki.hardcoreplus.Lists.DifficultiesList;
import me.ziomki.hardcoreplus.Helpers.ActionBarMessage;
import me.ziomki.hardcoreplus.Helpers.ChanceCalculator;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TwistedAnkleEvent implements Listener {

    DifficultiesList adding = new DifficultiesList(5.0, Material.DIRT, org.bukkit.ChatColor.GREEN, "Łamaga", "Pojawia się rosnąca wraz z wysokością szansa na skręcenie kostki podczas upadku.");

    @EventHandler
    public void onPlayerFall(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player p) {
            if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
                float fallDistance = p.getFallDistance();
                if (fallDistance < 5) {
                    if (ChanceCalculator.getChance(adding.getChance()))
                        boneBreak(p, 40*20, 2);
                }
                else if (fallDistance < 8 && fallDistance > 5) {
                    if (ChanceCalculator.getChance(adding.getChance() * 4))
                        boneBreak(p, 80*20, 2);
                }
                else if (fallDistance < 12 && fallDistance > 8) {
                    if (ChanceCalculator.getChance(adding.getChance() * 8))
                        boneBreak(p, 160*20, 2);
                }
                else {
                    if (ChanceCalculator.getChance(adding.getChance() * 16))
                        boneBreak(p, 320*20, 3);
                }
            }
        }
    }

    public void boneBreak(Player p, int dur, int ampl) {
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, dur, ampl));
        ActionBarMessage.sendActionBarMessage(p, ChatColor.RED + "Złamałeś nogę");
    }
}
