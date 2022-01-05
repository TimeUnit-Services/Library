package  dev.timeunit.libraries.kt.tablist

import dev.timeunit.libraries.Library
import org.bukkit.Bukkit

class TabThread : Thread("stark - Tab Thread") {

    private val protocolLib = Bukkit.getServer().pluginManager.getPlugin("ProtocolLib")

    init {
        this.isDaemon = true
    }

    override fun run() {
        while (_root_ide_package_.dev.timeunit.libraries.Library.getInstance().isEnabled && protocolLib != null && protocolLib.isEnabled) {
            for (online in _root_ide_package_.dev.timeunit.libraries.Library.getInstance().server.getOnlinePlayers()) {
                try {
                    _root_ide_package_.dev.timeunit.libraries.Library.getInstance().tabEngine.updatePlayer(online)
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }

            try {
                sleep(250L)
            } catch (e2: InterruptedException) {
                e2.printStackTrace()
            }

        }
    }

}