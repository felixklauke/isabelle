package de.d3adspace.isabelle.spigot.plugin.module;

import com.google.inject.AbstractModule;
import com.google.inject.ImplementedBy;
import de.d3adspace.isabelle.spigot.plugin.ExampleService;
import de.d3adspace.isabelle.spigot.plugin.ExampleServiceImpl;

/**
 * Example module for bindings.
 * <p>
 * Note that this isn't even needed as {@link ExampleService} uses {@link ImplementedBy} ot provide a default
 * implementation in runtime. The module was added anyways for demonstration reasons.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class ExampleModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(ExampleService.class).to(ExampleServiceImpl.class);
    }
}
