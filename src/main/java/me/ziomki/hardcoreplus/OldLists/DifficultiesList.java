package me.ziomki.hardcoreplus.OldLists;

import me.ziomki.hardcoreplus.Helpers.GUICreator;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public record DifficultiesList(Double chance, Material item, ChatColor color,
                               String shortDesc, String longDesc) {
    private static final HashMap<Integer, List<Object>> difficultiesList = new HashMap<>();
    private static final HashMap<Integer, List<Object>> difficultiesChanceList = new HashMap<>();
    private static final HashMap<Integer, List<Object>> difficultiesPermanentList = new HashMap<>();
    private static Integer main_ID = 1;
    private static Integer chance_ID = 1;
    private static Integer permanent_ID = 1;

    public DifficultiesList(Double chance, Material item, ChatColor color, String shortDesc, String longDesc) {
        this.chance = chance;
        this.item = item;
        this.color = color;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        addEntry();
    }

    public static HashMap<Integer, List<Object>> getDifficultiesList() {
        return difficultiesList;
    }

    public static HashMap<Integer, List<Object>> getDifficultiesChanceList() {
        return difficultiesChanceList;
    }

    public static HashMap<Integer, List<Object>> getDifficultiesPermanentList() {
        return difficultiesPermanentList;
    }

    public static ItemStack createDiffIcon(int key, String whatList) {

        List<Object> lock = DifficultiesList.getDifficultiesList().get(key);
        if (Objects.equals(whatList, "permanent")) lock = DifficultiesList.getDifficultiesPermanentList().get(key);
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

    public static String getDifficultiesCategory(String[] commandArguments) {
        if (commandArguments.length == 0) return "all";
        else if (Objects.equals(commandArguments[0], "procentowe")) return "chance";
        else if (Objects.equals(commandArguments[0], "permanentne")) return "permanent";
        else return "all";
    }

    public static int getSizeOfDifficultiesList(String difficultiesCategory) {
        if (Objects.equals(difficultiesCategory, "procentowe"))
            return DifficultiesList.getDifficultiesChanceList().size();
        else if (Objects.equals(difficultiesCategory, "permanentne"))
            return DifficultiesList.getDifficultiesPermanentList().size();
        else return DifficultiesList.getDifficultiesList().size();
    }

    public static List<String> makePageLore(String difficultiesCategory) {
        List<String> pageLore = new ArrayList<>();
        pageLore.add("");
        pageLore.add(ChatColor.GREEN + "Ta lista zawiera");
        if (!difficultiesCategory.equals("all")) pageLore.add(ChatColor.GREEN + "utrudnienia " + difficultiesCategory);
        else pageLore.add(ChatColor.GREEN + difficultiesCategory + " utrudnienia");
        return pageLore;
    }

    public static void makeIconAnSwitch(ItemStack icon) {
        ItemMeta icon_meta = icon.getItemMeta();
        icon_meta.setDisplayName(icon_meta.getDisplayName() + "");


        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("difficulties_rules.yml"));
            writer.write("Writing to a file.");
            writer.write("\nHere is another line.");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader("difficulties_rules.yml"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addEntry() {
        List<Object> parameters = new ArrayList<>();
        parameters.add(chance);
        parameters.add(item);
        parameters.add(color);
        parameters.add(shortDesc);
        parameters.add(longDesc);
        if (chance != 100.0) getDifficultiesChanceList().put(chance_ID++, parameters);
        else getDifficultiesPermanentList().put(permanent_ID++, parameters);
        getDifficultiesList().put(main_ID++, parameters);
    }

    public Double getChance() {
        return chance;
    }
}
