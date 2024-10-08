package me.abisgamer.ultraboomerangs.commands;

import me.abisgamer.ultraboomerangs.UltraBoomerangs;
import me.abisgamer.ultraboomerangs.utils.itemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class reloadCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        FileConfiguration messages = UltraBoomerangs.plugin.messages;

        if (cmd.getName().equalsIgnoreCase("ultraboomerangs")) {

            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("ultraboomerangs.reload")) {
                    UltraBoomerangs.plugin.reloadConfig();
                    UltraBoomerangs.plugin.reloadCustomConfig();
                    itemBuilder.createBoomerangs();  // Reinitialize itemBuilder to update boomerangs map
                    UltraBoomerangs.plugin.registerAllUpdateListeners(); // Re-register listeners after reload
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.getString("prefix") + messages.getString("reload")));
                }
            } else {
                UltraBoomerangs.plugin.reloadConfig();
                UltraBoomerangs.plugin.reloadCustomConfig();
                itemBuilder.createBoomerangs();  // Reinitialize itemBuilder to update boomerangs map
                UltraBoomerangs.plugin.registerAllUpdateListeners(); // Re-register listeners after reload


                UltraBoomerangs.plugin.getLogger().info("Plugin reloaded successfully");
            }
            return true;
        }
        return false;
    }
}
