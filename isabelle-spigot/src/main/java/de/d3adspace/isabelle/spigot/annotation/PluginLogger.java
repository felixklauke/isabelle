package de.d3adspace.isabelle.spigot.annotation;

import org.bukkit.plugin.java.JavaPlugin;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Binding annotation that indicates that we want the plugin local logger injected. That one is usually got by
 * {@link JavaPlugin#getConfig()}
 *
 * @author Felix Klauke <info@felix-klauke.de>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Qualifier
public @interface PluginLogger {

}
