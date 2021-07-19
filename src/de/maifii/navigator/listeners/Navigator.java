package de.maifii.navigator.listeners;

import de.maifii.navigator.main.Lobby;
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
    public void onInvClick(InventoryClickEvent event) {
        event.setCancelled(true);
    }



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
    public void onNavigatorInteractionn(PlayerInteractEvent event) {
        Player spieler = (Player) event.getPlayer();
        if (event.getItem() == null) return;
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            switch (event.getItem().getType()) {
                case BED:

                    LocationUtils.useLocation(event.getPlayer(), "BedWars");

                    break;

                case IRON_SWORD:

                    LocationUtils.useLocation(event.getPlayer(), "SurvivalGames");

                    break;

                case STICK:

                    LocationUtils.useLocation(event.getPlayer(), "KnockBackFFA");

                    break;


                case BARRIER:
                    spieler.getInventory().clear();
                    if (Lobby.getEnderPerleGadget().contains(spieler)) {
                        ItemUtils.setItemInInventory(event.getPlayer().getInventory(), Material.RECORD_3, "§8§l»§7» §eNavigator §8| §7Rechtsklick", 0);
                        ItemUtils.setItemInInventory(event.getPlayer().getInventory(), Material.ENDER_PEARL, "§8§l»§7» §eEnderPerle §8| §7Rechtsklick", 2);
                        ItemUtils.setItemInInventory(event.getPlayer().getInventory(), Material.NOTE_BLOCK, "§8§l»§7» §eExtras §8| §7Rechtsklick", 8);
                    }

                    else if (Lobby.getEnterhakenGadget().contains(spieler)) {
                        ItemUtils.setItemInInventory(event.getPlayer().getInventory(), Material.RECORD_3, "§8§l»§7» §eNavigator §8| §7Rechtsklick", 0);
                        ItemUtils.setItemInInventory(event.getPlayer().getInventory(), Material.FISHING_ROD, "§8§l»§7» §eEnterHaken §8| §7Rechtsklick", 2);
                        ItemUtils.setItemInInventory(event.getPlayer().getInventory(), Material.NOTE_BLOCK, "§8§l»§7» §eExtras §8| §7Rechtsklick", 8);
                    }


                    else{
                        ItemUtils.setItemInInventory(event.getPlayer().getInventory(), Material.RECORD_3, "§8§l»§7» §eNavigator §8| §7Rechtsklick", 0);
                        ItemUtils.setItemInInventory(event.getPlayer().getInventory(), Material.BARRIER, "§8§l»§7» §7§lGadget Auswählen!", 2);
                        ItemUtils.setItemInInventory(event.getPlayer().getInventory(), Material.NOTE_BLOCK, "§8§l»§7» §eExtras §8| §7Rechtsklick", 8);
                    }
            }
        }
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

        ItemUtils.setItemInInventory(eff, Material.WATER_BUCKET, "§8§l»§7» §eWasser Partikel", 13 );
        ItemUtils.setItemInInventory(eff, Material.SNOW_BALL, "§8§l»§7» §eSchne Partikel", 14 );
        ItemUtils.setItemInInventory(eff, Material.RED_ROSE, "§8§l»§7» §eHerz Partikel", 15 );

        ItemUtils.setItemInInventory(eff, Material.BARRIER, "§8§l»§7» §eAblegen", 53 );

        spieler.openInventory(eff);
    }


    public void openGadgets(Player spieler) {
        Inventory gad = Bukkit.createInventory(null, 9*6, GadgetGUI);


        //SCHEIBEN
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


        ItemUtils.setItemInInventory(gad, Material.ENDER_PEARL, "§8§l»§7» §eEnderPerle", 13 );
        ItemUtils.setItemInInventory(gad, Material.FISHING_ROD, "§8§l»§7» §eEnterHaken", 14 );

        ItemUtils.setItemInInventory(gad, Material.BARRIER, "§8§l»§7» §eAblegen", 53 );


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


    @EventHandler
    public void onGadgetsClick(InventoryClickEvent event) {
        if(!(event.getWhoClicked() instanceof Player)) return;
        Player spieler = (Player) event.getWhoClicked();
        if(event.getInventory().getTitle().equals(GadgetGUI)) {
            event.setCancelled(true);
            switch (event.getCurrentItem().getType()) {
                case FISHING_ROD:
                    ItemUtils.setItemInInventory(event.getWhoClicked().getInventory(), Material.FISHING_ROD, "§8§l»§7» §eEnterHaken §8| §7Rechtsklick", 2);
                    if(Lobby.getEnderPerleGadget().contains(spieler)) {
                        Lobby.getEnderPerleGadget().remove(spieler);
                    }
                    Lobby.getEnterhakenGadget().add(spieler);
                    spieler.closeInventory();
                    break;

                case ENDER_PEARL:
                    ItemUtils.setItemInInventory(event.getWhoClicked().getInventory(), Material.ENDER_PEARL, "§8§l»§7» §eEnderPerle §8| §7Rechtsklick", 2);
                    if(Lobby.getEnterhakenGadget().contains(spieler)) {
                        Lobby.getEnterhakenGadget().remove(spieler);
                    }
                    Lobby.getEnderPerleGadget().add(spieler);
                    spieler.closeInventory();
                    break;

                case BREWING_STAND_ITEM:
                    openEffekte((Player) event.getWhoClicked());
                    break;

                case BARRIER:
                    Lobby.getEnderPerleGadget().remove(spieler);
                    Lobby.getEnterhakenGadget().remove(spieler);

                    ItemUtils.setItemInInventory(event.getWhoClicked().getInventory(), Material.BARRIER, "§8§l»§7» §7§lGadget Auswählen!", 2);

                    spieler.closeInventory();
                    break;
            }
        }
    }


    @EventHandler
    public void onEffekteClick(InventoryClickEvent event) {
        if(!(event.getWhoClicked() instanceof Player)) return;
        Player spieler = (Player) event.getWhoClicked();
        if(event.getInventory().getTitle().equals(EffektGUI)) {
            event.setCancelled(true);
            switch (event.getCurrentItem().getType()) {
                case FISHING_ROD:
                    openGadgets((Player) event.getWhoClicked());
                    break;
                case WATER_BUCKET:
                    if(Lobby.getEnderPartikel().contains(spieler))
                        Lobby.getEnderPartikel().remove(spieler);
                    if(Lobby.getSchneePartikel().contains(spieler))
                        Lobby.getSchneePartikel().remove(spieler);
                    if(Lobby.getHerzPartikel().contains(spieler))
                        Lobby.getHerzPartikel().remove(spieler);

                    if(Lobby.getWasserPartikel().contains(spieler)) {
                        spieler.sendMessage(Lobby.Prefix + "Du hast bereits die §eWasser Partikel §7ausgewählt.");
                        spieler.closeInventory();
                    }
                    else {
                        Lobby.getWasserPartikel().add(spieler);
                        spieler.sendMessage(Lobby.Prefix + "Du hast die §eWasser Partikel §7ausgewählt.");
                    }
                    spieler.closeInventory();
                    break;

                case RED_ROSE:
                    if(Lobby.getEnderPartikel().contains(spieler))
                        Lobby.getEnderPartikel().remove(spieler);
                    if(Lobby.getSchneePartikel().contains(spieler))
                        Lobby.getSchneePartikel().remove(spieler);
                    if(Lobby.getWasserPartikel().contains(spieler))
                        Lobby.getWasserPartikel().remove(spieler);

                    if(Lobby.getHerzPartikel().contains(spieler)) {
                        spieler.sendMessage(Lobby.Prefix + "Du hast bereits die §eHerz Partikel §7ausgewählt.");
                    }
                    else{
                        Lobby.getHerzPartikel().add(spieler);
                        spieler.sendMessage(Lobby.Prefix + "Du hast die §eHerz Partikel §7ausgewählt.");
                    }
                    spieler.closeInventory();
                    break;

                case SNOW_BALL:
                    if(Lobby.getEnderPartikel().contains(spieler))
                        Lobby.getEnderPartikel().remove(spieler);
                    if(Lobby.getHerzPartikel().contains(spieler))
                        Lobby.getHerzPartikel().remove(spieler);
                    if(Lobby.getWasserPartikel().contains(spieler))
                        Lobby.getWasserPartikel().remove(spieler);

                    if(Lobby.getSchneePartikel().contains(spieler)) {
                        spieler.sendMessage(Lobby.Prefix + "Du hast bereits die §eSchnee Partikel §7ausgewählt.");
                    }
                    else{
                        Lobby.getSchneePartikel().add(spieler);
                        spieler.sendMessage(Lobby.Prefix + "Du hast die §eSchnee Partikel §7ausgewählt.");
                    }
                    spieler.closeInventory();
                    break;

                case BARRIER:
                    Lobby.getWasserPartikel().remove(spieler);
                    Lobby.getEnderPartikel().remove(spieler);
                    Lobby.getHerzPartikel().remove(spieler);
                    Lobby.getSchneePartikel().remove(spieler);
                    spieler.sendMessage(Lobby.Prefix + "Du hast §ealle §7deine Partikel abgelegt.");
                    spieler.closeInventory();
                    break;
            }
        }
    }

}
