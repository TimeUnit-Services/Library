package  dev.timeunit.libraries.kt.scoreboard

import dev.timeunit.libraries.Library
import org.bukkit.entity.Player

class ScoreboardEngine {
    private val boards: HashMap<String, Scoreboard> = HashMap()
    var configuration: ScoreboardConfiguration? = null
    var updateInterval: Int = 2

    fun load() {
        ScoreboardThread().start()
        _root_ide_package_.dev.timeunit.libraries.Library.getInstance().server.pluginManager.registerEvents(ScoreboardListeners(), _root_ide_package_.dev.timeunit.libraries.Library.getInstance())
    }

    internal fun create(player: Player) {
        if (configuration != null) {
            boards[player.name] = Scoreboard(player)
        }
    }

    internal fun updateScoreboard(player: Player) {
        boards[player.name]?.update()
    }

    internal fun remove(player: Player) {
        boards.remove(player.name)
    }
}