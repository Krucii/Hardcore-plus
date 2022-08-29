package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Listeners.PlayerDeathEvents.DeathEraseItems;
import me.ziomki.hardcoreplus.Lists.DifficultiesList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathEvent_Executor implements Listener {

    DifficultiesList gui_icon_1 = new DifficultiesList(100.0, Material.CANDLE, ChatColor.DARK_PURPLE, "Bolesna śmierć", "Podczas śmierci połowa przedmiotów znika.");

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        new DeathEraseItems(e, gui_icon_1);
    }
}
