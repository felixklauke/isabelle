# isabelle
Integrating minecraft spigot servers plugin lifecycle into Netflix' Governators lifecycle extensions and provide an effective framework featuring dependency injection, configuration mapping and some general governator features for spigot plugins.

# Maven & Gradle

** Maven **

```xml
<repository>
    <id>felixklauke-repo-releases</id>
    <url>https://repo.felix-klauke.de/repository/maven-releases</url>
</repository>

<dependency>
   <groupId>de.d3adspace.isabelle</groupId>
   <artifactId>isabelle-spigot-governator</artifactId>
   <version>1.2.0</version>
</dependency>
```

** Gradle **
```gradle
repositories {

    maven {

        url = "https://repo.felix-klauke.de/repository/maven-releases"
    }
}

dependencies {

    implementation 'de.d3adspace.isabelle:isabelle-spigot-governator:1.2.0'
}
```