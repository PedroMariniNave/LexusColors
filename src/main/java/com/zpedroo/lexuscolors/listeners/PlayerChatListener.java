package com.zpedroo.lexuscolors.listeners;

import com.zpedroo.lexuscolors.data.PlayerData;
import com.zpedroo.lexuscolors.managers.DataManager;
import com.zpedroo.lexuscolors.objects.Color;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onChat(AsyncPlayerChatEvent event) {
        PlayerData data = DataManager.getInstance().getPlayerData(event.getPlayer());
        Color color = data.getColor();

        if (color == null) return;

        event.setMessage(color.getColor() + event.getMessage());
    }
}