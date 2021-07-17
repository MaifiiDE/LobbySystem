package de.maifii.navigator.listeners.Gadgets;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Fish;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.util.Vector;

public class EnterHakenGadget implements Listener {

    @EventHandler
    public void onRod(PlayerFishEvent event) {
        Player player = event.getPlayer();
        Fish h = event.getHook();
        if ((event.getState().equals((Object) PlayerFishEvent.State.IN_GROUND) || event.getState().equals((Object) PlayerFishEvent.State.CAUGHT_ENTITY) || event.getState().equals((Object) PlayerFishEvent.State.FAILED_ATTEMPT)) && Material.AIR != Bukkit.getWorld(event.getPlayer().getWorld().getName()).getBlockAt(h.getLocation().getBlockX(), h.getLocation().getBlockY() - 1, h.getLocation().getBlockZ()).getType() && Bukkit.getWorld(event.getPlayer().getWorld().getName()).getBlockAt(h.getLocation().getBlockX(), h.getLocation().getBlockY() - 1, h.getLocation().getBlockZ()).getType() != Material.STATIONARY_WATER) {
            final Location lc = player.getLocation();
            final Location to = event.getHook().getLocation();
            lc.setY(lc.getY() + 0.5);
            player.teleport(lc);
            final double g = -0.08;
            final double t;
            final double d = t = to.distance(lc);
            final double v_x = (1.0 + 0.07 * t) * (to.getX() - lc.getX()) / t;
            final double v_y = (1.0 + 0.03 * t) * (to.getY() - lc.getY()) / t - 0.5 * g * t;
            final double v_z = (1.0 + 0.07 * t) * (to.getZ() - lc.getZ()) / t;
            final Vector v = player.getVelocity();
            v.setX(v_x);
            v.setY(v_y);
            v.setZ(v_z);
            player.setVelocity(v);
            player.playSound(player.getLocation(), Sound.ENDERDRAGON_WINGS, 3.0f, 2.0f);
        }
    }
}