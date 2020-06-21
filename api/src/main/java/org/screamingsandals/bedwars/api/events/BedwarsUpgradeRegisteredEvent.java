package org.screamingsandals.bedwars.api.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.screamingsandals.bedwars.api.game.Game;
import org.screamingsandals.bedwars.api.upgrades.Upgrade;
import org.screamingsandals.bedwars.api.upgrades.UpgradeStorage;

import javax.annotation.Nonnull;

/**
 * @author Bedwars Team
 */
public class BedwarsUpgradeRegisteredEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Game game;
    private final UpgradeStorage storage;
    private final Upgrade upgrade;

    /**
     * @param game
     * @param storage
     * @param upgrade
     */
    public BedwarsUpgradeRegisteredEvent(Game game, UpgradeStorage storage, Upgrade upgrade) {
        this.game = game;
        this.storage = storage;
        this.upgrade = upgrade;
    }

    public static HandlerList getHandlerList() {
        return BedwarsUpgradeRegisteredEvent.handlers;
    }

    /**
     * @return game
     */
    public Game getGame() {
        return this.game;
    }

    @Override
    public @Nonnull
    HandlerList getHandlers() {
        return BedwarsUpgradeRegisteredEvent.handlers;
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

}
