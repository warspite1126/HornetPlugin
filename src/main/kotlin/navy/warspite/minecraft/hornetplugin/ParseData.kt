package navy.warspite.minecraft.hornetplugin

import kotlinx.serialization.Serializable

object ParseData {
    @Serializable
    data class Config (
        val KeepXP: Boolean = true,
        val QuickSleep: Boolean = true,
        val MinecartCollector: Boolean = true
    )

    @Serializable
    data class SpawnLocation(
        val World: String? = null,
        val X: Double? = null,
        val Y: Double? = null,
        val Z: Double? = null,
        val Yaw: Double? = null,
        val Pitch: Double? = null
    )
}