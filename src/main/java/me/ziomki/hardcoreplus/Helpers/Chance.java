package me.ziomki.hardcoreplus.Helpers;

public class Chance {

    public static boolean chance(double percentage) {
        if (percentage/100 > Math.random())
            return true;
        else
            return false;
    }

}
