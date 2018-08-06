package de.d3adspace.isabelle.spigot.plugin;

import com.google.inject.ImplementedBy;

/**
 * Interface for an example service with {@link ExampleServiceImpl} as a default implementation.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 * @see ExampleServiceImpl The default implementation.
 */
@ImplementedBy(ExampleServiceImpl.class)
public interface ExampleService {

    /**
     * Do some awesome stuff.
     */
    void executeAwesomeActions();
}
