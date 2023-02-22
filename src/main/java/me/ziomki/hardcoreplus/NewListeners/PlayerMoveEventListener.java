package me.ziomki.hardcoreplus.NewListeners;

import me.ziomki.hardcoreplus.Listeners.PlayerMoveEvents.DangerousDarkness;
import me.ziomki.hardcoreplus.Lists.DifficultiesList;
import me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import static me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader.executeOnEvent;

public class PlayerMoveEventListener implements Listener {

    //DifficultiesList gui_icon_1 = new DifficultiesList(100.0, Material.TORCH, ChatColor.YELLOW, "Egipskie ciemności", "Zbyt mała ilość światła powoduje otrzymywanie obrażeń.");

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        executeOnEvent(ClassLoader.ClassTypes.PlayerMove, e);
    }
}
