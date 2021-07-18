package de.maifii.navigator.listeners;



// Code by Maifii 
// Zeit: 17:09 | 07 , 17
// Discord : MaifiiDE#3511


import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import de.maifii.navigator.main.Lobby;


public class MoveListener implements Listener {

    private Lobby instance;

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player spieler = (Player) event.getPlayer();

        if(Lobby.getEnderPartikel().contains(spieler)) {
            spieler.getWorld().playEffect(spieler.getLocation(), Effect.ENDER_SIGNAL, 1);
        }
        else if(Lobby.getHerzPartikel().contains(spieler)) {
            spieler.getWorld().playEffect(spieler.getLocation(), Effect.HEART, 1);
        }
        else if(Lobby.getWasserPartikel().contains(spieler)) {
            spieler.getWorld().playEffect(spieler.getLocation(), Effect.WATERDRIP, 2);
        }
        else if(Lobby.getSchneePartikel().contains(spieler)) {
            spieler.getWorld().playEffect(spieler.getLocation(), Effect.SNOW_SHOVEL, 2);
        }

    }


}

