package it.mjicio.plugin;

import it.mjicio.plugin.database.Database;
import it.mjicio.plugin.staff.AdminCommands;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.Date;

public final class MafiaCore extends JavaPlugin {

    private static MafiaCore istance;
    private Database database;

    @Override
    public void onEnable() {
        // Plugin startup logic
        istance = this;
        initConfigs();

        this.database = new Database();
        try {
            this.database.initializeDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not initialize database");
        }

        System.out.println("MafiaCore Abilitato");

        getCommand("adminmafia").setExecutor(new AdminCommands(database));


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("MafiaCore Disabilitato");


    }

    private void initConfigs() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }

}
