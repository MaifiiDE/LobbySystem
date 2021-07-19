package de.maifii.navigator.commands;

// Code by Maifii 
// Zeit: 05:36 | 07 , 19
// Discord : MaifiiDE#3511

import de.maifii.navigator.main.Lobby;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetupCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player spieler = (Player) sender;
            if (spieler.hasPermission("")) {
                if (args.length == 0) {
                    spieler.sendMessage(Lobby.Prefix + "§eSetup-Hilfe");
                    spieler.sendMessage(Lobby.Prefix + "Benutze §e/set Spawn, BedWars, SurvivalGames, KnockBackFFA");
                } else
                    spieler.sendMessage("Bitte benutze §e/Hilfe§7.");
            } else
                spieler.sendMessage("Dazu hast du §ekeine §7Berechtigung.");
        }
        return false;
    }
}