package org.screamingsandals.bedwars.api;

import org.bukkit.Location;
import org.screamingsandals.bedwars.api.game.Game;

/**
 * @author Bedwars Team
 */
public interface Team {
    /**
     * @return
     */
    Game getGame();

    /**
     * @return
     */
    String getName();

    /**
     * @return
     */
    TeamColor getColor();

    /**
     * @return isNewColor boolean u
     */
    boolean isNewColor();

    /**
     * @return
     */
    Location getTeamSpawn();

    /**
     * @return
     */
    Location getTargetBlock();

    /**
     * @return
     */
    int getMaxPlayers();
}
