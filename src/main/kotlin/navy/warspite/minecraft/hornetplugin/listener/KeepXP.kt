package navy.warspite.minecraft.hornetplugin.listener

import org.bukkit.event.entity.PlayerDeathEvent

object KeepXP {
    fun event(e: PlayerDeathEvent) {
        e.keepLevel = true
        e.droppedExp = 0
    }
}