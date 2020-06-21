package org.screamingsandals.bedwars.api.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.screamingsandals.bedwars.api.game.Game;

import javax.annotation.Nonnull;

/**
 * @author Bedwars Team
 */
public class BedwarsPreRebuildingEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Game game;

    /**
     * @param game
     */
    public BedwarsPreRebuildingEvent(Game game) {
        this.game = game;
    }

    public static HandlerList getHandlerList() {
        return BedwarsPreRebuildingEvent.handlers;
    }

    @Override
    public @Nonnull
    HandlerList getHandlers() {
        return BedwarsPreRebuildingEvent.handlers;
    }

    /**
     * @return game
     */
    public Game getGame() {
        return this.game;
    }

}
