package de.maifii.navigator.listeners;

import de.maifii.navigator.utils.ItemUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListener implements Listener {


    @EventHandler
    public void onConnect(PlayerJoinEvent event) {
        Player spieler = (Player) event.getPlayer();

        spieler.getInventory().clear();
        ItemUtils.setItemInInventory(event.getPlayer().getInventory(), Material.RECORD_3, "§8§l»§7» §eNavigator §8| §7Rechtsklick", 0);

        event.setJoinMessage(null);
    }

    @EventHandler
    public void onDisconnect(PlayerQuitEvent event) {
        Player spieler = (Player) event.getPlayer();

        spieler.getInventory().clear();
        event.setQuitMessage(null);
    }

}
