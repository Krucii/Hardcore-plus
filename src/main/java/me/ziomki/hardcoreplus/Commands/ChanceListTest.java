package me.ziomki.hardcoreplus.Commands;

import me.ziomki.hardcoreplus.DifficultiesList;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ChanceListTest implements CommandExecutor {

    DifficultiesList checking = new DifficultiesList();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage(DifficultiesList.getDifficultiesList().toString());
        return false;
    }
}
