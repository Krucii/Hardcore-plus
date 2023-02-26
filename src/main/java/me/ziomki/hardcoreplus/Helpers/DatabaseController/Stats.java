package me.ziomki.hardcoreplus.Helpers.DatabaseController;

public class Stats {
    private String player;
    private int kills;
    private int deaths;

    public Stats() {

    }

    public Stats(String player, int kills, int deaths) {
        this.player = player;
        this.kills = kills;
        this.deaths = deaths;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int total) {
        this.deaths = deaths;
    }
}