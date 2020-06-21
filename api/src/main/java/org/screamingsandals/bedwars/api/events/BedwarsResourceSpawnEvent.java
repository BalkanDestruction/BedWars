package org.screamingsandals.bedwars.api.events;

import org.bukkit.Location;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.screamingsandals.bedwars.api.game.Game;
import org.screamingsandals.bedwars.api.game.ItemSpawner;
import org.screamingsandals.bedwars.api.game.ItemSpawnerType;

import javax.annotation.Nonnull;

/**
 * @author Bedwars Team
 */
public class BedwarsResourceSpawnEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final Game game;
    private final ItemSpawner spawner;
    private boolean cancelled = false;
    private ItemStack resource;

    /**
     * @param game
     * @param spawner
     * @param resource
     */
    public BedwarsResourceSpawnEvent(Game game, ItemSpawner spawner, ItemStack resource) {
        this.game = game;
        this.spawner = spawner;
        this.resource = resource;
    }

    public static HandlerList getHandlerList() {
        return BedwarsResourceSpawnEvent.handlers;
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
        return BedwarsResourceSpawnEvent.handlers;
    }

    /**
     * @return spawner
     */
    public ItemSpawner getSpawner() {
        return this.spawner;
    }

    /**
     * @return location
     */
    public Location getLocation() {
        return this.spawner.getLocation();
    }

    /**
     * @return resource
     */
    public ItemStack getResource() {
        return this.resource;
    }

    /**
     * @param resource
     */
    public void setResource(ItemStack resource) {
        this.resource = resource;
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
     * @return spawner type
     */
    public ItemSpawnerType getType() {
        return this.spawner.getItemSpawnerType();
    }

}
