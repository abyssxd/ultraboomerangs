package me.abisgamer.ultraboomerangs.utils;

import me.abisgamer.ultraboomerangs.UltraBoomerangs;
import org.bukkit.configuration.ConfigurationSection;

import java.util.Set;

public class configUpdater {
    public static void updateConfig() {
        ConfigurationSection config = UltraBoomerangs.plugin.getConfig();

        ConfigurationSection boomerangSection = config.getConfigurationSection("boomerangs");
        if (boomerangSection != null) {
            Set<String> keys = boomerangSection.getKeys(false); // Get only direct children
            for (String key : keys) {
                ConfigurationSection currentSection = boomerangSection.getConfigurationSection(key);
                if (!currentSection.getKeys(false).contains("sounds")) {
                    currentSection.createSection("sounds");
                    currentSection.set("sounds.enabled", true);
                    currentSection.set("sounds.throw-sound", "ENTITY_EXPERIENCE_BOTTLE_THROW");
                    currentSection.set("sounds.recieve-sound", "ENTITY_EXPERIENCE_BOTTLE_THROW");
                    currentSection.set("sounds.volume", 0.4);
                    currentSection.set("sounds.pitch", 0.4);
                }
                if (!currentSection.getKeys(false).contains("armorstand_arm")) {
                    currentSection.createSection("armorstand_arm");
                    currentSection.set("armorstand_arm.x_rotation", 0);
                    currentSection.set("armorstand_arm.y_rotation", 20);
                    currentSection.set("armorstand_arm.z_rotation", 0);
                    UltraBoomerangs.plugin.getLogger().info("Updated config to add armorstand rotation section");
                }
                if (!currentSection.getKeys(false).contains("launch_offset")) {
                    currentSection.createSection("launch_offset");
                    currentSection.set("launch_offset.x", 0);
                    currentSection.set("launch_offset.y", 0);
                    currentSection.set("launch_offset.z", 0);
                    UltraBoomerangs.plugin.getLogger().info("Updated config to add launch offset section");
                }
                if (!currentSection.getKeys(false).contains("rotation_type")) {
                    currentSection.createSection("rotation_type");
                    currentSection.set("rotation_type", "normal");
                    UltraBoomerangs.plugin.getLogger().info("Updated config to add rotation type section");
                }
                if (!currentSection.getKeys(false).contains("mcmmo_skill")) {
                    currentSection.createSection("mcmmo_skill");
                    currentSection.set("mcmmo_skill", "Archery");
                    UltraBoomerangs.plugin.getLogger().info("Updated config to add mcmmo_skill section");
                }
                if (!currentSection.getKeys(false).contains("mcmmo_skill_amount")) {
                    currentSection.createSection("mcmmo_skill_amount");
                    currentSection.set("mcmmo_skill_amount", "0");
                    UltraBoomerangs.plugin.getLogger().info("Updated config to add mcmmo_skill_amount section");
                }
                if (!currentSection.getKeys(false).contains("auraskills_skill")) {
                    currentSection.createSection("auraskills_skill");
                    currentSection.set("auraskills_skill", "Archery");
                    UltraBoomerangs.plugin.getLogger().info("Updated config to add auraskills_skill section");
                }
                if (!currentSection.getKeys(false).contains("auraskills_skill_amount")) {
                    currentSection.createSection("auraskills_skill_amount");
                    currentSection.set("auraskills_skill_amount", "10");
                    UltraBoomerangs.plugin.getLogger().info("Updated config to add auraskills_skill_amount section");
                }
                if (!currentSection.getKeys(false).contains("auto-pickup")) {
                    currentSection.createSection("auto-pickup");
                    currentSection.set("auto-pickup", "false");
                    UltraBoomerangs.plugin.getLogger().info("Updated config to add auto-pickup section");
                }
                if (!currentSection.getKeys(false).contains("click-type")) {
                    currentSection.createSection("click-type");
                    currentSection.set("click-type", "right");
                    UltraBoomerangs.plugin.getLogger().info("Updated config to add click-type section");
                }
                if (!currentSection.getKeys(false).contains("support-durability")) {
                    currentSection.createSection("support-durability");
                    currentSection.set("support-durability", true);
                    UltraBoomerangs.plugin.getLogger().info("Updated config to add support-durability section");
                }
                if (!currentSection.getKeys(false).contains("speed")) {
                    currentSection.createSection("speed");
                    currentSection.set("speed", 1.0);
                    UltraBoomerangs.plugin.getLogger().info("Updated config to add speed section");
                }
            }
        }
        if (!config.getKeys(false).contains("listener")) {
            config.createSection("listener");
            config.set("listener.priority", "NORMAL");
            UltraBoomerangs.plugin.getLogger().info("Updated config to add listener priority section");
        }

        // Add update-old-boomerangs config if it doesn't exist
        if (!config.getKeys(false).contains("update-old-boomerangs")) {
            config.set("update-old-boomerangs", true); // Default to true
            UltraBoomerangs.plugin.getLogger().info("Updated config to add update-old-boomerangs option.");
        }
        UltraBoomerangs.plugin.saveConfig();
    }
}
