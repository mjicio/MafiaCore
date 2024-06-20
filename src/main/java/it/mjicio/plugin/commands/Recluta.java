package it.mjicio.plugin.commands;

import it.mjicio.plugin.MafiaCore;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Recluta implements CommandExecutor {

    private MafiaCore plugin;
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if(cmd.equals("mafia")) {

            if(args.length == 3) {

                if(args[0].equals("recluta")) {



                }

            }

        }

        return false;
    }
}
