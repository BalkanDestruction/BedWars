package org.screamingsandals.bedwars.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.screamingsandals.bedwars.api.game.Game;

import javax.annotation.Nonnull;

/**
 * @author Bedwars Team
 */
public class BedwarsOpenTeamSelectionEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final Game game;
    private final Player player;
    private boolean cancelled = false;

    /**
     * @param game
     * @param player
     */
    public BedwarsOpenTeamSelectionEvent(Game game, Player player) {
        this.player = player;
        this.game = game;
    }

    public static HandlerList getHandlerList() {
        return BedwarsOpenTeamSelectionEvent.handlers;
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
        return BedwarsOpenTeamSelectionEvent.handlers;
    }

    /**
     * @return player
     */
    public Player getPlayer() {
        return this.player;
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
