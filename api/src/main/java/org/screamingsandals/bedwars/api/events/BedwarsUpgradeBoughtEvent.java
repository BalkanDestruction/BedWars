package org.screamingsandals.bedwars.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.screamingsandals.bedwars.api.game.Game;
import org.screamingsandals.bedwars.api.upgrades.Upgrade;
import org.screamingsandals.bedwars.api.upgrades.UpgradeStorage;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @author Bedwars Team
 */
public class BedwarsUpgradeBoughtEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Game game;
    private final List<Upgrade> upgrades;
    private final Player customer;
    private final UpgradeStorage storage;
    private final double addLevels;
    private boolean cancelled = false;

    /**
     * @param game
     * @param storage
     * @param upgrades
     * @param customer
     * @param addLevels
     */
    public BedwarsUpgradeBoughtEvent(Game game, UpgradeStorage storage, List<Upgrade> upgrades, Player customer,
                                     double addLevels) {
        this.game = game;
        this.upgrades = upgrades;
        this.customer = customer;
        this.addLevels = addLevels;
        this.storage = storage;
    }

    public static HandlerList getHandlerList() {
        return BedwarsUpgradeBoughtEvent.handlers;
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
        return BedwarsUpgradeBoughtEvent.handlers;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    /**
     * @return list of upgrades
     */
    public List<Upgrade> getUpgrades() {
        return upgrades;
    }

    /**
     * @return customer
     */
    public Player getCustomer() {
        return customer;
    }

    /**
     * @return addition
     */
    public double getAddLevels() {
        return addLevels;
    }

    /**
     * @return storage for these upgrades type
     */
    public UpgradeStorage getStorage() {
        return storage;
    }

}
