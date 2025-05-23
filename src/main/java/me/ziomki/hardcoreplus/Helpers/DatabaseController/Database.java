package me.ziomki.hardcoreplus.Helpers.DatabaseController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import me.ziomki.hardcoreplus.HardcorePlus;

public abstract class Database {
    protected HardcorePlus plugin;
    protected Connection connection;
    private static final String TABLE_NAME = "stats";

    public Database(HardcorePlus instance) {
        this.plugin = instance;
    }

    public abstract Connection getSQLConnection();

    public abstract void load();

    public Stats getAll(String player) throws SQLException {
        Stats stats = new Stats();
        try (Connection conn = getSQLConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE player = ?")) {
            ps.setString(1, player);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    stats.setPlayer(rs.getString("player"));
                    stats.setKills(rs.getInt("kills"));
                    stats.setDeaths(rs.getInt("deaths"));
                }
            }
        }
        return stats;
    }

    public void addToStats(String player, Stat stat) throws SQLException {
        try (Connection conn = getSQLConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE " + TABLE_NAME + " SET "+ stat +" = "+ stat +" + 1 WHERE player = ?")) {
            ps.setString(1, player);
            ps.executeUpdate();
        }
    }

    public int playerExists(String player) throws SQLException {
        try (Connection conn = getSQLConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT EXISTS(SELECT 1 FROM "+ TABLE_NAME +" WHERE player = ?);")) {
            ps.setString(1, player);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return 2; // error
    }

    public void addToDatabase(String player) throws SQLException {
        try (Connection conn = getSQLConnection();
            PreparedStatement ps = conn.prepareStatement("REPLACE INTO " + TABLE_NAME + " (player,kills,deaths) VALUES(?,?,?)")) {
            ps.setString(1, player);
            ps.setInt(2, 0);
            ps.setInt(3, 0);
            ps.executeUpdate();
        }
    }

    public enum Stat {
        kills, deaths
    }
}