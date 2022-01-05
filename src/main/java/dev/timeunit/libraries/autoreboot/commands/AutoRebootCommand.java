package dev.timeunit.libraries.autoreboot.commands;

import dev.timeunit.libraries.utilities.commands.param.Param;
import dev.timeunit.libraries.Library;
import dev.timeunit.libraries.autoreboot.AutoRebootHandler;

import dev.timeunit.libraries.utilities.CC;
import dev.timeunit.libraries.utilities.commands.Command;
import dev.timeunit.libraries.utilities.commands.param.Param;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import dev.timeunit.libraries.kt.util.TimeUtils;

import java.util.concurrent.TimeUnit;

public class AutoRebootCommand {
    @Command(names = {"reboot"}, permission = "server.reboot")
    public static void reboot(CommandSender sender, @Param(name = "time") String unparsedTime) {
        try {
            unparsedTime = unparsedTime.toLowerCase();
            int time = TimeUtils.parseTime(unparsedTime);
            AutoRebootHandler.rebootServer(time, TimeUnit.SECONDS);
            sender.sendMessage(CC.translate("Started auto reboot."));
        } catch (Exception ex) {
            sender.sendMessage(CC.translate(ex.getMessage()));
        }
    }

    @Command(names = {"reboot cancel"}, permission = "server.reboot")
    public static void rebootCancel(CommandSender sender) {
        if (!AutoRebootHandler.isRebooting()) {
            sender.sendMessage(CC.translate("No reboot has been scheduled."));
        } else {
            AutoRebootHandler.cancelReboot();
            Library.getInstance().getServer().broadcastMessage(ChatColor.RED + "\u26a0 " + ChatColor.DARK_RED.toString() + ChatColor.STRIKETHROUGH + "------------------------" + ChatColor.RED + " \u26a0 ");
                    Library.getInstance().getServer().broadcastMessage(ChatColor.RED + "The server reboot has been cancelled.");
            Library.getInstance().getServer().broadcastMessage(ChatColor.RED + "\u26a0 " + ChatColor.DARK_RED.toString() + ChatColor.STRIKETHROUGH + "------------------------" + ChatColor.RED + " \u26a0 ");
        }
    }
}
