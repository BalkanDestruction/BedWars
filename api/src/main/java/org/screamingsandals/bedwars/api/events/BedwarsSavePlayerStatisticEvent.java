package org.screamingsandals.bedwars.api.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.screamingsandals.bedwars.api.statistics.PlayerStatistic;

import javax.annotation.Nonnull;

/**
 * @author Bedwars Team
 */
public class BedwarsSavePlayerStatisticEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final PlayerStatistic playerStatistic;
    private boolean cancelled = false;

    /**
     * @param playerStatistic
     */
    public BedwarsSavePlayerStatisticEvent(PlayerStatistic playerStatistic) {
        this.playerStatistic = playerStatistic;
    }

    public static HandlerList getHandlerList() {
        return BedwarsSavePlayerStatisticEvent.handlers;
    }

    @Override
    public @Nonnull
    HandlerList getHandlers() {
        return BedwarsSavePlayerStatisticEvent.handlers;
    }

    /**
     * @return statistics
     */
    public PlayerStatistic getPlayerStatistic() {
        return this.playerStatistic;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

}