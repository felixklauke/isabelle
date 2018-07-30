package de.d3adspace.isabelle.core.lifecycle;

import de.d3adspace.isabelle.core.extension.IsabelleExtension;

/**
 * Marks an unit that is aware of its lifecycle. The lifecycle is started via {@link #bootstrap()} followed by
 * {@link #start()} and ended via {@link #tearDown()}.
 * <p>
 * You may check the status of the lifecycle at any time using {@link #isAlive()}.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 * @see IsabelleExtension A common derivative.
 */
public interface IsabelleLifecycleAware {

    /**
     * Bootstrap the life cycle.
     */
    void bootstrap();

    /**
     * Start the life cycle-
     */
    void start();

    /**
     * End the life cycle.
     */
    void tearDown();

    /**
     * Checks if the lifecycle is currently active.
     */
    void isAlive();
}
