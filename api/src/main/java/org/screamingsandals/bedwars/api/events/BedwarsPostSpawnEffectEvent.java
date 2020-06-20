package org.screamingsandals.bedwars.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.screamingsandals.bedwars.api.game.Game;

/**
 * @author Bedwars Team
 */
public class BedwarsPostSpawnEffectEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Game game;
    private final Player player;
    private final String effectsGroupName;

    /**
     * @param game
     * @param player
     * @param effectsGroupName
     */
    public BedwarsPostSpawnEffectEvent(Game game, Player player, String effectsGroupName) {
        this.game = game;
        this.player = player;
        this.effectsGroupName = effectsGroupName;
    }

    public static HandlerList getHandlerList() {
        return BedwarsPostSpawnEffectEvent.handlers;
    }

    /**
     * @return game
     */
    public Game getGame() {
        return this.game;
    }

    /**
     * @return player
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * @return effects group
     */
    public String getEffectsGroupName() {
        return this.effectsGroupName;
    }

    @Override
    public HandlerList getHandlers() {
        return BedwarsPostSpawnEffectEvent.handlers;
    }

}
