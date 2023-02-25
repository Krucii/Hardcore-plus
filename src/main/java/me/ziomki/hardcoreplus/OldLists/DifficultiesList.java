package me.ziomki.hardcoreplus.OldLists;

import me.ziomki.hardcoreplus.Helpers.GUICreator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public record DifficultiesList(Double chance, Material item, ChatColor color,
                               String shortDesc, String longDesc) {

    private static final HashMap<Integer, List<Object>> difficultiesList = new HashMap<>();
    private static Integer ID = 1;

    public DifficultiesList(Double chance, Material item, ChatColor color, String shortDesc, String longDesc) {
        this.chance = chance;
        this.item = item;
        this.color = color;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        addEntry();
    }

    private void addEntry() {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chance);
        parameters.add(item);
        parameters.add(color);
        parameters.add(shortDesc);
        parameters.add(longDesc);
        getDifficultiesList().put(ID++, parameters);
    }

    public static ItemStack createDiffIcon(int key) {

        List<Object> lock = DifficultiesList.getDifficultiesList().get(key);

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
        ItemMeta diffMeta = diffItem.getItemMeta();
        assert diffMeta != null;
        diffMeta.setDisplayName(color + shortDesc);
        diffMeta.setLore(GUICreator.fancyLore(longDesc, chance));
        diffMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        diffMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        diffItem.setItemMeta(diffMeta);
        // Ustawianie jej na odpowiednim polu
        return diffItem;
    }

    public static int getSizeOfDifficultiesList() {
        return DifficultiesList.getDifficultiesList().size();
    }

    public static HashMap<Integer, List<Object>> getDifficultiesList() {
        return difficultiesList;
    }
}
