package me.ziomki.hardcoreplus.Utils.ClassLoader;

import me.ziomki.hardcoreplus.Modules.PluginModule;
import org.bukkit.event.Event;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import static me.ziomki.hardcoreplus.Modules.PluginModuleController.setEnabled;

public class ClassLoader {
    private static final Set<Class<? extends PluginModule>>[] eventClasses = new Set[ClassTypes.values().length];

    public static void loadEventClasses() {
        for (ClassTypes type : ClassTypes.values()) {
            eventClasses[type.ordinal()] = new HashSet<>();
            Reflections reflections = new Reflections("me.ziomki.hardcoreplus.Modules." + type);
            // load all clases extended by Module.java from me.ziomki.hardcoreplus.Modules.*
            eventClasses[type.ordinal()] = reflections.getSubTypesOf(PluginModule.class);
            for (Class<?> clazz : eventClasses[type.ordinal()]) {
                // enable all modules
                setEnabled(clazz, true);
            }
        }
    }

    public static void executeOnEvent(ClassTypes t, Event argument) {
        for (var c : eventClasses[t.ordinal()]) {
            try {
                Constructor<?> constructor = c.getConstructor();
                // create instance from constructor and invoke method "execute"
                Object instance = constructor.newInstance();
                Method method = instance.getClass().getMethod("execute", Event.class);
                method.invoke(instance, argument);
            } catch (Exception ignored) {
            }
        }
    }

    public enum ClassTypes {
        BlockBreak, CreatureSpawn, EntityAirChange, EntityDamage, EntityTarget, FoodLevelChange, InventoryClick, LightningStrike,
        PlayerDeath, PlayerJoin, PlayerMove
    }
}