package me.ziomki.hardcoreplus.Commands;

import me.ziomki.hardcoreplus.HardcorePlus;
import me.ziomki.hardcoreplus.Helpers.BookHelper.Book;
import me.ziomki.hardcoreplus.Helpers.BookHelper.Page;
import me.ziomki.hardcoreplus.Helpers.DatabaseController.Database;
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
        String infoTarget;
        if (args.length != 1)
            infoTarget = p.getName();
        else
            infoTarget = args[0];

        Database db = HardcorePlus.getDatabase();

        Stats stat = new Stats();

        try {
            if (db.playerExists(infoTarget) == 1)
                stat = db.getAll(infoTarget);
            else {
                p.sendMessage(ChatColor.GOLD + "Nie znaleziono gracza " + ChatColor.RED + infoTarget);
                return true;
            }
        } catch (SQLException ignored) {
        }

        Book bm = new Book("Plugin", "Stats");
        Page page = new Page();
        page.addText("Statystyki gracza " + stat.getPlayer());
        page.addText(""); // przerwa
        page.addText("Zabójstwa: " + stat.getKills());
        page.addText("Śmierci: " + stat.getDeaths());
        bm.addPage(page);

        p.openBook(bm.getItemStack());

        return true;
    }
}
