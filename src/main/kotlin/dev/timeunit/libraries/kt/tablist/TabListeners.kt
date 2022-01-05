package  dev.timeunit.libraries.kt.tablist

import dev.timeunit.libraries.Library
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.scheduler.BukkitRunnable

class TabListeners : Listener {

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        object : BukkitRunnable() {
            override fun run() {
                _root_ide_package_.dev.timeunit.libraries.Library.getInstance().tabEngine.addPlayer(event.player)
            }
        }.runTaskLater(_root_ide_package_.dev.timeunit.libraries.Library.getInstance(), 10L)
    }

    @EventHandler
    fun onPlayerLeave(event: PlayerQuitEvent) {
        _root_ide_package_.dev.timeunit.libraries.Library.getInstance().tabEngine.removePlayer(event.player)
        TabLayout.remove(event.player)
    }

}