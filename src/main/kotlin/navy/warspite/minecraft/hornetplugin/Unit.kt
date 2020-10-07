package navy.warspite.minecraft.hornetplugin

import org.bukkit.ChatColor

object Unit {
    fun colouredMessage(string: String): String {
        return ChatColor.translateAlternateColorCodes('&',"&r[&cHornetPL&r] $string")
    }
    fun colouredText(string: String): String {
        return ChatColor.translateAlternateColorCodes('&', string)
    }
}