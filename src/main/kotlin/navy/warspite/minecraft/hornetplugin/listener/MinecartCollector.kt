package navy.warspite.minecraft.hornetplugin.listener

import org.bukkit.Material
import org.bukkit.entity.Minecart
import org.bukkit.entity.Player
import org.bukkit.event.vehicle.VehicleExitEvent
import org.bukkit.inventory.ItemStack

object MinecartCollector {
    fun event(e: VehicleExitEvent) {
        if (e.exited !is Player) return
        if (e.vehicle !is Minecart) return
        e.vehicle.remove()
        val player = e.exited as Player
        if (player.inventory.firstEmpty() < 0) return
        player.inventory.addItem(ItemStack(Material.MINECART, 1))
    }
}