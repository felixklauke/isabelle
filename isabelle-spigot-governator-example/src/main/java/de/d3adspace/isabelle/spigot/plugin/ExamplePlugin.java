package de.d3adspace.isabelle.spigot.plugin;

import com.google.inject.Binder;
import com.netflix.governator.annotations.PreConfiguration;
import de.d3adspace.isabelle.spigot.governator.IsabelleSpigotExtension;
import de.d3adspace.isabelle.spigot.plugin.module.ExampleModule;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import java.util.logging.Level;

/**
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class ExamplePlugin extends IsabelleSpigotExtension {

    @Inject
    private ExampleService exampleService;

    @PreConfiguration
    public void onPreConfiguration() {

        getLogger().log(Level.INFO, "Entering pre configuration phase.");
    }

    @PostConstruct
    public void onPostConstruct() {
        exampleService.executeAwesomeActions();

        getLogger().log(Level.INFO, "Entering post construction phase.");
    }

    @PreDestroy
    public void onPreDestroy() {

        getLogger().log(Level.INFO, "Entering pre deconstruction phase.");
    }

    @Override
    public void configure(Binder binder) {

        binder.install(new ExampleModule());
    }
}
