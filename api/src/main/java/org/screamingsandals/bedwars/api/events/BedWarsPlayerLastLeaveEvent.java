package org.screamingsandals.bedwars.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.screamingsandals.bedwars.api.RunningTeam;
import org.screamingsandals.bedwars.api.game.Game;

import javax.annotation.Nonnull;

/**
 * @author Bedwars Team
 */
public class BedWarsPlayerLastLeaveEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Game game;
    private final Player player;
    private final RunningTeam team;

    /**
     * @param game
     * @param player
     * @param team
     */
    public BedWarsPlayerLastLeaveEvent(Game game, Player player, RunningTeam team) {
        this.game = game;
        this.player = player;
        this.team = team;
    }

    public static HandlerList getHandlerList() {
        return BedWarsPlayerLastLeaveEvent.handlers;
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
        return BedWarsPlayerLastLeaveEvent.handlers;
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

}
