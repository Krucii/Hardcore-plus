package me.ziomki.hardcoreplus.Helpers;

public class ChanceCalculator {

    public static boolean getChance(double percentage) {
        return percentage / 100 > Math.random();
    }

}
