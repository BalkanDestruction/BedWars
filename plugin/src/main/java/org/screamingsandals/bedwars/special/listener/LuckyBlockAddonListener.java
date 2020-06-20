package org.screamingsandals.bedwars.special.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.screamingsandals.bedwars.api.APIUtils;
import org.screamingsandals.bedwars.api.events.BedwarsApplyPropertyToBoughtItem;
import org.screamingsandals.bedwars.api.events.BedwarsPlayerBreakBlock;
import org.screamingsandals.bedwars.api.events.BedwarsPlayerBuildBlock;
import org.screamingsandals.bedwars.api.special.SpecialItem;
import org.screamingsandals.bedwars.special.LuckyBlock;

import java.util.List;
import java.util.Map;

public class LuckyBlockAddonListener implements Listener {

    public static final String LUCKY_BLOCK_PREFIX = "Module:LuckyBlock:";

    @EventHandler
    public void onLuckyBlockRegistered(BedwarsApplyPropertyToBoughtItem event) {
        if (event.getPropertyName().equalsIgnoreCase("luckyblock")) {
            ItemStack stack = event.getStack();

            LuckyBlock lucky = new LuckyBlock(event.getGame(), event.getPlayer(),
                    event.getGame().getTeamOfPlayer(event.getPlayer()),
                    (List<Map<String, Object>>) event.getProperty("data"));

            int id = System.identityHashCode(lucky);

            String luckyBlockString = LUCKY_BLOCK_PREFIX + id;

            APIUtils.hashIntoInvisibleString(stack, luckyBlockString);
        }
    }

    @EventHandler
    public void onLuckyBlockBuild(BedwarsPlayerBuildBlock event) {
        if (event.isCancelled()) {
            return;
        }

        ItemStack luckyItem = event.getItemInHand();
        String invisible = APIUtils.unhashFromInvisibleStringStartsWith(luckyItem, LUCKY_BLOCK_PREFIX);
        if (invisible != null) {
            String[] splitted = invisible.split(":");
            int classID = Integer.parseInt(splitted[2]);

            for (SpecialItem special : event.getGame().getActivedSpecialItems(LuckyBlock.class)) {
                LuckyBlock luckyBlock = (LuckyBlock) special;
                if (System.identityHashCode(luckyBlock) == classID) {
                    luckyBlock.place(event.getBlock().getLocation());
                    return;
                }
            }
        }

    }

    @EventHandler
    public void onLuckyBlockBreak(BedwarsPlayerBreakBlock event) {
        if (event.isCancelled()) {
            return;
        }
        for (SpecialItem special : event.getGame().getActivedSpecialItems(LuckyBlock.class)) {
            LuckyBlock luckyBlock = (LuckyBlock) special;
            if (luckyBlock.isPlaced()) {
                if (event.getBlock().getLocation().equals(luckyBlock.getBlockLocation())) {
                    event.setDrops(false);
                    luckyBlock.process(event.getPlayer());
                    return;
                }
            }
        }
    }

}
