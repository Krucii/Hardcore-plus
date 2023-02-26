package me.ziomki.hardcoreplus.Helpers.DatabaseController;

import me.ziomki.hardcoreplus.HardcorePlus;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

public class SQLite extends Database {
    private String tableName;

    public SQLite(HardcorePlus instance) {
        super(instance);
        tableName = "stats";
    }

    private final String CREATE_TABLE_QUERY =
            "CREATE TABLE IF NOT EXISTS " + "stats" + " (" +
                    "`player` varchar(32) NOT NULL," +
                    "`kills` int(11) NOT NULL," +
                    "`deaths` int(11) NOT NULL," +
                    "PRIMARY KEY (`player`)" +
                    ");";

    @Override
    public Connection getSQLConnection() {
        File dataFolder = new File(plugin.getDataFolder(), tableName + ".db");
        try {
            if (connection != null && !connection.isClosed()) {
                return connection;
            }
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + dataFolder);
            return connection;
        } catch (SQLException | ClassNotFoundException ex) {
            plugin.getLogger().log(Level.SEVERE, "SQLite exception on initialize", ex);
        }
        return null;
    }

    @Override
    public void load() {
        connection = getSQLConnection();
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(CREATE_TABLE_QUERY);
        } catch (SQLException e) {
            plugin.getLogger().log(Level.SEVERE, "Error creating table " + tableName, e);
        }
    }
}