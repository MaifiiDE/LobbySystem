package de.maifii.navigator.listeners;

import de.maifii.navigator.utils.ItemUtils;
import de.maifii.navigator.utils.LocationUtils;
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
        ItemUtils.setItemInInventory(event.getPlayer().getInventory(), Material.BARRIER, "§8§l»§7» §7§lGadget Auswählen!", 2);
        ItemUtils.setItemInInventory(event.getPlayer().getInventory(), Material.NOTE_BLOCK, "§8§l»§7» §eGadgets §8| §7Rechtsklick", 8);

        LocationUtils.useLocation(event.getPlayer(), "Spawn");

        spieler.setLevel(2021);

        event.setJoinMessage(null);
    }

    @EventHandler
    public void onDisconnect(PlayerQuitEvent event) {
        Player spieler = (Player) event.getPlayer();

        spieler.getInventory().clear();
        event.setQuitMessage(null);
    }

}
