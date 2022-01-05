package dev.timeunit.libraries.kt.nametags

import dev.timeunit.libraries.Library
import java.util.concurrent.ConcurrentHashMap

internal class NametagThread : Thread("stark - Nametag Thread") {
    init {
        this.isDaemon = true
    }

    override fun run() {
        while (true) {
            val pendingUpdatesIterator = pendingUpdates.keys.iterator()
            while (pendingUpdatesIterator.hasNext()) {
                val pendingUpdate = pendingUpdatesIterator.next()
                try {
                    _root_ide_package_.dev.timeunit.libraries.Library.getInstance().nametagEngine.applyUpdate(pendingUpdate)
                    pendingUpdatesIterator.remove()
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }

            try {
                sleep(_root_ide_package_.dev.timeunit.libraries.Library.getInstance().nametagEngine.updateInterval * 50L)
            } catch (e2: InterruptedException) {
                e2.printStackTrace()
            }

        }
    }

    companion object {
        var pendingUpdates = ConcurrentHashMap<NametagUpdate, Boolean>()
    }
}