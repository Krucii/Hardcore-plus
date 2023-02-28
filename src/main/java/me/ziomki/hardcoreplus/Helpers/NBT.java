package me.ziomki.hardcoreplus.Helpers;

import me.ziomki.hardcoreplus.HardcorePlus;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class NBT {

    public static boolean check(ItemStack item, String NBT_key_name, PersistentDataType NBT_value_type) {
        return item.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(HardcorePlus.getInstance(), NBT_key_name), NBT_value_type);
    }

    public static Object getValue(ItemStack item, String NBT_key_name, PersistentDataType NBT_value_type) {
        return item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(HardcorePlus.getInstance(), NBT_key_name), NBT_value_type);
    }
}
