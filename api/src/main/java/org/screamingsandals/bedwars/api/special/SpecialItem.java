package org.screamingsandals.bedwars.api.special;

import org.bukkit.entity.Player;
import org.screamingsandals.bedwars.api.Team;
import org.screamingsandals.bedwars.api.game.Game;

/**
 * @author Bedwars Team
 */
public interface SpecialItem {
    /**
     * @return
     */
    Game getGame();

    /**
     * @return
     */
    Player getPlayer();

    /**
     * @return
     */
    Team getTeam();
}
