package dev.timeunit.libraries.kt.nametags

import dev.timeunit.libraries.Library
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.bukkit.metadata.FixedMetadataValue
import org.bukkit.metadata.MetadataValue

internal class NametagListener : Listener {
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        event.player.setMetadata(
            "starkNametag-LoggedIn",
            FixedMetadataValue(_root_ide_package_.dev.timeunit.libraries.Library.getInstance(), true) as MetadataValue
        )
        _root_ide_package_.dev.timeunit.libraries.Library.getInstance().nametagEngine.initiatePlayer(event.player)
        _root_ide_package_.dev.timeunit.libraries.Library.getInstance().nametagEngine.reloadPlayer(event.player)
        _root_ide_package_.dev.timeunit.libraries.Library.getInstance().nametagEngine.reloadOthersFor(event.player)
    }

    @EventHandler
    fun onPlayerQuit(event: PlayerQuitEvent) {
        event.player.removeMetadata("starkNametag-LoggedIn", _root_ide_package_.dev.timeunit.libraries.Library.getInstance())
        _root_ide_package_.dev.timeunit.libraries.Library.getInstance().nametagEngine.teamMap.remove(event.player.name)
    }
}