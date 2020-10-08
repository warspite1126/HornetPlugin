package navy.warspite.minecraft.hornetplugin

import navy.warspite.minecraft.hornetplugin.listener.KeepXP
import navy.warspite.minecraft.hornetplugin.listener.MinecartCollector
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.vehicle.VehicleExitEvent

object EventListener : Listener {
    private val perm = "hornetplugin"
    @EventHandler
    private fun minecartCollector(e: VehicleExitEvent) {
        val p = e.exited as Player
        if (!p.hasPermission("${perm}.minecart")) return
        MinecartCollector.event(e)
    }

    @EventHandler
    private fun keepXP(e: PlayerDeathEvent) {
        val p = e.entity
        if (!p.hasPermission("${perm}.keepxp")) return
        KeepXP.event(e)
    }
}