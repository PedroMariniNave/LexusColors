package com.zpedroo.lexuscolors.commands;

import com.zpedroo.lexuscolors.Colors;
import com.zpedroo.lexuscolors.LexusColors;
import com.zpedroo.lexuscolors.managers.DataManager;
import com.zpedroo.lexuscolors.objects.Color;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ColorCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;
        if (args.length == 0) {
            DataManager.getInstance().getPlayerData(player).setColor(null);
            player.sendMessage(getColored(LexusColors.get().getConfig().getString("Messages.sucessful-removed")));
            return true;
        }

        Color color = Colors.getColor(args[0]);
        if (color == null) {
            player.sendMessage(getColored(LexusColors.get().getConfig().getString("Messages.invalid-color")));
            return true;
        }

        DataManager.getInstance().getPlayerData(player).setColor(color);
        player.sendMessage(getColored(LexusColors.get().getConfig().getString("Messages.sucessful-changed")).replace("{color}", "&" + color.getName()));
        return false;
    }

    private String getColored(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}