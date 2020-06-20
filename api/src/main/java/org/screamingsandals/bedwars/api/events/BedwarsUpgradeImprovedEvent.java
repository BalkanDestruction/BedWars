package org.screamingsandals.bedwars.api.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.screamingsandals.bedwars.api.game.Game;
import org.screamingsandals.bedwars.api.upgrades.Upgrade;
import org.screamingsandals.bedwars.api.upgrades.UpgradeStorage;

/**
 * @author Bedwars Team
 */
public class BedwarsUpgradeImprovedEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Game game;
    private final UpgradeStorage storage;
    private final Upgrade upgrade;
    private final double oldLevel;
    private final double newLevel;

    /**
     * @param game
     * @param storage
     * @param upgrade
     * @param oldLevel
     * @param newLevel
     */
    public BedwarsUpgradeImprovedEvent(Game game, UpgradeStorage storage, Upgrade upgrade, double oldLevel,
                                       double newLevel) {
        this.game = game;
        this.storage = storage;
        this.upgrade = upgrade;
        this.oldLevel = oldLevel;
        this.newLevel = newLevel;
        upgrade.setLevel(newLevel);
    }

    public static HandlerList getHandlerList() {
        return BedwarsUpgradeImprovedEvent.handlers;
    }

    /**
     * @return game
     */
    public Game getGame() {
        return this.game;
    }

    @Override
    public HandlerList getHandlers() {
        return BedwarsUpgradeImprovedEvent.handlers;
    }

    @Override
    public boolean isCancelled() {
        return upgrade.getLevel() == oldLevel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        upgrade.setLevel(cancel ? oldLevel : newLevel);
    }

    /**
     * @return upgrade
     */
    public Upgrade getUpgrade() {
        return upgrade;
    }

    /**
     * @return storage of this upgrades type
     */
    public UpgradeStorage getStorage() {
        return storage;
    }

    /**
     * @return new level
     */
    public double getNewLevel() {
        return upgrade.getLevel();
    }

    /**
     * @param newLevel
     */
    public void setNewLevel(double newLevel) {
        upgrade.setLevel(newLevel);
    }

    /**
     * @return old level
     */
    public double getOldLevel() {
        return oldLevel;
    }

    /**
     * @return new level (not edited by this event)
     */
    public double getOriginalNewLevel() {
        return newLevel;
    }

}
