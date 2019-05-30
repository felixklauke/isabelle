# isabelle
Integrating minecraft spigot servers plugin lifecycle into lifecycle extensions and provide an effective framework featuring dependency injection, configuration mapping and some general governator features for spigot plugins.

Integrations:
1. [Theresa](https://github.com/FelixKlauke/theresa) - My own dependency injection framework based on Guice
2. [Governator](https://github.com/Netflix/governator) - A dependency injection framework based on Google developed by Netflix. In maintenance mode and therefor deprecated.

# Status
|             	| Build Status                                                                                                                                              	| Test Code Coverage                                                                                                                                               	|
|-------------	|-----------------------------------------------------------------------------------------------------------------------------------------------------------	|------------------------------------------------------------------------------------------------------------------------------------------------------------------	|
| Master      	| [![Build Status](https://travis-ci.org/FelixKlauke/isabelle.svg?branch=master)](https://travis-ci.org/FelixKlauke/isabelle) 	| [![codecov](https://codecov.io/gh/FelixKlauke/isabelle/branch/master/graph/badge.svg)](https://codecov.io/gh/FelixKlauke/isabelle) 	|
| Development 	| [![Build Status](https://travis-ci.org/FelixKlauke/isabelle.svg?branch=dev)](https://travis-ci.org/FelixKlauke/isabelle)    	| [![codecov](https://codecov.io/gh/FelixKlauke/isabelle/branch/dev/graph/badge.svg)](https://codecov.io/gh/FelixKlauke/isabelle)    	|

# Maven & Gradle

**Maven Repositories**

```xml
<repositories>
    <!-- Klauke Enterprises Releases -->
    <repository>
        <id>klauke-enterprises-maven-releases</id>
        <name>Klauke Enterprises Maven Releases</name>
        <url>https://repository.klauke-enterprises.com/repository/maven-releases/</url>
    </repository>
	
    <!-- Klauke Enterprises Snapshots -->
    <repository>
        <id>klauke-enterprises-maven-snapshots</id>
        <name>Klauke Enterprises Maven Snapshots</name>
        <url>https://repository.klauke-enterprises.com/repository/maven-snapshots/</url>
    </repository>
</repositories>
```

**Maven dependencies**

```xml
<dependency>
   <groupId>de.d3adspace.isabelle</groupId>
   <artifactId>isabelle-spigot-governator</artifactId>
   <version>1.2.0</version>
</dependency>
```

# How it works
Isabelle provides a single endpoint class called `IsabelleSpigotExtension`
(`de.d3adspace.isabelle.spigot.governator.IsabelleSpigotExtension`). Instead of using the well known `JavaPlugin` you
just have to extend our class and the magic begins. You can take a look at
https://github.com/Isariel/laura/blob/dev/spigot/src/main/java/de/d3adspace/laura/spigot/extension/LauraSpigotExtension.java
for a full featured example but you can also do a quick start with our internal example.

**Basic structure**:
```java
package de.d3adspace.isabelle.spigot.plugin;

import de.d3adspace.isabelle.spigot.governator.IsabelleSpigotExtension;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.logging.Level;

/**
 * @author Felix Klauke <info@felix-klauke.de>
 */
public class ExamplePlugin extends IsabelleSpigotExtension {

    @PostConstruct
    public void onPostConstruct() {
        exampleService.executeAwesomeActions();

        getLogger().log(Level.INFO, "Entering post construction phase.");
    }

    @PreDestroy
    public void onPreDestroy() {

        getLogger().log(Level.INFO, "Entering pre deconstruction phase.");
    }
}
```

You can find the corresponding full example source here:
https://github.com/FelixKlauke/isabelle/blob/dev/isabelle-spigot-governator-example/src/main/java/de/d3adspace/isabelle/spigot/plugin/ExamplePlugin.java

**Depdendency Injection**:
As we use Governator/Theresa and Guice under the hood we have a powerful dependency injection mechanism.

