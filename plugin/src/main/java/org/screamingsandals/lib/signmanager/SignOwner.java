package org.screamingsandals.lib.signmanager;

import org.bukkit.entity.Player;

import java.util.List;

public interface SignOwner {
    boolean isNameExists(String name);

    void updateSign(SignBlock sign);

    List<String> getSignPrefixes();

    void onClick(Player player, SignBlock sign);

    String getSignCreationPermission();

    String returnTranslate(String key);
}
