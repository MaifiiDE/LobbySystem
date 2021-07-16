package de.maifii.navigator.listeners;


// Code by Maifii 
// Zeit: 19:33 | 07 , 16
// Discord : MaifiiDE#3511


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;


public class SpielerListener implements Listener {

    @EventHandler
    public void handleDamage(final EntityDamageEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void handleWeather(final WeatherChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void handleFoodLevel(final FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void handleDrops(final PlayerDropItemEvent event) {
        event.setCancelled(true);
    }

}

