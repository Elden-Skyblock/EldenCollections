package me.csdad.EldenCollections;

import me.csdad.EldenCollections.Collections.Collection;
import me.csdad.EldenCollections.Collections.Milestone;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Objects;

public class Main extends JavaPlugin {

    // store an instance of this class so we can access it outside of the class
    private static Main instance;

    // hashmap storing all collectable items on the server
    // loads from config.yml
    // format STRING:Collection actual ID | rendered collection
    private HashMap<String, Collection> collectables = new HashMap<>();

    // instantiate anything that needs to be instantiated on restart or reload.
    public void onEnable() {

        // instantiate the instance to thsi class
        instance = this;

        // load the default config if this is the first run
        this.saveDefaultConfig();

        // register our events and commands
        registerEvents();
        registerCommands();

        // load the collectables from the config


    }

    // deconstruct any necessary data on reload or restart
    public void onDisable() {

        // nullify our plugin instance. should always be called last
        // as to not cause issues with other classes that depend on this
        // to deconstruct
        instance = null;
    }

    // getter for the plugin instance
    public static Main getInstance() {
        return instance;
    }

    // getter for the collectables hashmap, no need for setter
    public HashMap<String, String> getCollectables() {
        return collectables;
    }



    /**
     * Private utilities methods
     */
    private void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
    }

    private void registerCommands() {

    }

    // load the collectables from the config
    private void loadCollectables() {

        // loop through all the keys in the items section of the config, ignore keys
        // use require non-null to ensure that the value isnt null
        for(String key : Objects.requireNonNull(this.getConfig().getConfigurationSection("items")).getKeys(false)) {

                // get the actual ID of the item
                String actual_id = this.getConfig().getString("items." + key);

                if(actual_id == null) {
                    // if the actual ID is null, log an error and continue
                    getLogger().warning("Invalid item ID for key " + key);
                    continue;
                } else {

                    // create a new collection to be stored into memory
                    Collection collection = new Collection(actual_id, key);

                    // load this collections milestones from the config
                    for(String s : Objects.requireNonNull(this.getConfig().getConfigurationSection("items." + key + ".milestones")).getKeys(false)) {

                        if(s == null) {
                            // if the milestone is null, log an error and continue
                            getLogger().warning("Invalid milestone for key " + key);
                            continue;
                        } else {

                            // get the amount of the milestone
                            int amount = this.getConfig().getInt("items." + key + ".milestones." + s + ".amount");

                            // get the action of the milestone
                            String action = this.getConfig().getString("items." + key + ".milestones." + s + ".action");


                            // create a new milestone and add it to the collection
                            collection.addMilestone(amount, new Milestone(amount, action));
                        }

                    }

                    // add the loaded collections to memory so that we can call on it.
                    collectables.put(key, collection);

                }
        }
    }

}
