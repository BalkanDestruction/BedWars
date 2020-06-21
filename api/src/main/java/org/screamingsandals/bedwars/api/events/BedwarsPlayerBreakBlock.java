package org.screamingsandals.bedwars.api.events;

import org.bukkit.block.Block;
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
public class BedwarsPlayerBreakBlock extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private final Game game;
    private final Player player;
    private final RunningTeam team;
    private final Block block;
    private boolean cancel = false;
    private boolean drops = true;

    /**
     * @param game
     * @param player
     * @param team
     * @param block
     */
    public BedwarsPlayerBreakBlock(Game game, Player player, RunningTeam team, Block block) {
        this.game = game;
        this.player = player;
        this.team = team;
        this.block = block;
    }

    public static HandlerList getHandlerList() {
        return BedwarsPlayerBreakBlock.handlers;
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
        return BedwarsPlayerBreakBlock.handlers;
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
    public RunningTeam getTeam() {
        return this.team;
    }

    /**
     * @return
     */
    public Block getBlock() {
        return this.block;
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    /**
     * @return
     */
    public boolean isDrops() {
        return drops;
    }

    /**
     * @param drops
     */
    public void setDrops(boolean drops) {
        this.drops = drops;
    }

}
