package de.d3adspace.isabelle.spigot.governator.annotation;

import de.d3adspace.isabelle.spigot.governator.module.SpigotModule;
import org.bukkit.Bukkit;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Binding annotation that indicates that we want the server wide logger injected that is normally got by
 * {@link Bukkit#getLogger()}.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 * @see SpigotModule The module this annotation is bound in.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Qualifier
public @interface ServerLogger {

}
