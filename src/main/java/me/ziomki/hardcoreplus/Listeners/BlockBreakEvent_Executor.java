package me.ziomki.hardcoreplus.Listeners;

import me.ziomki.hardcoreplus.Listeners.BlockBreakEvents.FastBreakingTools;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakEvent_Executor implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        FastBreakingTools.fastBreaking(e);
    }
}
