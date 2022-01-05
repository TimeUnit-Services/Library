package dev.timeunit.libraries.kt.nametags

import dev.timeunit.libraries.Library
import org.bukkit.entity.Player

abstract class NametagProvider
constructor(val name: String, val weight: Int) {

    abstract fun fetchNametag(toRefresh: Player, refreshFor: Player): NametagInfo

    class DefaultNametagProvider : NametagProvider("Default Provider", 0) {
        override fun fetchNametag(toRefresh: Player, refreshFor: Player): NametagInfo {
            return createNametag("", "")
        }
    }

    companion object {
        @JvmStatic
        fun createNametag(prefix: String, suffix: String): NametagInfo {
            return _root_ide_package_.dev.timeunit.libraries.Library.getInstance().nametagEngine.getOrCreate(prefix, suffix)
        }
    }

}