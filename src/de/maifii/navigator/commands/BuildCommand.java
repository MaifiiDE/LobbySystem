package de.maifii.navigator.commands;

import de.maifii.navigator.main.Lobby;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player spieler = (Player) sender;
        if(sender instanceof Player) {
            if(spieler.hasPermission("lobby.build")) {
                if(args.length == 0) {
                    if(Lobby.getBuildMode().contains(spieler)) {
                        spieler.sendMessage(Lobby.Prefix + "Du wurdest aus dem §eBau Modus §7entfernt.");
                        Lobby.getBuildMode().remove(spieler);
                    }
                    else{
                        spieler.sendMessage(Lobby.Prefix + "Du wurdest in den §eBau Modus §7hinzugefügt.");
                        Lobby.getBuildMode().add(spieler);
                    }
                }
                else {
                    spieler.sendMessage(Lobby.Prefix + "Bitte benutze §e/build§7.");
                }
            }
            else {
                spieler.sendMessage(Lobby.Prefix + "Dazu hast du §ekeine §7Berechtigung.");
            }
        }
        return false;
    }
}
