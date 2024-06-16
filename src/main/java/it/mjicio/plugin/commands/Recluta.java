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

                    if(plugin.getMafie().get().getStringList("mafie").contains(args[1])) {

                        if(Bukkit.getPlayer(args[2]) != null){

                            if(p.hasPermission("mafia.recluta." + args[1]) || p.hasPermission("mafia.admin.recluta")) {



                            }

                        }

                    }

                }

            }

        }

        return false;
    }
}
