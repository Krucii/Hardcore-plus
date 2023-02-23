package me.ziomki.hardcoreplus.Modules;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;

import static me.ziomki.hardcoreplus.Modules.ModuleController.enabled_modules;


public abstract class Module {

    @SuppressWarnings("unused")
    public final void execute(Event e) {
        if(enabled_modules.get(this.getClass().getName()))
            onEvent(e);
    }

    public abstract void onEvent(Event e);

    // methods called with enabling and disabling modules, see ModuleController.java
    public void onEnable() {
        Bukkit.getLogger().info("Enabled " + this.getClass().getName());
    }
    public void onDisable() {
        Bukkit.getLogger().info("Disabled " + this.getClass().getName());
    }
}

