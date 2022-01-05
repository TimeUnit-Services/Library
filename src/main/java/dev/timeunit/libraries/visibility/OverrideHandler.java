package dev.timeunit.libraries.visibility;

import org.bukkit.entity.Player;

public interface OverrideHandler {
    OverrideAction getAction(final Player p0, final Player p1);
}
