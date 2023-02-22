package me.ziomki.hardcoreplus.Modifications;

import org.bukkit.event.Event;

import java.util.HashMap;

public abstract class Modification {

    @SuppressWarnings("unused")
    public final void execute(Event e) {
        onEvent(e);
    }

    public abstract void onEvent(Event e);
    // on enable i on disable
    // set enabled
}
