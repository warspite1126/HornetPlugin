import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
    kotlin("jvm") version "1.4.10"
    kotlin("plugin.serialization") version "1.4.10"
    id("net.minecrell.plugin-yml.bukkit") version "0.3.0"
}

repositories {
    jcenter()
    mavenCentral()
    maven { url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots") }
}

dependencies {
    compileOnly(kotlin("stdlib-jdk8"))
    compileOnly( "org.jetbrains.kotlinx:kotlinx-serialization-core:1.0.0-RC2")
    compileOnly( "com.charleskorn.kaml:kaml:0.24.0")
    implementation("org.spigotmc:spigot-api:1.16.3-R0.1-SNAPSHOT")
}

bukkit {
    main = "navy.warspite.minecraft.hornetplugin.Main"
    version = "1.0"
    apiVersion = "1.16"
    author = "warspite1126"
    defaultPermission = BukkitPluginDescription.Permission.Default.OP

    commands {
        register("hornet") {
            aliases = listOf("hon")
            permission = "hornetplugin.admin"
        }
        register("setspawn") {

        }
    }

    permissions {
        register("hornetplugin.*") {
            children = listOf("hornetplugin.admin")
        }
        register("hornetplugin.admin") {
            default = BukkitPluginDescription.Permission.Default.OP
        }
        register("hornetplugin.spawn") {
            default = BukkitPluginDescription.Permission.Default.TRUE
        }
        register("hornetplugin.keepxp") {
            default = BukkitPluginDescription.Permission.Default.TRUE
        }
        register("hornetplugin.minecart") {
            default = BukkitPluginDescription.Permission.Default.TRUE
        }
    }
}

val jar by tasks.getting(Jar::class) {
    from(configurations.compileOnly.get().map {
        if (it.isDirectory) it else zipTree(it)
    })
}
