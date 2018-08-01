package de.d3adspace.isabelle.spigot.plugin;

import com.google.inject.Scopes;
import com.netflix.governator.annotations.Configuration;
import com.netflix.governator.annotations.PreConfiguration;
import de.d3adspace.isabelle.spigot.governator.annotation.PluginLogger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An example service using standard injection and lifecycle mechanisms.
 * <p>
 * The service is bound in {@link Scopes#SINGLETON} to prevent multiple instantiations.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 */
@Singleton
public class ExampleServiceImpl implements ExampleService {

    /**
     * The logger (plugin tagged).
     */
    private final Logger logger;

    /**
     * An example message provided via configuration mapping.
     */
    @Configuration(value = "example.message", documentation = "A fancy example message.")
    private String exampleMessage = "I'm a default message.";

    /**
     * Create a new example service instance.
     *
     * @param logger The logger.
     */
    @Inject
    public ExampleServiceImpl(@PluginLogger Logger logger) {
        this.logger = logger;
    }

    @Override
    public void executeAwesomeActions() {

        logger.log(Level.INFO, exampleMessage);
    }

    @PreConfiguration
    public void onPreConfiguration() {

        logger.log(Level.INFO, "Example service is now in pre configuration phase.");
    }

    @PostConstruct
    public void onPostConstruct() {

        logger.log(Level.INFO, "Example service is now in post construction phase.");
    }

    @PreDestroy
    public void onPreDestroy() {

        logger.log(Level.INFO, "Cleaning up the example service.");
    }
}
