package de.maifii.navigator.main;

// Code by Maifii 
// Zeit: 18:54 | 07 , 16
// Discord : MaifiiDE#3511


import de.maifii.navigator.commands.SetCommand;
import de.maifii.navigator.listeners.ConnectionListener;
import de.maifii.navigator.listeners.CreatureSpawnListener;
import de.maifii.navigator.listeners.Gadgets.EnderPerleListener;
import de.maifii.navigator.listeners.Gadgets.EnterHakenGadget;
import de.maifii.navigator.listeners.MoveListener;
import de.maifii.navigator.listeners.SpielerListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Navigator extends JavaPlugin {

    private static Navigator instance;
    public static String Prefix = "§8§l»§7» §eNavigator§7: ";

    private static ArrayList<Player> BuildMode;
    private static ArrayList<Player> WasserPartikel;
    private static ArrayList<Player> EnderPartikel;
    private static ArrayList<Player> HerzPartikel;
    private static ArrayList<Player> SchneePartikel;

    private static ArrayList<Player> EnderPerleGadget;
    private static ArrayList<Player> EnterhakenGadget;


    @Override
    public void onEnable() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents((Listener) new de.maifii.navigator.listeners.Navigator(),  this);
        pluginManager.registerEvents((Listener) new ConnectionListener(), this);
        pluginManager.registerEvents((Listener) new SpielerListener(), this);
        pluginManager.registerEvents((Listener)new EnderPerleListener(), this);
        pluginManager.registerEvents((Listener) new MoveListener(), this);
        pluginManager.registerEvents((Listener) new CreatureSpawnListener(), this);
        pluginManager.registerEvents((Listener) new EnterHakenGadget(), this);


        getCommand("set").setExecutor(new SetCommand());


        BuildMode = new ArrayList<Player>();

        instance = this;
        SchneePartikel = new ArrayList<Player>();
        WasserPartikel = new ArrayList<Player>();
        EnderPartikel = new ArrayList<Player>();
        HerzPartikel = new ArrayList<Player>();

        EnderPerleGadget = new ArrayList<Player>();
        EnterhakenGadget = new ArrayList<Player>();
    }




    //getters
    public static Navigator getInstance() {
        return instance;
    }

    public static ArrayList<Player> getBuildMode() {
        return BuildMode;
    }

    public static ArrayList<Player> getEnderPartikel() {
        return EnderPartikel;
    }

    public static ArrayList<Player> getHerzPartikel() {
        return HerzPartikel;
    }

    public static ArrayList<Player> getWasserPartikel() {
        return WasserPartikel;
    }

    public static ArrayList<Player> getSchneePartikel() {
        return SchneePartikel;
    }

    public static ArrayList<Player> getEnterhakenGadget() {
        return EnterhakenGadget;
    }

    public static ArrayList<Player> getEnderPerleGadget() {
        return EnderPerleGadget;
    }
}
