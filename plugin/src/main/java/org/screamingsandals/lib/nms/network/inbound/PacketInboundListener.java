package org.screamingsandals.lib.nms.network.inbound;

import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import org.bukkit.entity.Player;

import java.util.Objects;

import static org.screamingsandals.lib.nms.utils.ClassStorage.getField;
import static org.screamingsandals.lib.nms.utils.ClassStorage.getPlayerConnection;

public abstract class PacketInboundListener {

    private static int ID = 0;

    private final String channelName = PacketInboundListener.class.getCanonicalName() + "-" + ID++;

    public void addPlayer(Player player) {
        try {
            Channel ch = getChannel(player);
            if (Objects.requireNonNull(ch).pipeline().get(channelName) == null) {
                ChannelDuplexHandler handler = new ChannelDuplexHandler() {
                    @Override
                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                        try {
                            msg = handle(player, msg);
                        } catch (Throwable ignored) {
                        }
                        if (msg != null) {
                            super.channelRead(ctx, msg);
                        }
                    }
                };
                ch.pipeline().addBefore("packet_handler", channelName, handler);
            }
        } catch (Throwable ignored) {
        }
    }

    public void removePlayer(Player player) {
        try {
            Channel ch = getChannel(player);
            if (Objects.requireNonNull(ch).pipeline().get(channelName) != null) {
                ch.pipeline().remove(channelName);
            }
        } catch (Throwable ignored) {
        }
    }

    private Channel getChannel(Player player) {
        try {
            Object manager = getField(getPlayerConnection(player), "networkManager,field_147371_a");
            return (Channel) getField(manager, "channel,field_150746_k,k,m");
        } catch (Throwable ignored) {
        }
        return null;
    }

    protected abstract Object handle(Player p, Object packet) throws Throwable;
}
