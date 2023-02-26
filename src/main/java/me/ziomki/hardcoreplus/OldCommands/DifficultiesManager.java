package me.ziomki.hardcoreplus.OldCommands;

import me.ziomki.hardcoreplus.Helpers.GUICreator;
import me.ziomki.hardcoreplus.OldLists.DifficultiesList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DifficultiesManager implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player p)) return true;

        GUICreator difficultiesGUI = new GUICreator(p, 45, ChatColor.RED + "" + ChatColor.BOLD + "Piekielne utrudnienia");
        difficultiesGUI.fillGlass();
        difficultiesGUI.addPageInfo(1);

        int sizeOfDifficultiesList = DifficultiesList.difficultiesList.size();

        if (sizeOfDifficultiesList > 11) difficultiesGUI.addNextPageButton();

        for (int i = 1; i < 12; i++) {
            ItemStack icon = DifficultiesList.makeItem(i);
            difficultiesGUI.addToGUI(icon);
        }

        difficultiesGUI.displayGUI();
        return true;
    }
}
