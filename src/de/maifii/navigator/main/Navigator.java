package de.maifii.navigator.main;

// Code by Maifii 
// Zeit: 18:54 | 07 , 16
// Discord : MaifiiDE#3511


import de.maifii.navigator.commands.SetCommand;
import de.maifii.navigator.listeners.ConnectionListener;
import de.maifii.navigator.listeners.SpielerListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Navigator extends JavaPlugin {

    private static Navigator instance;
    public static String Prefix = "§8§l»§7» §eNavigator§7: ";

    private static ArrayList<Player> BuildMode;


    @Override
    public void onEnable() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents((Listener) new de.maifii.navigator.listeners.Navigator(),  this);
        pluginManager.registerEvents((Listener) new ConnectionListener(), this);
        pluginManager.registerEvents((Listener) new SpielerListener(), this);

        getCommand("set").setExecutor(new SetCommand());


        BuildMode = new ArrayList<Player>();

        instance = this;
    }




    //getters
    public static Navigator getInstance() {
        return instance;
    }
}
