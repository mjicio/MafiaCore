package it.mjicio.plugin.staff;

import it.mjicio.plugin.MafiaCore;
import it.mjicio.plugin.database.Database;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminCommands implements CommandExecutor {

    private MafiaCore plugin;

    private final Database database;

    public AdminCommands(Database database) {
        this.database = database;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if(p.hasPermission("mafia.admin.create")){





        }
        return false;
    }
}
