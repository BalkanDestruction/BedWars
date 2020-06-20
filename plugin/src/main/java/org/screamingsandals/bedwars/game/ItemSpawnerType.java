package org.screamingsandals.bedwars.game;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static misat11.lib.lang.I18n.i18n;

public class ItemSpawnerType implements org.screamingsandals.bedwars.api.game.ItemSpawnerType {
    private final String configKey;
    private final String name;
    private final String translatableKey;
    private final double spread;
    private final Material material;
    private final ChatColor color;
    private final int interval;
    private final int damage;

    public ItemSpawnerType(String configKey, String name, String translatableKey, double spread, Material material,
                           ChatColor color, int interval, int damage) {
        this.configKey = configKey;
        this.name = name;
        this.translatableKey = translatableKey;
        this.spread = spread;
        this.material = material;
        this.color = color;
        this.interval = interval;
        this.damage = damage;
    }

    public String getConfigKey() {
        return configKey;
    }

    public ChatColor getColor() {
        return color;
    }

    public int getInterval() {
        return interval;
    }

    public double getSpread() {
        return spread;
    }

    public String getName() {
        return name;
    }

    public Material getMaterial() {
        return material;
    }

    public String getTranslatableKey() {
        if (translatableKey != null && !translatableKey.equals("")) {
            return i18n(translatableKey, name, false);
        }
        return name;
    }

    public String getItemName() {
        return color + getTranslatableKey();
    }

    public String getItemBoldName() {
        return color.toString() + ChatColor.BOLD.toString() + getTranslatableKey();
    }

    public int getDamage() {
        return damage;
    }

    public ItemStack getStack() {
        return getStack(1);
    }

    public ItemStack getStack(int amount) {
        ItemStack stack = new ItemStack(material, amount, (short) damage);
        ItemMeta stackMeta = stack.getItemMeta();
        stackMeta.setDisplayName(getItemName());
        stack.setItemMeta(stackMeta);
        return stack;
    }
}
