package org.screamingsandals.bedwars.utils;

import org.bukkit.entity.Player;
import org.screamingsandals.bedwars.Main;

public class Title {
    public static void send(Player player, String title, String subtitle) {
        int fadeIn = Main.getConfigurator().config.getInt("title.fadeIn");
        int stay = Main.getConfigurator().config.getInt("title.stay");
        int fadeOut = Main.getConfigurator().config.getInt("title.fadeOut");

        org.screamingsandals.lib.nms.title.Title.sendTitle(player, title, subtitle, fadeIn, stay, fadeOut);
    }
}
