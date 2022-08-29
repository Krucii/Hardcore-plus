package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Listeners.PlayerMoveEvents.DangerousDarkness;
import me.ziomki.hardcoreplus.Lists.DifficultiesList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveEvent_Executor implements Listener {

    DifficultiesList gui_icon_1 = new DifficultiesList(100.0, Material.TORCH, ChatColor.YELLOW, "Egipskie ciemności", "Zbyt mała ilość światła powoduje otrzymywanie obrażeń.");

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        new DangerousDarkness(e, gui_icon_1);
    }
}
