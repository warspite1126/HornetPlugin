package navy.warspite.minecraft.hornetplugin

import com.charleskorn.kaml.Yaml
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import java.nio.file.Files
import java.nio.file.Paths

object Config {
    private val plugin = Main.instance
    private val dir = Paths.get("./plugins/${plugin.name}")
    private const val fileEx = ".yml"
    private lateinit var config: ParseData.Config

    fun initialise() {
        config = loadConfigFile()
    }

    private fun loadConfigFile(): ParseData.Config {
        initialiseConfigFile()
        val file = dir.resolve("config$fileEx").toFile().readText()
        return Yaml.default.decodeFromString(file)
    }

    private fun initialiseConfigFile() {
        if (!Files.isDirectory(dir) || Files.notExists(dir)) Files.createDirectory(dir)
        if (Files.notExists(dir.resolve("config$fileEx"))) {
            val file = Yaml.default.encodeToString(ParseData.Config()).split('\n')
            Files.write(dir.resolve("config$fileEx"), file)
        }
    }
}