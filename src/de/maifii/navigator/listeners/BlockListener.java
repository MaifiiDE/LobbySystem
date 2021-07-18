package de.maifii.navigator.listeners;



// Code by Maifii 
// Zeit: 00:46 | 07 , 18
// Discord : MaifiiDE#3511


import de.maifii.navigator.main.Lobby;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;


public class BlockListener implements Listener {


    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player spieler = (Player) event.getPlayer();
        if(!Lobby.getBuildMode().contains(spieler));
        event.setCancelled(true);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        Player spieler = (Player) event.getPlayer();
        if(!Lobby.getBuildMode().contains(spieler));
        event.setCancelled(true);
    }

}

