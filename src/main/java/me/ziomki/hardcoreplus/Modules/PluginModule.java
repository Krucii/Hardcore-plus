package me.ziomki.hardcoreplus.Modules;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;

public abstract class PluginModule {

    @SuppressWarnings("unused")
    public final void execute(Event e) {
        if (PluginModuleController.getEnabled(this.getClass()))
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

