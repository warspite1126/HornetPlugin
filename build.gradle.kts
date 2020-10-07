plugins {
    java
    id("org.jetbrains.kotlin.jvm") version "1.4.10"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.4.10"
    id("net.minecrell.plugin-yml.bukkit") version "0.3.0"
}

group "navy.warspite.minecraft"
version "1.0"

repositories {
    jcenter()
    mavenCentral()
    maven { url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots") }
}

dependencies {
    compileOnly("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    compileOnly( "com.charleskorn.kaml:kaml:0.24.0")
    compileOnly( "org.jetbrains.kotlinx:kotlinx-serialization-core:1.0.0-RC2")
    implementation("org.spigotmc:spigot-api:1.16.3-R0.1-SNAPSHOT")
}

bukkit {
    main = "navy.warspite.minecraft.hornetplugin.Main"
    version = "1.0"
    apiVersion = "1.16"
    author = "warspite1126"
}

val jar by tasks.getting(Jar::class) {
    from(configurations.compileOnly.get().map {
        if (it.isDirectory) it else zipTree(it)
    })
}
