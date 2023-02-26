package me.ziomki.hardcoreplus.Helpers.DatabaseController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.ziomki.hardcoreplus.HardcorePlus;
import org.bukkit.entity.Player;

public abstract class Database {
    protected HardcorePlus plugin;
    protected Connection connection;
    private static final String TABLE_NAME = "stats";

    public Database(HardcorePlus instance) {
        this.plugin = instance;
    }

    public abstract Connection getSQLConnection();

    public abstract void load();

    public Stats getAll(Player player) throws SQLException {
        Stats stats = new Stats();
        try (Connection conn = getSQLConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE player = ?")) {
            ps.setString(1, player.getName());
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

    public void addDeath(Player player) throws SQLException {
        try (Connection conn = getSQLConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE " + TABLE_NAME + " SET deaths = deaths + 1 WHERE player = ?")) {
            ps.setString(1, player.getName());
            ps.executeUpdate();
        }
    }

    public void addKill(Player player) throws SQLException {
        try (Connection conn = getSQLConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE " + TABLE_NAME + " SET kills = kills + 1 WHERE player = ?")) {
            ps.setString(1, player.getName());
            ps.executeUpdate();
        }
    }
//    public void setAll(Player player, List<Stats> stats) throws SQLException {
//        try (Connection conn = getSQLConnection();
//             PreparedStatement ps = conn.prepareStatement("REPLACE INTO " + TABLE_NAME + " (player, kills, deaths) VALUES (?, ?, ?)")) {
//            for (Stats stat : stats) {
//                ps.setString(1, player.getName());
//                ps.setInt(2, stat.getKills());
//                ps.setInt(3, stat.getDeaths());
//                ps.addBatch();
//            }
//            ps.executeBatch();
//        }
//    }
}