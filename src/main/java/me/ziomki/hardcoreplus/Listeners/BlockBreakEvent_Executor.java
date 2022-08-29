package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Listeners.BlockBreakEvents.FastBreakingTools;
import me.ziomki.hardcoreplus.Lists.DifficultiesList;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakEvent_Executor implements Listener {

    DifficultiesList gui_icon_1 = new DifficultiesList(30.0, Material.IRON_AXE, ChatColor.GRAY, "Liche narzędzia", "Narzędzia zużywają się szybciej.");

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        new FastBreakingTools(e, gui_icon_1);
    }
}
