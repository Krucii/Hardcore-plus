package me.ziomki.hardcoreplus.Commands;

import me.ziomki.hardcoreplus.DifficultiesList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ChanceListTest implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player p)) return true;
        Inventory hardcoreMenu = Bukkit.createInventory(p, 45, ChatColor.RED + "Piekielne utrudnienia");
        AtomicInteger firstGap = new AtomicInteger(10);

        // 0 - chance, 1 - material, 2 - color, 3 - short, 4 - long

        DifficultiesList.getDifficultiesList().forEach((k, v) -> {
            ItemStack diffItem = new ItemStack((Material) v.get(1), 1);
            ItemMeta diffMeta = diffItem.getItemMeta();
            assert diffMeta != null;
            diffMeta.setDisplayName(v.get(2) + (String) v.get(3));
            diffMeta.setLore(WordWrapLore((String) v.get(4), k));
            diffMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
            diffMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            diffItem.setItemMeta(diffMeta);
            hardcoreMenu.setItem(firstGap.get(), diffItem);
            if (firstGap.get() == 16) firstGap.addAndGet(4);
            else if (firstGap.get() == 24) firstGap.addAndGet(4);
            else firstGap.addAndGet(2);
        });


        p.openInventory(hardcoreMenu);
        return true;
    }

    public List<String> WordWrapLore(String string, Integer id)
    {
        StringBuilder sb = new StringBuilder("\n" + ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "\"" + string + "\"\n");

        int i = 0;
        while (i + 35 < sb.length() && (i = sb.lastIndexOf(" ", i + 35)) != -1) {
            sb.replace(i, i + 1, "\n" + ChatColor.DARK_GRAY + "" + ChatColor.ITALIC);
        }

        sb.append("\n" + ChatColor.YELLOW + "Szansa wystąpienia: " + ChatColor.GOLD).append(DifficultiesList.getDifficultiesList().get(id).get(0)).append("0%");
        return Arrays.asList(sb.toString().split("\n"));

    }
}
