package org.screamingsandals.bedwars.api.boss;

import org.bukkit.entity.Player;

import java.util.List;

/**
 * @author Bedwars Team
 */
public interface StatusBar {

    /**
     * @param player
     */
    void addPlayer(Player player);

    /**
     * @param player
     */
    void removePlayer(Player player);

    /**
     * @return list of all viewers
     */
    List<Player> getViewers();

    /**
     * @return progress of status bar
     */
    double getProgress();

    /**
     * @param progress
     */
    void setProgress(double progress);

    /**
     * @return visibility of status bar
     */
    boolean isVisible();

    /**
     * @param visible
     */
    void setVisible(boolean visible);
}
