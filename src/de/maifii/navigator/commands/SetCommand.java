package de.maifii.navigator.commands;

import de.maifii.navigator.main.Lobby;
import de.maifii.navigator.utils.LocationUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;

public class SetCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player spieler = (Player) sender;

        File ordner = new File("plugins//Lobby//");
        File file = new File("plugins//Lobby//" + args[0] + ".yml");


        if (sender instanceof Player) {
            if (spieler.hasPermission("lobby.set")) {
                LocationUtils.setLocation(args[0], spieler);
                spieler.sendMessage(Lobby.Prefix + "Du hast die Location §e" + args[0] + " §7gesetzt.");
            } else {
                spieler.sendMessage(Lobby.Prefix + "Dazu hast du §ekeine §7Berechtigung.");
            }
        }
        return false;
    }
}