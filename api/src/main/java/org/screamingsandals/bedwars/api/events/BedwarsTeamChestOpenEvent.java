package org.screamingsandals.bedwars.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.screamingsandals.bedwars.api.RunningTeam;
import org.screamingsandals.bedwars.api.game.Game;

import javax.annotation.Nonnull;

/**
 * @author Bedwars Team
 */
public class BedwarsTeamChestOpenEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Game game;
    private final Player player;
    private final RunningTeam team;
    private boolean cancelled = false;

    /**
     * @param game
     * @param player
     * @param team
     */
    public BedwarsTeamChestOpenEvent(Game game, Player player, RunningTeam team) {
        this.player = player;
        this.team = team;
        this.game = game;
    }

    public static HandlerList getHandlerList() {
        return BedwarsTeamChestOpenEvent.handlers;
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
        return BedwarsTeamChestOpenEvent.handlers;
    }

    /**
     * @return player
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * @return team of player
     */
    public RunningTeam getTeam() {
        return this.team;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
