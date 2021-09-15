package com.zpedroo.lexuscolors.managers;

import com.zpedroo.lexuscolors.data.PlayerData;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class DataManager {

    private static DataManager instance;
    public static DataManager getInstance() { return instance; }

    private HashMap<Player, PlayerData> cache;

    public DataManager() {
        instance = this;
        this.cache = new HashMap<>(512);
    }

    public PlayerData getPlayerData(Player player) {
        if (getCache().containsKey(player)) return getCache().get(player);

        PlayerData data = new PlayerData(null);
        getCache().put(player, data);
        return data;
    }

    private HashMap<Player, PlayerData> getCache() {
        return cache;
    }
}