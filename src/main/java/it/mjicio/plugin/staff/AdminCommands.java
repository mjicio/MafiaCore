package it.mjicio.plugin.staff;

import it.mjicio.plugin.MafiaCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminCommands implements CommandExecutor {

    private MafiaCore plugin;


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if(p.hasPermission("mafia.admin.create")){




        }
        return false;
    }
}
