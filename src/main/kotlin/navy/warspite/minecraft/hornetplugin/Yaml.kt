package navy.warspite.minecraft.hornetplugin

import com.charleskorn.kaml.Yaml
import kotlinx.serialization.encodeToString
import java.nio.file.Files
import java.nio.file.Paths

object Yaml {
    private val dir = Paths.get("./plugins/HornetPlugin")
    private const val fileExtension = ".yml"
    private val defaultFiles = linkedMapOf(
        "config$fileExtension" to ParseData.Config(),
        "spawnLocation$fileExtension" to ParseData.SpawnLocation()
    )
    val yaml = LinkedHashMap<String, Any>()

    fun initialise() {
        yaml.clear()
        createConfigFile()
//        yaml.putAll(loadFiles())
        Main.instance.logger.info("YML: ${yaml.keys}")
    }

//    private fun loadFiles(): LinkedHashMap<String, Any> {
//        if (!Files.isDirectory(dir) || Files.notExists(dir)) createConfigFile()
//        val files = linkedMapOf<String, Any>()
//        for (file in Files.list(dir)) {
//            if (!"$file".endsWith(".yml")) continue
//            val fileText = file.toFile().readText()
//            val fileYaml = when ("${file.fileName}") {
//                "config.yml" -> Yaml.default.decodeFromString<ParseData.Config>(fileText)
//                "spawnLocation.yml" -> Yaml.default.decodeFromString<ParseData.SpawnLocation>(fileText)
//                else -> null
//            }
//                ?: continue
//            files["${file.fileName}"] = fileYaml
//        }
//        return files
//    }

    private fun createConfigFile() {
        if (!Files.isDirectory(dir) || Files.notExists(dir)) Files.createDirectory(dir)
        for (file in defaultFiles) {
            if (Files.notExists(dir.resolve(file.key))) {
                val f = Yaml.default.encodeToString(file.value).split('\n')
                Files.write(dir.resolve(file.key), f)
            }
        }
    }
}