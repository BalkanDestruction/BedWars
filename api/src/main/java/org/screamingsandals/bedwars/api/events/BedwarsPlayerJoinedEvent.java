package org.screamingsandals.bedwars.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.screamingsandals.bedwars.api.Team;
import org.screamingsandals.bedwars.api.game.Game;

import javax.annotation.Nonnull;

/**
 * @author Bedwars Team
 */
public class BedwarsPlayerJoinedEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private final Game game;
    private final Player player;
    private final Team team;

    /**
     * @param game
     * @param team
     * @param player
     */
    public BedwarsPlayerJoinedEvent(Game game, Team team, Player player) {
        this.game = game;
        this.player = player;
        this.team = team;
    }

    public static HandlerList getHandlerList() {
        return BedwarsPlayerJoinedEvent.handlers;
    }

    /**
     * @return
     */
    public Game getGame() {
        return this.game;
    }

    @Override
    public @Nonnull
    HandlerList getHandlers() {
        return BedwarsPlayerJoinedEvent.handlers;
    }

    /**
     * @return
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * @return
     */
    public Team getTeam() {
        return this.team;
    }

}
