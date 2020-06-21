package org.screamingsandals.bedwars.special;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.screamingsandals.bedwars.Main;
import org.screamingsandals.bedwars.api.Team;
import org.screamingsandals.bedwars.api.game.Game;
import org.screamingsandals.bedwars.utils.MiscUtils;

import static misat11.lib.lang.I18n.i18nonly;

public class ArrowBlocker extends SpecialItem implements org.screamingsandals.bedwars.api.special.ArrowBlocker {
    private final Game game;
    private final Player player;

    private final int protectionTime;
    private final ItemStack item;
    private int usedTime;
    private boolean isActivated;

    public ArrowBlocker(Game game, Player player, Team team, ItemStack item, int protectionTime) {
        super(game, player, team);
        this.game = game;
        this.player = player;
        this.item = item;
        this.protectionTime = protectionTime;
    }

    @Override
    public int getProtectionTime() {
        return protectionTime;
    }

    @Override
    public int getUsedTime() {
        return usedTime;
    }

    @Override
    public boolean isActivated() {
        return isActivated;
    }

    @Override
    public void runTask() {
        new BukkitRunnable() {

            @Override
            public void run() {
                usedTime++;
                if (usedTime == protectionTime) {
                    isActivated = false;
                    MiscUtils.sendActionBarMessage(player, i18nonly("specials_arrow_blocker_ended"));

                    game.unregisterSpecialItem(ArrowBlocker.this);
                    this.cancel();
                }
            }
        }.runTaskTimer(Main.getInstance(), 0L, 20L);
    }

    public void activate() {
        if (protectionTime > 0) {
            game.registerSpecialItem(this);
            runTask();

            if (item.getAmount() > 1) {
                item.setAmount(item.getAmount() - 1);
            } else {
                player.getInventory().remove(item);
            }
            player.updateInventory();

            MiscUtils.sendActionBarMessage(player, i18nonly("specials_arrow_blocker_started").replace("%time%", Integer.toString(protectionTime)));
        }
    }
}
