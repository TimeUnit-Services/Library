package  dev.timeunit.libraries.kt.scoreboard

import dev.timeunit.libraries.Library

class ScoreboardThread : Thread("stark - Scoreboard Thread") {

    init {
        this.isDaemon = true
    }

    override fun run() {
        while (true) {
            for (online in _root_ide_package_.dev.timeunit.libraries.Library.instance.server.onlinePlayers) {
                try {
                    _root_ide_package_.dev.timeunit.libraries.Library.getInstance().scoreboardEngine.updateScoreboard(online)
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }

            try {
                sleep(_root_ide_package_.dev.timeunit.libraries.Library.getInstance().scoreboardEngine.updateInterval * 50L)
            } catch (e2: InterruptedException) {
                e2.printStackTrace()
            }

        }
    }

}