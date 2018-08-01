package de.d3adspace.isabelle.spigot.governator.configuration;

import com.netflix.governator.configuration.ConfigurationKey;
import com.netflix.governator.configuration.ConfigurationProvider;
import com.netflix.governator.configuration.DefaultConfigurationProvider;
import com.netflix.governator.configuration.Property;
import de.d3adspace.isabelle.spigot.governator.annotation.PluginConfig;
import de.d3adspace.isabelle.spigot.governator.module.SpigotBootstrapModule;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import javax.inject.Inject;
import java.util.Date;

/**
 * A {@link ConfigurationProvider} based on bukkit's {@link Configuration}.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 * @see SpigotBootstrapModule The module where this provider gets bound.
 */
public class BukkitConfigurationProvider extends DefaultConfigurationProvider {

    /**
     * Message wrapped wrapped into an exception to show that {@link Date} isn't supported. Mainly used by
     * {@link #getDateProperty(ConfigurationKey, Date)}.
     */
    private static final String DATES_NOT_SUPPORTED_MESSAGE = "Date's aren't supported. You may use a custom type.";

    /**
     * Message wrapped into an exception to show that object property reading is only supported when the class
     * implement the {@link ConfigurationSerializable} interface.
     */
    private static final String INVALID_SERIALIZABLE_CLASS = "Can't type convert classes that don't implement org.bukkit.configuration.serialization.ConfigurationSerializable";

    /**
     * The bukkit configuration. Most likely an {@link FileConfiguration}.
     */
    private final Configuration configuration;

    /**
     * Create a new configuration provider instance based on the underlying configuration.
     *
     * @param configuration The configuration.
     */
    @Inject
    public BukkitConfigurationProvider(@PluginConfig Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public boolean has(ConfigurationKey key) {

        return configuration.contains(key.getRawKey());
    }

    @Override
    public Property<Boolean> getBooleanProperty(ConfigurationKey configurationKey, Boolean defaultValue) {

        return Property.from(configuration.getBoolean(configurationKey.getRawKey(), defaultValue));
    }

    @Override
    public Property<Integer> getIntegerProperty(ConfigurationKey configurationKey, Integer defaultValue) {

        return Property.from(configuration.getInt(configurationKey.getRawKey(), defaultValue));
    }

    @Override
    public Property<Long> getLongProperty(ConfigurationKey configurationKey, Long defaultValue) {

        return Property.from(configuration.getLong(configurationKey.getRawKey(), defaultValue));
    }

    @Override
    public Property<Double> getDoubleProperty(ConfigurationKey configurationKey, Double defaultValue) {

        return Property.from(configuration.getDouble(configurationKey.getRawKey(), defaultValue));
    }

    @Override
    public Property<String> getStringProperty(ConfigurationKey configurationKey, String defaultValue) {

        return Property.from(configuration.getString(configurationKey.getRawKey(), defaultValue));
    }

    @Override
    public Property<Date> getDateProperty(ConfigurationKey configurationKey, Date defaultValue) {

        throw new UnsupportedOperationException(DATES_NOT_SUPPORTED_MESSAGE);
    }

    @Override
    public <T> Property<T> getObjectProperty(ConfigurationKey configurationKey, T defaultValue, Class<T> clazz) {

        if (ConfigurationSerializable.class.isAssignableFrom(clazz)) {
            throw new IllegalStateException(INVALID_SERIALIZABLE_CLASS);
        }

        Class<? extends ConfigurationSerializable> objectClass = (Class<? extends ConfigurationSerializable>) clazz;
        T result = (T) configuration.getSerializable(configurationKey.getRawKey(), objectClass);

        return Property.from(result == null ? defaultValue : result);
    }
}
