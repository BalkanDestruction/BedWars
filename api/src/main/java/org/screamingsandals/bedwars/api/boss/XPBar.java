package org.screamingsandals.bedwars.api.boss;

/**
 * @author Bedwars Team
 */
public interface XPBar extends StatusBar {
    /**
     * @return seconds
     */
    int getSeconds();

    /**
     * @param seconds
     */
    void setSeconds(int seconds);

}
