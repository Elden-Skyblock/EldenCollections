package me.csdad.EldenCollections;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    // instantiate anything that needs to be instantiated on restart or reload.
    public void onEnable() {

        System.out.println("test");

    }

    // deconstruct any necessary data on reload or restart
    public void onDisable() {

    }


    /**
     * Private utilities methods
     */
    private void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
    }

    private void registerCommands() {

    }

}
