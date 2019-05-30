package de.d3adspace.isabelle.spigot.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import de.d3adspace.isabelle.spigot.annotation.PluginLogger;
import de.d3adspace.isabelle.spigot.annotation.ServerLogger;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.logging.Logger;

/**
 * The module that will provide basic spigot services and managers and bind them to their implementations at runtime.
 * All services should be fetched in plugin context and not via static methods where possible to make testing easier.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class SpigotModule extends AbstractModule {

    /**
     * The plugin we are working for.
     */
    private final Plugin plugin;

    /**
     * Create a new spigot module by its underlying plugin.
     *
     * @param plugin The plugin.
     */
    public SpigotModule(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    protected void configure() {

        bind(Plugin.class).toInstance(plugin);
        bind(Server.class).toInstance(plugin.getServer());
        bind(PluginManager.class).toInstance(plugin.getServer().getPluginManager());
        bind(BukkitScheduler.class).toInstance(plugin.getServer().getScheduler());
        bind(ScoreboardManager.class).toInstance(plugin.getServer().getScoreboardManager());
        bind(ServicesManager.class).toInstance(plugin.getServer().getServicesManager());
        bind(Messenger.class).toInstance(plugin.getServer().getMessenger());
        bind(ItemFactory.class).toInstance(plugin.getServer().getItemFactory());
        bind(ConsoleCommandSender.class).toInstance(plugin.getServer().getConsoleSender());
        bind(PluginDescriptionFile.class).toInstance(plugin.getDescription());
    }

    /**
     * Provide the plugin logger. It's special because it has a custom tag and it is delivered by the plugin. For the
     * server wide logger take a look at {@link #provideServerLogger()}.
     * <p>
     * Bound via {@link PluginLogger} binding annotation / qualifier.
     *
     * @return The plugin logger.
     */
    @Provides
    @PluginLogger
    public Logger providePluginLogger() {

        return plugin.getLogger();
    }

    /**
     * Provide the server logger. It is used for overall server logging. Take a look at {@link #providePluginLogger()}
     * for the plugin local logger.
     * <p>
     * Bound via {@link ServerLogger} binding annotation / qualifier.
     *
     * @return The plugin logger.
     */
    @Provides
    @ServerLogger
    public Logger provideServerLogger() {

        return plugin.getServer().getLogger();
    }
}
