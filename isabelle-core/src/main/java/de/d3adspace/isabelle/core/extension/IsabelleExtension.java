package de.d3adspace.isabelle.core.extension;

import de.d3adspace.isabelle.core.lifecycle.IsabelleLifecycleAware;

/**
 * General extension endpoint defining what all our extensions are capable of. You can gather some metadata using
 * {@link #getName()} and {@link #getVersion()}. Take a look at their corresponding javadocs to determine how the meta
 * information are formatted and can be used.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 * @see IsabelleLifecycleAware The life cycle integration.
 */
public interface IsabelleExtension extends IsabelleLifecycleAware {

    /**
     * Get the name of the extension. Should be in format of
     *
     * <pre>{groupId}.{artifactId}</pre>
     * <p>
     * For example:
     *
     * <pre>
     *     de.d3adspace.extension.MyNiceExtension
     * </pre>
     *
     * @return The name of the extension.
     */
    String getName();

    /**
     * Get the version of the extension. Should be configured via semantic versioning and optionally a suffix.
     * <p>
     * For example:
     *
     * <ul>
     * <li>1.0.0</li>
     * <li>1.1.0</li>
     * <li>1.2.3</li>
     *
     * <li>1.0.0-SNAPSHOT</li>
     * <li>2.0.0-RELEASE</li>
     * <li>2.3.1-RC1</li>
     * </ul>
     *
     * @return The version of the extension.
     */
    String getVersion();
}
