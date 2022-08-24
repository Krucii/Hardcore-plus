package me.ziomki.hardcoreplus.Lists;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DifficultiesList {
    private static final HashMap<Integer, List<Object>> difficultiesList = new HashMap<>();
    private static Integer ID = 1;
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

    public static HashMap<Integer, List<Object>> getDifficultiesList() {
        return difficultiesList;
    }

    public Double getChance() {
        return chance;
    }

    public int getID() {
        return ID;
    }

    public static ItemStack createDiffList(int key) {

        List lock = DifficultiesList.getDifficultiesList().get(key);

        if (lock == null) {
            ItemStack voidGlass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
            ItemMeta voidGlassMeta = voidGlass.getItemMeta();
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
        diffMeta.setLore(fancyLore(longDesc, key));
        diffMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        diffMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        diffItem.setItemMeta(diffMeta);
        // Ustawianie jej na odpowiednim polu
        return diffItem;
    }

    private static List<String> fancyLore(String string, Integer id) {
        StringBuilder sb = new StringBuilder("\n" + ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "\"" + string + "\"\n");
        int i = 0;

        while (i + 35 < sb.length() && (i = sb.lastIndexOf(" ", i + 35)) != -1)
            sb.replace(i, i + 1, "\n" + ChatColor.DARK_GRAY + "" + ChatColor.ITALIC);

        if (DifficultiesList.getDifficultiesList().get(id).get(0).equals(100.0)) sb.append("\n" + ChatColor.GOLD + "Efekt permamentny");
        else sb.append("\n" + ChatColor.YELLOW + "Szansa wystąpienia: " + ChatColor.GOLD).append(DifficultiesList.getDifficultiesList().get(id).get(0))
                .append("0%");;
        return Arrays.asList(sb.toString().split("\n"));
    }
}
