package de.maifii.navigator.listeners;

import de.maifii.navigator.utils.ItemUtils;
import de.maifii.navigator.utils.LocationUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Navigator implements Listener {

    @EventHandler
    public void onNavigatorOpen(PlayerInteractEvent event) {
        if(event.getItem() == null) return;
        if(event.getItem().getType() != Material.RECORD_3) return;

        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemUtils.setItemInInventory(event.getPlayer().getInventory(), Material.IRON_SWORD, "§8§l»§7» §eSurvivalGames", 0);
            ItemUtils.setItemInInventory(event.getPlayer().getInventory(), Material.BED, "§8§l»§7» §eBedWars", 1);
            ItemUtils.setItemInInventory(event.getPlayer().getInventory(), Material.STICK, "§8§l»§7» §eKnockBackFFA", 2);

            ItemUtils.setItemInInventory(event.getPlayer().getInventory(), Material.BARRIER, "§8§l»§7» §eZurück", 8);
        }
    }

    @EventHandler
    public void onNavigatorInteract(PlayerInteractEvent event) {
        Player spieler = (Player) event.getPlayer();


        if (event.getItem() == null) return;
        if (event.getItem().getType() == Material.IRON_SWORD) {
            if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                event.setCancelled(true);
                LocationUtils.useLocation(event.getPlayer(), "SurvivalGames");
            }
        } else if (event.getItem().getType() == Material.BED) {
            if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                event.setCancelled(true);
                LocationUtils.useLocation(event.getPlayer(), "BedWars");
            }
        }
        else if(event.getItem().getType() == Material.STICK) {
            if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                event.setCancelled(true);
                LocationUtils.useLocation(event.getPlayer(), "KnockBackFFA");
            }
        }
        else if(event.getItem().getType() == Material.BARRIER) {
            if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                event.setCancelled(true);
                spieler.getInventory().clear();
                ItemUtils.setItemInInventory(event.getPlayer().getInventory(), Material.RECORD_3, "§8§l»§7» §eNavigator §8| §7Rechtsklick", 0);
            }
        }
    }


    public void onInvClick(InventoryClickEvent event) {
        event.setCancelled(true);
    }
}
