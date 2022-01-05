package dev.timeunit.libraries.autoreboot.listeners;

import dev.timeunit.libraries.autoreboot.AutoRebootHandler;
import dev.timeunit.libraries.event.HourEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import dev.timeunit.libraries.autoreboot.AutoRebootHandler;
import dev.timeunit.libraries.event.HourEvent;

import java.util.concurrent.TimeUnit;

public class AutoRebootListener implements Listener {
    @EventHandler
    public void onHour(final HourEvent event) {
        if (AutoRebootHandler.getRebootTimes().contains(event.getHour())) {
            AutoRebootHandler.rebootServer(5, TimeUnit.MINUTES);
        }
    }
}

