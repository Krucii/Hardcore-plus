package me.ziomki.hardcoreplus.Modules;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;

public class PluginModuleController {
    private static final HashMap<String, Boolean> enabled_modules = new HashMap<>();

    @SuppressWarnings("unused")
    public static void setEnabled(Class<?> c, Boolean e) {
        enabled_modules.put(c.getName(), e);
        try {
            Constructor<?> constructor = c.getConstructor();
            Object instance = constructor.newInstance();
            Method method;
            // execute method on disable or on enable
            if (e) method = instance.getClass().getMethod("onEnable");
            else method = instance.getClass().getMethod("onDisable");
            method.invoke(instance);

        } catch (Exception ignored) { }
    }

    public static Boolean getEnabled(Class<?> c) {
        return enabled_modules.get(c.getName());
    }
}
