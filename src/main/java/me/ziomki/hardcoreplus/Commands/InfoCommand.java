package me.ziomki.hardcoreplus.Commands;

import me.ziomki.hardcoreplus.HardcorePlus;
import me.ziomki.hardcoreplus.Helpers.BookMaker;
import me.ziomki.hardcoreplus.Helpers.DatabaseController.Stats;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.SQLException;
import java.util.Objects;

public class InfoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player p)) return false;
        if (args.length != 1) return false;

        Stats stat;
        try {
            stat = HardcorePlus.getDatabase().getAll(Objects.requireNonNull(Bukkit.getPlayer(args[0])));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        BookMaker bm = new BookMaker("Plugin", "Stats");
        bm.addPage(ChatColor.BOLD + stat.getPlayer());

        p.openBook(bm.getItemStack());


        return true;
    }
}
