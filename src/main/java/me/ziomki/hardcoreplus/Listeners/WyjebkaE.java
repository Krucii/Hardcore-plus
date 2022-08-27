package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Commands.Wyjebka;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;

public class WyjebkaE implements Listener {

    @EventHandler
    public void onGlide(EntityToggleGlideEvent e) {
        if (e.getEntity() instanceof Player p) {
            if (Wyjebka.wyjebany.contains(p))
                if (!e.isGliding())
                    e.setCancelled(true);
        }
    }
}
