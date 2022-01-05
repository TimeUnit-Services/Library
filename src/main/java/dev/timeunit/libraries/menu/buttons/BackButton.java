package dev.timeunit.libraries.menu.buttons;

import dev.timeunit.libraries.menu.Button;
import dev.timeunit.libraries.menu.Menu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import java.util.ArrayList;
import java.util.List;

public class BackButton extends Button {

    private Menu back;

    public BackButton(Menu back) {
        this.back = back;
    }

    @Override
    public Material getMaterial(Player player) {
        return Material.BED;
    }

    @Override
    public byte getDamageValue(Player player) {
        return 0;
    }

    @Override
    public String getName(Player player) {
        return "§cGo Back";
    }

    @Override
    public List<String> getDescription(Player player) {
        return new ArrayList<>();
    }

    @Override
    public void clicked(Player player, int i, ClickType clickType) {
        Button.playNeutral(player);
        this.back.openMenu(player);
    }

}
