package navy.warspite.minecraft.hornetplugin

import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    companion object {
        lateinit var instance: Plugin
            private set
    }

    override fun onEnable() {
        instance = this
        Config.initialise()
        getCommand("hornet")?.setExecutor(CommandRegister)
        getCommand("hornet")?.tabCompleter = TabCompleteRegister
        server.pluginManager.registerEvents(EventListener, this)
    }
}