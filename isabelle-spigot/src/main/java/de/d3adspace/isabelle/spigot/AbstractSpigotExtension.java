package de.d3adspace.isabelle.spigot;

import de.d3adspace.isabelle.core.extension.IsabelleExtension;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class AbstractSpigotExtension extends JavaPlugin implements IsabelleExtension {

    /**
     * The plugin description file read from the plugin.yml file. Used to determine version and name of the plugin
     * we are currently managing.
     */
    private final PluginDescriptionFile pluginDescriptionFile = getDescription();

    @Override
    public String getVersion() {

        return pluginDescriptionFile.getVersion();
    }

    @Override
    public void onLoad() {

        bootstrap();
    }

    @Override
    public void onEnable() {

        saveDefaultConfig();
        reloadConfig();

        start();
    }

    @Override
    public void onDisable() {

        tearDown();
    }
}
