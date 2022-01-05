package dev.timeunit.libraries.menu.menu;

import dev.timeunit.libraries.menu.Button;
import dev.timeunit.libraries.menu.Menu;
import dev.timeunit.libraries.menu.buttons.BooleanButton;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import dev.timeunit.libraries.kt.Callback;

import java.util.HashMap;
import java.util.Map;

public class ConfirmMenu extends Menu {
    private String title;

    private Callback<Boolean> response;

    public ConfirmMenu(String title, Callback<Boolean> response) {
        this.title = title;
        this.response = response;
    }

    @Override
    public Map<Integer, Button> getButtons(Player player) {
        HashMap<Integer, Button> buttons = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            if (i == 3) {
                buttons.put(i, new BooleanButton(true, this.response));
            } else if (i == 5) {
                buttons.put(i, new BooleanButton(false, this.response));
            } else {
                buttons.put(i, Button.placeholder(Material.STAINED_GLASS_PANE, (byte) 14));
            }
        }
        return buttons;
    }

    @Override
    public String getTitle(Player player) {
        return this.title;
    }
}
