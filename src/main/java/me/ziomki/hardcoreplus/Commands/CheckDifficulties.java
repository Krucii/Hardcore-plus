package me.ziomki.hardcoreplus.Commands;

import me.ziomki.hardcoreplus.Lists.DifficultiesList;
import me.ziomki.hardcoreplus.Helpers.GUICreator;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CheckDifficulties implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player p)) return true;

        GUICreator gui = new GUICreator(p, 45, ChatColor.RED + "" + ChatColor.BOLD + "Piekielne utrudnienia");
        gui.fillGlass();

        for (int i = 1; i < 12; i++) {
            ItemStack icon = DifficultiesList.createDiffList(i);
            gui.addToGUI(icon);
        }
        if (DifficultiesList.getDifficultiesList().size() > 11) {
            gui.addPageInfo(1);
            gui.addNextPage();
        }
        gui.displayInventory();
        return true;
    }


}
