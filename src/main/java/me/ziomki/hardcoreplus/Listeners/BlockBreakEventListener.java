package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import static me.ziomki.hardcoreplus.Utils.ClassLoader.ClassLoader.executeOnEvent;

public class BlockBreakEventListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        executeOnEvent(ClassLoader.ClassTypes.BlockBreak, e);
    }
}