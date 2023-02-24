package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Objects;

import static me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader.executeOnEvent;

public class PlayerMoveEventListener implements Listener {

    //DifficultiesList gui_icon_1 = new DifficultiesList(100.0, Material.TORCH, ChatColor.YELLOW, "Egipskie ciemności", "Zbyt mała ilość światła powoduje otrzymywanie obrażeń.");

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        // reduce lag
        if(Objects.requireNonNull(e.getTo()).distanceSquared(e.getFrom()) == 0) return;
        executeOnEvent(ClassLoader.ClassTypes.PlayerMove, e);
    }
}
