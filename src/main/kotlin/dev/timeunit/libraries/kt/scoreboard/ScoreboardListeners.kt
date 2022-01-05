package  dev.timeunit.libraries.kt.scoreboard

import dev.timeunit.libraries.Library
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class ScoreboardListeners : Listener {

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        _root_ide_package_.dev.timeunit.libraries.Library.getInstance().scoreboardEngine.create(event.player)
    }

    @EventHandler
    fun onPlayerQuit(event: PlayerQuitEvent) {
        _root_ide_package_.dev.timeunit.libraries.Library.getInstance().scoreboardEngine.remove(event.player)
    }

}