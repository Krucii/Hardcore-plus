package me.ziomki.hardcoreplus.Utils.ClassLoader;

import me.ziomki.hardcoreplus.Modifications.Modification;
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
    private static Set<Class<? extends Modification>>[] eventClasses = new Set[ClassTypes.values().length];

    public static void loadEventClasses() {
        for (ClassTypes type : ClassTypes.values()) {
            eventClasses[type.ordinal()] = new HashSet<>();
            Reflections reflections = new Reflections("me.ziomki.hardcoreplus.Modifications." + type, new SubTypesScanner(false));
            eventClasses[type.ordinal()] = reflections.getSubTypesOf(Modification.class);
        }
    }

    public static void executeOnEvent(ClassTypes t, Event argument) {
        for(var c : eventClasses[t.ordinal()]) {
            try {
                Constructor<?> constructor = c.getConstructor();
                Object instance = constructor.newInstance();
                Method method = instance.getClass().getMethod("execute", Event.class);
                method.invoke(instance, argument);
            }
            catch (Exception ex) {

            }
        }
    }
}
