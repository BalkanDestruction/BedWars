package org.screamingsandals.bedwars.api.utils;

import org.bukkit.entity.Player;
import org.screamingsandals.bedwars.api.special.SpecialItem;

/**
 * @author Bedwars Team
 */
public interface DelayFactory {

    /**
     * @return
     */
    boolean getDelayActive();

    /**
     * @return
     */
    SpecialItem getSpecialItem();

    /**
     * @return
     */
    int getRemainDelay();

    /**
     * @return
     */
    Player getPlayer();
}
