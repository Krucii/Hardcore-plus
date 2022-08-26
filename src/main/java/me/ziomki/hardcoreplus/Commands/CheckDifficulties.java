package me.ziomki.hardcoreplus.Commands;

import me.ziomki.hardcoreplus.Lists.DifficultiesList;
import me.ziomki.hardcoreplus.Helpers.GUICreator;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CheckDifficulties implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player p)) return true;

        GUICreator gui = new GUICreator(p, 45, ChatColor.RED + "" + ChatColor.BOLD + "Piekielne utrudnienia");
        gui.fillGlass();

        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.GREEN + "Ta lista zawiera");
        String what = "";
        int size = DifficultiesList.getDifficultiesList().size();
        if (strings.length > 0 && Objects.equals(strings[0], "procentowe")) {
            what = "chance";
            size = DifficultiesList.getDifficultiesChanceList().size();
            lore.add(ChatColor.GREEN + "utrudnienia procentowe");
        }
        else if (strings.length > 0 && Objects.equals(strings[0], "permamentne")) {
            what = "permament";
            size = DifficultiesList.getDifficultiesPermamentList().size();
            lore.add(ChatColor.GREEN + "utrudnienia permamentne");
        }
        else lore.add(ChatColor.GREEN + "wszystkie utrudnienia");

        for (int i = 1; i < 12; i++) {
            ItemStack icon = DifficultiesList.createDiffIcon(i, what);
            gui.addToGUI(icon);
        }
        if (size > 11) {
            gui.addPageInfo(1, lore);
            gui.addNextPage();
        }
        gui.displayInventory();

        return true;
    }


}
