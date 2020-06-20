package org.screamingsandals.bedwars.api.special;

import org.bukkit.inventory.ItemStack;

/**
 * @author Bedwars Team
 */
public interface WarpPowder extends SpecialItem {
    /**
     * @param removeSpecial
     * @param showMessage
     */
    void cancelTeleport(boolean removeSpecial, boolean showMessage);

    /**
     * @return
     */
    ItemStack getStack();

    /**
     *
     */
    void runTask();
}
