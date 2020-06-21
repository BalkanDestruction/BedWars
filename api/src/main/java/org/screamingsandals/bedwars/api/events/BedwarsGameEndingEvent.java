package org.screamingsandals.bedwars.api.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.screamingsandals.bedwars.api.RunningTeam;
import org.screamingsandals.bedwars.api.game.Game;

import javax.annotation.Nonnull;

/**
 * @author Bedwars Team
 */
public class BedwarsGameEndingEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private final Game game;
    private final RunningTeam winningTeam;

    /**
     * @param game
     */
    public BedwarsGameEndingEvent(Game game, RunningTeam winningTeam) {
        this.winningTeam = winningTeam;
        this.game = game;
    }

    public static HandlerList getHandlerList() {
        return BedwarsGameEndingEvent.handlers;
    }

    /**
     * @return game
     */
    public Game getGame() {
        return this.game;
    }

    /**
     * @return team that won bedwars match
     */
    public RunningTeam getWinningTeam() {
        return this.winningTeam;
    }

    @Override
    public @Nonnull
    HandlerList getHandlers() {
        return BedwarsGameEndingEvent.handlers;
    }

}
