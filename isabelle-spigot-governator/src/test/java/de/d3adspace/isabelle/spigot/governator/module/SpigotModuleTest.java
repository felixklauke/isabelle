package de.d3adspace.isabelle.spigot.governator.module;

import com.google.inject.Guice;
import com.google.inject.Injector;
import de.d3adspace.isabelle.spigot.governator.annotation.PluginLogger;
import de.d3adspace.isabelle.spigot.governator.annotation.ServerLogger;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * @author Felix Klauke <info@felix-klauke.de>
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class SpigotModuleTest {

    @Mock
    private Plugin plugin;
    @Mock
    private Server server;
    @Mock
    private PluginManager pluginManager;
    @Mock
    private BukkitScheduler bukkitScheduler;
    @Mock
    private ScoreboardManager scoreboardManager;
    @Mock
    private ServicesManager servicesManager;
    @Mock
    private Messenger messenger;
    @Mock
    private ItemFactory itemFactory;
    @Mock
    private ConsoleCommandSender consoleCommandSender;
    @Mock
    private Logger pluginLogger;
    @Mock
    private Logger serverLogger;

    private Injector injector;

    @Inject
    private Provider<Plugin> pluginProvider;
    @Inject
    private Provider<Server> serverProvider;
    @Inject
    private Provider<PluginManager> pluginManagerProvider;
    @Inject
    private Provider<BukkitScheduler> bukkitSchedulerProvider;
    @Inject
    private Provider<ScoreboardManager> scoreboardManagerProvider;
    @Inject
    private Provider<ServicesManager> servicesManagerProvider;
    @Inject
    private Provider<Messenger> messengerProvider;
    @Inject
    private Provider<ItemFactory> itemFactoryProvider;
    @Inject
    private Provider<ConsoleCommandSender> consoleCommandSenderProvider;
    @Inject
    @PluginLogger
    private Provider<Logger> pluginLoggerProvider;
    @Inject
    @ServerLogger
    private Provider<Logger> serverLoggerProvider;

    @BeforeEach
    void setUp() {

        when(plugin.getServer()).thenReturn(server);
        when(server.getPluginManager()).thenReturn(pluginManager);
        when(server.getScheduler()).thenReturn(bukkitScheduler);
        when(server.getScoreboardManager()).thenReturn(scoreboardManager);
        when(server.getServicesManager()).thenReturn(servicesManager);
        when(server.getMessenger()).thenReturn(messenger);
        when(server.getItemFactory()).thenReturn(itemFactory);
        when(server.getConsoleSender()).thenReturn(consoleCommandSender);

        when(plugin.getLogger()).thenReturn(pluginLogger);
        when(server.getLogger()).thenReturn(serverLogger);

        SpigotModule spigotModule = new SpigotModule(plugin);
        injector = Guice.createInjector(spigotModule);
        injector.injectMembers(this);
    }

    @Test
    void testProvidePlugin() {

        assertNotNull(pluginProvider, "Plugin provider may not be null.");
        assertEquals(plugin, pluginProvider.get(), "Plugin instance differs.");
    }

    @Test
    void testProvideServer() {

        assertNotNull(serverProvider, "Server provider may not be null.");
        assertEquals(server, serverProvider.get(), "Server instance differs.");
    }

    @Test
    void testProvidePluginManager() {

        assertNotNull(pluginManagerProvider, "PluginManager provider may not be null");
        assertEquals(pluginManager, pluginManagerProvider.get(), "PluginManager instance differs.");
    }

    @Test
    void testProvideBukkitScheduler() {

        assertNotNull(bukkitSchedulerProvider, "BukkitScheduler provider may not be null.");
        assertEquals(bukkitScheduler, bukkitSchedulerProvider.get(), "BukkitScheduler instance differs.");
    }

    @Test
    void testProvideScoreboardManager() {

        assertNotNull(scoreboardManagerProvider, "ScoreboardManager provider may not be null.");
        assertEquals(scoreboardManager, scoreboardManagerProvider.get(), "ScoreboardManager instance differs.");
    }

    @Test
    void testProvideServicesManager() {

        assertNotNull(servicesManagerProvider, "ServicesManager provider may not be null.");
        assertEquals(servicesManager, servicesManagerProvider.get(), "ServicesManager instance differs.");
    }

    @Test
    void testProvideMessenger() {

        assertNotNull(messengerProvider, "Messenger provider may not be null.");
        assertEquals(messenger, messengerProvider.get(), "Messenger instance differs.");
    }

    @Test
    void testProvideItemFactory() {

        assertNotNull(itemFactoryProvider, "ItemFactory provider may not be null.");
        assertEquals(itemFactory, itemFactoryProvider.get(), "ItemFactory instance differs.");
    }

    @Test
    void testProvideConsoleCommandSender() {

        assertNotNull(consoleCommandSenderProvider, "ConsoleCommandSender provider may not be null.");
        assertEquals(consoleCommandSender, consoleCommandSenderProvider.get(), "ConsoleCommandSender instance differs.");
    }

    @Test
    void testProvidePluginLogger() {

        assertNotNull(pluginLoggerProvider, "Plugin logger provider may not be null.");
        assertEquals(pluginLogger, pluginLoggerProvider.get(), "Plugin logger instance differs.");
    }

    @Test
    void testProvideServerLogger() {

        assertNotNull(serverLoggerProvider, "Server logger provider may not be null.");
        assertEquals(serverLogger, serverLoggerProvider.get(), "Server logger instance differs.");
    }
}