package it.mjicio.plugin;

import it.mjicio.plugin.staff.AdminCommands;
import org.bukkit.plugin.java.JavaPlugin;

public final class MafiaCore extends JavaPlugin {

    private static MafiaCore istance;
    @Override
    public void onEnable() {
        // Plugin startup logic
        istance = this;
        initConfigs();
        System.out.println("MafiaCore Abilitato");

        getCommand("adminmafia").setExecutor(new AdminCommands());


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
