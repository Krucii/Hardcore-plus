package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import static me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader.executeOnEvent;

public class BlockBreakEventListener implements Listener {

    //DifficultiesList gui_icon_1 = new DifficultiesList(30.0, Material.IRON_AXE, ChatColor.GRAY, "Liche narzędzia", "Narzędzia zużywają się szybciej.");

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        executeOnEvent(ClassLoader.ClassTypes.BlockBreak, e);
    }
}