package  dev.timeunit.libraries.kt.scoreboard

import org.bukkit.entity.Player
import java.util.*

interface ScoreGetter {

    fun getScores(scores: LinkedList<String>, player: Player)

}