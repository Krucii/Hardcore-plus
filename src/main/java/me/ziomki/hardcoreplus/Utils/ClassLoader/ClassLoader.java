package me.ziomki.hardcoreplus.Utils.ClassLoader;

import me.ziomki.hardcoreplus.Modules.Module;
import org.bukkit.event.Event;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import static me.ziomki.hardcoreplus.Modules.ModuleController.enabled_modules;
import static me.ziomki.hardcoreplus.Modules.ModuleController.setEnabled;

public class ClassLoader {
    public enum ClassTypes {
        BlockBreak, CreatureSpawn, EntityDamage, EntityTarget, EntityToggleGlide, FoodLevelChange, LightningStrike,
        PlayerDeath, PlayerMove

    }
    private static final Set<Class<? extends Module>>[] eventClasses = new Set[ClassTypes.values().length];

    public static void loadEventClasses() {
        for (ClassTypes type : ClassTypes.values()) {
            eventClasses[type.ordinal()] = new HashSet<>();
            Reflections reflections = new Reflections("me.ziomki.hardcoreplus.Modules." + type);
            // load all clases extended by Module.java from me.ziomki.hardcoreplus.Modules.*
            eventClasses[type.ordinal()] = reflections.getSubTypesOf(Module.class);
            for (Class<?> clazz: eventClasses[type.ordinal()]) {
                // enable all modules
                setEnabled(clazz, true);
            }
        }
    }

    public static void executeOnEvent(ClassTypes t, Event argument) {
        for(var c : eventClasses[t.ordinal()]) {
            try {
                Constructor<?> constructor = c.getConstructor();
                // create instance from constructor and invoke method "execute"
                Object instance = constructor.newInstance();
                Method method = instance.getClass().getMethod("execute", Event.class);
                method.invoke(instance, argument);
            }
            catch (Exception ignored) { }
        }
    }
}