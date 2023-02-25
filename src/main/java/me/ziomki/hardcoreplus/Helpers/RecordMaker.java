package me.ziomki.hardcoreplus.Helpers;

import me.ziomki.hardcoreplus.Modules.BlockBreak.FasterToolBreaking;
import me.ziomki.hardcoreplus.Modules.CreatureSpawn.SpawnPoweredCreeper;
import me.ziomki.hardcoreplus.Modules.EntityDamage.BoneBreak;
import me.ziomki.hardcoreplus.Modules.EntityDamage.InfiniteFire;
import me.ziomki.hardcoreplus.Modules.EntityTarget.FasterMonsters;
import me.ziomki.hardcoreplus.Modules.FoodLevelChange.HungerEffect;
import me.ziomki.hardcoreplus.Modules.LightningStrike.StrikePlayer;
import me.ziomki.hardcoreplus.Modules.PlayerDeath.DeathEraseItems;
import me.ziomki.hardcoreplus.OldLists.DifficultiesList;
import me.ziomki.hardcoreplus.Modules.*;
import me.ziomki.hardcoreplus.Schedulers.DarknessDamageScheduler;
import org.bukkit.ChatColor;
import org.bukkit.Material;

import java.util.ArrayList;

public class RecordMaker {

    public static ArrayList<DifficultiesList> gui_icon = new ArrayList<>();

    public static void addAll() {
        gui_icon.add(new DifficultiesList(30.0, Material.IRON_AXE, ChatColor.GRAY, "Liche narzędzia", "Narzędzia zużywają się szybciej.", FasterToolBreaking.class));
        gui_icon.add(new DifficultiesList(5.0, Material.CREEPER_HEAD, ChatColor.DARK_GREEN, "Bombowa imprezka", "Naelektryzowane creepery nie są już tak rzadkim widokiem.", SpawnPoweredCreeper.class));
        gui_icon.add(new DifficultiesList(5.0, Material.DIRT, org.bukkit.ChatColor.GREEN, "Łamaga", "Pojawia się rosnąca wraz z wysokością szansa na skręcenie kostki podczas upadku.", BoneBreak.class));
        gui_icon.add(new DifficultiesList(100.0, Material.FIRE_CHARGE, ChatColor.RED, "Wieczny ogień", "Ogień trawiący twoje ciało nie zniknie tak łatwo.", InfiniteFire.class));
        gui_icon.add(new DifficultiesList(100.0, Material.POTION, ChatColor.AQUA, "Głodne poczwary", "Wszystkie goniące graczy potwory są szybsze.", FasterMonsters.class));
        gui_icon.add(new DifficultiesList(100.0, Material.DEAD_BUSH, ChatColor.GRAY, "Susza", "Zwiększony spadek poziomu nasycenia na pustyni.", HungerEffect.class));
        gui_icon.add(new DifficultiesList(5.0, Material.LIGHTNING_ROD, ChatColor.RED, "Wkurzony Zeus", "Zwiększona szansa na zostanie trafionym piorunem.", StrikePlayer.class));
        gui_icon.add(new DifficultiesList(100.0, Material.CANDLE, ChatColor.DARK_PURPLE, "Bolesna śmierć", "Podczas śmierci połowa przedmiotów znika.", DeathEraseItems.class));
        gui_icon.add(new DifficultiesList(100.0, Material.SOUL_TORCH, ChatColor.DARK_RED, "Egipskie ciemności", "Zbyt mała ilość światła powoduje obrażenia", DarknessDamageScheduler.class));
    }
}
