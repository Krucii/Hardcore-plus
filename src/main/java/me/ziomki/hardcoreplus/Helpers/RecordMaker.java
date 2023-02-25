package me.ziomki.hardcoreplus.Helpers;

import me.ziomki.hardcoreplus.OldLists.DifficultiesList;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class RecordMaker {

    public static void addAll() {
        DifficultiesList gui_icon;
        gui_icon = new DifficultiesList(30.0, Material.IRON_AXE, ChatColor.GRAY, "Liche narzędzia", "Narzędzia zużywają się szybciej.");
        gui_icon = new DifficultiesList(5.0, Material.CREEPER_HEAD, ChatColor.DARK_GREEN, "Bombowa imprezka", "Naelektryzowane creepery nie są już tak rzadkim widokiem.");
        gui_icon = new DifficultiesList(5.0, Material.DIRT, org.bukkit.ChatColor.GREEN, "Łamaga", "Pojawia się rosnąca wraz z wysokością szansa na skręcenie kostki podczas upadku.");
        gui_icon = new DifficultiesList(100.0, Material.FIRE_CHARGE, ChatColor.RED, "Wieczny ogień", "Ogień trawiący twoje ciało nie zniknie tak łatwo.");
        gui_icon = new DifficultiesList(100.0, Material.POTION, ChatColor.AQUA, "Głodne poczwary", "Wszystkie goniące graczy potwory są szybsze.");
        gui_icon = new DifficultiesList(100.0, Material.DEAD_BUSH, ChatColor.GRAY, "Susza", "Zwiększony spadek poziomu nasycenia na pustyni.");
        gui_icon = new DifficultiesList(5.0, Material.LIGHTNING_ROD, ChatColor.RED, "Wkurzony Zeus", "Zwiększona szansa na zostanie trafionym piorunem.");
        gui_icon = new DifficultiesList(100.0, Material.CANDLE, ChatColor.DARK_PURPLE, "Bolesna śmierć", "Podczas śmierci połowa przedmiotów znika.");
        gui_icon = new DifficultiesList(100.0, Material.SOUL_TORCH, ChatColor.DARK_RED, "Egipskie ciemności", "Zbyt mała ilość światła powoduje obrażenia");
    }
}
