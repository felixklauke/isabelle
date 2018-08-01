package de.d3adspace.isabelle.spigot.governator.module;

import com.netflix.governator.guice.BootstrapBinder;
import com.netflix.governator.guice.BootstrapModule;
import de.d3adspace.isabelle.spigot.governator.IsabelleSpigotExtension;
import de.d3adspace.isabelle.spigot.governator.annotation.PluginConfig;
import de.d3adspace.isabelle.spigot.governator.configuration.BukkitConfigurationProvider;
import org.bukkit.configuration.Configuration;

/**
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class SpigotBootstrapModule implements BootstrapModule {

    private final IsabelleSpigotExtension extension;

    public SpigotBootstrapModule(IsabelleSpigotExtension extension) {
        this.extension = extension;
    }

    @Override
    public void configure(BootstrapBinder bootstrapBinder) {

        bootstrapBinder.bind(Configuration.class).annotatedWith(PluginConfig.class).toInstance(extension.getConfig());
        bootstrapBinder.bindConfigurationProvider().to(BukkitConfigurationProvider.class);
    }
}
