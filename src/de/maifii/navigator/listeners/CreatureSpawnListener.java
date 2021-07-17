package de.maifii.navigator.listeners;

import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class CreatureSpawnListener implements Listener {

    public void onSpawn(CreatureSpawnEvent event) {
        event.setCancelled(true);
    }
}
