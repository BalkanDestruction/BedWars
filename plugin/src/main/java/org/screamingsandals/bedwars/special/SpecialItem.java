package org.screamingsandals.bedwars.special;

import org.bukkit.entity.Player;
import org.screamingsandals.bedwars.api.Team;
import org.screamingsandals.bedwars.api.game.Game;

public abstract class SpecialItem implements org.screamingsandals.bedwars.api.special.SpecialItem {

    protected Game game;
    protected Player player;
    protected Team team;

    public SpecialItem(Game game, Player player, Team team) {
        this.game = game;
        this.player = player;
        this.team = team;
    }

    @Override
    public Game getGame() {
        return game;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public Team getTeam() {
        return team;
    }

}
