package me.ziomki.hardcoreplus.OldLists;

import me.ziomki.hardcoreplus.HardcorePlus;
import me.ziomki.hardcoreplus.Helpers.GUICreator;
import me.ziomki.hardcoreplus.Helpers.NBT;
import me.ziomki.hardcoreplus.Modules.PluginModuleController;
import me.ziomki.hardcoreplus.Schedulers.DarknessDamageScheduler;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public record DifficultiesList(Double chance, Material material, ChatColor color,
                               String shortDesc, String longDesc, Class<?> classPointer) {

    public static final HashMap<Integer, List<Object>> difficultiesList = new HashMap<>();
    private static Integer ID = 1;

    public DifficultiesList(Double chance, Material material, ChatColor color,
                            String shortDesc, String longDesc, Class<?> classPointer) {
        this.chance = chance;
        this.material = material;
        this.color = color;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.classPointer = classPointer;

        addEntry();
    }

    public static ItemStack makeItem(Integer item_ID) {
        List<Object> item_parameters = DifficultiesList.getDifficultiesList().get(item_ID);
        if (item_parameters == null) return GUICreator.getVoidGlass();

        // Getting parameters
        Double chance = (Double) item_parameters.get(0);
        Material material = (Material) item_parameters.get(1);
        ChatColor color = (ChatColor) item_parameters.get(2);
        String shortDesc = (String) item_parameters.get(3),
                longDesc = (String) item_parameters.get(4);
        Class<?> classPointer = (Class<?>) item_parameters.get(5);

        // Creating icon
        ItemStack diffItem = new ItemStack(material, 1);
        ItemMeta diffMeta = diffItem.getItemMeta();
        assert diffMeta != null;
        diffMeta.setDisplayName(color + shortDesc + checkStatus(classPointer));
        diffMeta.setLore(GUICreator.fancyLore(longDesc, chance));
        diffMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        diffMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        PersistentDataContainer nbt = diffMeta.getPersistentDataContainer();
        nbt.set(new NamespacedKey(HardcorePlus.getInstance(), "ID"), PersistentDataType.INTEGER, item_ID);
        diffItem.setItemMeta(diffMeta);
        return diffItem;
    }

    // Checks if clicked difficulty is ON or OFF
    public static String checkStatus(Class<?> classPointer) {
        Boolean status;
        if (classPointer == DarknessDamageScheduler.class) status = DarknessDamageScheduler.running;
        else status = PluginModuleController.getEnabled(classPointer);

        if (status) return " - " + ChatColor.GREEN + "włączone";
        else return " - " + ChatColor.RED + "wyłączone";
    }

    // Returns list of ID's and parameters for them that allows to create icon
    public static HashMap<Integer, List<Object>> getDifficultiesList() {
        return difficultiesList;
    }

    // Adds entry to the HashMap
    private void addEntry() {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chance);
        parameters.add(material);
        parameters.add(color);
        parameters.add(shortDesc);
        parameters.add(longDesc);
        parameters.add(classPointer);

        getDifficultiesList().put(ID++, parameters);
    }
}
