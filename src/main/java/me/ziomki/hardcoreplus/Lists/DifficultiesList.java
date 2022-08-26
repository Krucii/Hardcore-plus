package me.ziomki.hardcoreplus.Lists;

import me.ziomki.hardcoreplus.Helpers.GUICreator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class DifficultiesList {
    private static final HashMap<Integer, List<Object>> difficultiesList = new HashMap<>();
    private static Integer ID_1 = 1;
    private static final HashMap<Integer, List<Object>> difficultiesChanceList = new HashMap<>();
    private static Integer ID_2 = 1;
    private static final HashMap<Integer, List<Object>> difficultiesPermamentList = new HashMap<>();
    private static Integer ID_3 = 1;
    private final String shortDesc, longDesc;
    private final Double chance;
    private final Material item;
    private final ChatColor color;


    public DifficultiesList(Double chance, Material item, ChatColor color, String shortDesc, String longDesc) {
        this.chance = chance;
        this.item = item;
        this.color = color;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        addEntry();
        addEntry();
        addEntry();
    }

    private void addEntry() {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chance);
        parameters.add(item);
        parameters.add(color);
        parameters.add(shortDesc);
        parameters.add(longDesc);
        if (chance != 100.0) getDifficultiesChanceList().put(ID_2++, parameters);
        else getDifficultiesPermamentList().put(ID_3++, parameters);
        getDifficultiesList().put(ID_1++, parameters);
    }

    public static HashMap<Integer, List<Object>> getDifficultiesList() {
        return difficultiesList;
    }
    public static HashMap<Integer, List<Object>> getDifficultiesChanceList() {
        return difficultiesChanceList;
    }
    public static HashMap<Integer, List<Object>> getDifficultiesPermamentList() {
        return difficultiesPermamentList;
    }

    public Double getChance() {
        return chance;
    }

    public static ItemStack createDiffIcon(int key, String whatList) {

        List<Object> lock = DifficultiesList.getDifficultiesList().get(key);
        if (Objects.equals(whatList, "permament")) lock = DifficultiesList.getDifficultiesPermamentList().get(key);
        else if (Objects.equals(whatList, "chance")) lock = DifficultiesList.getDifficultiesChanceList().get(key);


        if (lock == null) {
            ItemStack voidGlass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta voidGlassMeta = voidGlass.getItemMeta();
            assert voidGlassMeta != null;
            voidGlassMeta.setDisplayName(" ");
            voidGlass.setItemMeta(voidGlassMeta);

            return voidGlass;
        }

        Double chance = (Double) lock.get(0);
        Material material = (Material) lock.get(1);
        ChatColor color = (ChatColor) lock.get(2);
        String shortDesc = (String) lock.get(3),
                longDesc = (String) lock.get(4);
        // Tworzenie ikonki do menu
        ItemStack diffItem = new ItemStack(material, 1);
        ItemMeta diffMeta = diffItem.getItemMeta(); assert diffMeta != null;
        diffMeta.setDisplayName(color + shortDesc);
        diffMeta.setLore(GUICreator.fancyLore(longDesc, chance));
        diffMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        diffMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        diffItem.setItemMeta(diffMeta);
        // Ustawianie jej na odpowiednim polu
        return diffItem;
    }
}
