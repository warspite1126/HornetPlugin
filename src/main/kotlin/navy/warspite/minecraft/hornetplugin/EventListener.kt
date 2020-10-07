package navy.warspite.minecraft.hornetplugin

import navy.warspite.minecraft.hornetplugin.listener.MinecartCollector
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.vehicle.VehicleExitEvent

object EventListener : Listener {
    @EventHandler
    private fun minecartCollector(e: VehicleExitEvent) {
        MinecartCollector.event(e)
    }

    @EventHandler
    private fun keepXP(e: PlayerDeathEvent) {
        e.keepLevel = true
        e.droppedExp = 0
    }
}