package me.ziomki.hardcoreplus.Modules.PlayerMove;

import me.ziomki.hardcoreplus.Modules.PluginModule;
import me.ziomki.hardcoreplus.Schedulers.DarknessDamageScheduler;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class DarknessDamage extends PluginModule {
    public static ArrayList<Player> lightDamage = new ArrayList<>();
    @Override
    public void onEvent(Event e) {
        PlayerMoveEvent event = (PlayerMoveEvent) e;
        int light = event.getPlayer().getLocation().getBlock().getLightLevel();

        if (light < 6)
            lightDamage.add(event.getPlayer());
        else
            lightDamage.remove(event.getPlayer());
    }

    @Override
    public void onEnable() {
        super.onEnable();
        DarknessDamageScheduler.start();
    }

    @Override
    public void onDisable() {
        super.onDisable();
        DarknessDamageScheduler.stop();
    }
}
