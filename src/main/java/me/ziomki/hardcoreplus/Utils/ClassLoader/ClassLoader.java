package me.ziomki.hardcoreplus.Utils.ClassLoader;

import org.bukkit.event.Event;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class ClassLoader {
    public enum ClassTypes {
        BlockBreak, CreatureSpawn, EntityDamage, EntityTarget, EntityToggleGlide, FoodLevelChange, LightningStrike,
        PlayerDeath, PlayerMove;

    }
    private static Set<Class<?>>[] eventClasses = new Set[ClassTypes.values().length];

    public static void loadEventClasses() {
        for (ClassTypes type : ClassTypes.values()) {
            eventClasses[type.ordinal()] = new HashSet<>();
            Reflections reflections = new Reflections("me.ziomki.hardcoreplus.Modifications." + type, new SubTypesScanner(false));
            eventClasses[type.ordinal()] = reflections.getSubTypesOf(Object.class);
        }
    }

    public static void executeOnEvent(ClassTypes t, Event argument) {
        for(var c : eventClasses[t.ordinal()]) {
            try {
                Constructor<?> constructor = c.getConstructor();
                Object instance = constructor.newInstance();
                Method method = instance.getClass().getDeclaredMethod("onEvent", Event.class);
                method.invoke(instance, argument);
            }
            catch (Exception ex) {
                // hehe
            }
        }
    }
}
