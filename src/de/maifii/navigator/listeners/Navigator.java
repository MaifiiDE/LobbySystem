package de.maifii.navigator.listeners;

import de.maifii.navigator.utils.ItemUtils;
import de.maifii.navigator.utils.LocationUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class Navigator implements Listener {

    private static String ExtraGUI = "§8§l»§7» §eExtras";
    private static String GadgetGUI = "§8§l»§7» §eGadgets";
    private static String EffektGUI = "§8§l»§7» §eEffekte";



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
                ItemUtils.setItemInInventory(event.getPlayer().getInventory(), Material.BARRIER, "§8§l»§7» §7§lGadget Auswählen!", 2);
                ItemUtils.setItemInInventory(event.getPlayer().getInventory(), Material.NOTE_BLOCK, "§8§l»§7» §eExtras §8| §7Rechtsklick", 8);
            }
        }
    }


    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        event.setCancelled(true);
    }


    public void openEffekte(Player spieler) {
        Inventory eff = Bukkit.createInventory(null, 9*6, EffektGUI);

        ItemUtils.setItemInInventory(eff, Material.STAINED_GLASS_PANE, " ", 0 );
        ItemUtils.setItemInInventory(eff, Material.STAINED_GLASS_PANE, " ", 1 );
        ItemUtils.setItemInInventory(eff, Material.STAINED_GLASS_PANE, " ", 2 );


        ItemUtils.setItemInInventory(eff, Material.FISHING_ROD, "§8§l»§7» §7Gadgets", 10 );
        ItemUtils.setItemInInventory(eff, Material.STAINED_GLASS_PANE, " ", 11 );

        ItemUtils.setItemInInventory(eff, Material.BREWING_STAND_ITEM, "§8§l»§7» §eEffekte", 19 );

        ItemUtils.setItemInInventory(eff, Material.STAINED_GLASS_PANE, " ", 20 );
        ItemUtils.setItemInInventory(eff, Material.STAINED_GLASS_PANE, " ", 29 );
        ItemUtils.setItemInInventory(eff, Material.STAINED_GLASS_PANE, " ", 38 );
        ItemUtils.setItemInInventory(eff, Material.STAINED_GLASS_PANE, " ", 45 );
        ItemUtils.setItemInInventory(eff, Material.STAINED_GLASS_PANE, " ", 46 );
        ItemUtils.setItemInInventory(eff, Material.STAINED_GLASS_PANE, " ", 47 );

        spieler.openInventory(eff);
    }


    public void openGadgets(Player spieler) {
        Inventory gad = Bukkit.createInventory(null, 9*6, GadgetGUI);

        ItemUtils.setItemInInventory(gad, Material.STAINED_GLASS_PANE, " ", 0 );
        ItemUtils.setItemInInventory(gad, Material.STAINED_GLASS_PANE, " ", 1 );
        ItemUtils.setItemInInventory(gad, Material.STAINED_GLASS_PANE, " ", 2 );


        ItemUtils.setItemInInventory(gad, Material.FISHING_ROD, "§8§l»§7» §eGadgets", 10 );
        ItemUtils.setItemInInventory(gad, Material.STAINED_GLASS_PANE, " ", 11 );

        ItemUtils.setItemInInventory(gad, Material.BREWING_STAND_ITEM, "§8§l»§7» §7Effekte", 19 );

        ItemUtils.setItemInInventory(gad, Material.STAINED_GLASS_PANE, " ", 20 );
        ItemUtils.setItemInInventory(gad, Material.STAINED_GLASS_PANE, " ", 29 );
        ItemUtils.setItemInInventory(gad, Material.STAINED_GLASS_PANE, " ", 38 );
        ItemUtils.setItemInInventory(gad, Material.STAINED_GLASS_PANE, " ", 45 );
        ItemUtils.setItemInInventory(gad, Material.STAINED_GLASS_PANE, " ", 46 );
        ItemUtils.setItemInInventory(gad, Material.STAINED_GLASS_PANE, " ", 47 );

        spieler.openInventory(gad);
    }




    public void openExtras(Player spieler) {
        Inventory exx = Bukkit.createInventory(null, 9*6, ExtraGUI);

        ItemUtils.setItemInInventory(exx, Material.STAINED_GLASS_PANE, " ", 0 );
        ItemUtils.setItemInInventory(exx, Material.STAINED_GLASS_PANE, " ", 1 );
        ItemUtils.setItemInInventory(exx, Material.STAINED_GLASS_PANE, " ", 2 );


        ItemUtils.setItemInInventory(exx, Material.FISHING_ROD, "§8§l»§7» §7Gadgets", 10 );
        ItemUtils.setItemInInventory(exx, Material.STAINED_GLASS_PANE, " ", 11 );

        ItemUtils.setItemInInventory(exx, Material.BREWING_STAND_ITEM, "§8§l»§7» §7Effekte", 19 );

        ItemUtils.setItemInInventory(exx, Material.STAINED_GLASS_PANE, " ", 20 );
        ItemUtils.setItemInInventory(exx, Material.STAINED_GLASS_PANE, " ", 29 );
        ItemUtils.setItemInInventory(exx, Material.STAINED_GLASS_PANE, " ", 38 );
        ItemUtils.setItemInInventory(exx, Material.STAINED_GLASS_PANE, " ", 45 );
        ItemUtils.setItemInInventory(exx, Material.STAINED_GLASS_PANE, " ", 46 );
        ItemUtils.setItemInInventory(exx, Material.STAINED_GLASS_PANE, " ", 47 );

        spieler.openInventory(exx);
    }


    @EventHandler
    public void onExtrasOpen(PlayerInteractEvent event) {
        if(event.getItem() == null) return;
        if(event.getItem().getType() != Material.NOTE_BLOCK) return;
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
            openExtras(event.getPlayer());
        }
    }

    @EventHandler
    public void onExtrasClick(InventoryClickEvent event) {
        if(!(event.getWhoClicked() instanceof Player)) return;
        Player spieler = (Player) event.getWhoClicked();
        if(event.getInventory().getTitle().equals(ExtraGUI)) {
            event.setCancelled(true);
            switch (event.getCurrentItem().getType()) {
                case FISHING_ROD:
                    openGadgets((Player) event.getWhoClicked());
                    break;
                case BREWING_STAND_ITEM:
                    openEffekte((Player) event.getWhoClicked());
                    break;
            }
        }
    }



}
