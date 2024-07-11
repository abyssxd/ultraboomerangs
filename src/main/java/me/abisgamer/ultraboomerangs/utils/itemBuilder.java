package me.abisgamer.ultraboomerangs.utils;

import me.abisgamer.ultraboomerangs.UltraBoomerangs;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.*;

public class itemBuilder {
    public static HashMap<String, ItemStack> boomerangs = new HashMap<>();
    public static HashMap<String, Integer> boomerDamage = new HashMap<>();
    public static HashMap<String, Integer> travelDistance = new HashMap<>();
    public static HashMap<String, Long> cooldownTime = new HashMap<>();
    public static HashMap<String, String> clickType = new HashMap<>();
    public static HashMap<String, Boolean> supportDurability = new HashMap<>();
    public static HashMap<String, String> mcmmoSkills = new HashMap<>();
    public static HashMap<String, Integer> mcmmoSkillAmounts = new HashMap<>();
    public static HashMap<String, Integer> boomerang_armorstand_x = new HashMap<>();
    public static HashMap<String, Integer> boomerang_armorstand_y = new HashMap<>();
    public static HashMap<String, Integer> boomerang_armorstand_z = new HashMap<>();
    public static HashMap<String, String> rotationType = new HashMap<>();


    public static void createBoomerangs() {
        ConfigurationSection config = UltraBoomerangs.plugin.getConfig();
        UltraBoomerangs.plugin.reloadConfig();
        ConfigurationSection boomerangSection = config.getConfigurationSection("boomerangs");

        if (boomerangSection != null) {
            Set<String> keys = boomerangSection.getKeys(false);
            for (String key : keys) {
                String material = config.getString("boomerangs." + key + ".material");
                String name = config.getString("boomerangs." + key + ".name");
                String BoomClickType = config.getString("boomerangs." + key + ".click-type");
                List<String> lore = config.getStringList("boomerangs." + key + ".lore");
                int damage = config.getInt("boomerangs." + key + ".damage");
                int distance = config.getInt("boomerangs." + key + ".travel-distance");
                int customModel = config.getInt("boomerangs." + key + ".custom-model");
                Long coolDown = config.getLong("boomerangs." + key + ".cooldown");
                boolean enchanted = config.getBoolean("boomerangs." + key + ".enchanted");
                boolean isItemstack = config.getBoolean("boomerangs." + key + ".is-itemstack");
                ItemStack boomerItemStack = config.getItemStack("boomerangs." + key + ".itemstack");
                boolean supportDurabilityOption = config.getBoolean("boomerangs." + key + ".support-durability", false);
                String mcmmoSkill = config.getString("boomerangs." + key + ".mcmmo_skill", "none");
                int mcmmoSkillAmount = config.getInt("boomerangs." + key + ".mcmmo_skill_amount", 0);
                int boomerang_armorstand_x_value = config.getInt("boomerangs." + key + ".armorstand_arm.x_rotation", 0);
                int boomerang_armorstand_y_value = config.getInt("boomerangs." + key + ".armorstand_arm.y_rotation", 0);
                int boomerang_armorstand_z_value = config.getInt("boomerangs." + key + ".armorstand_arm.z_rotation", 0);
                String rotationTypeValue = config.getString("boomerangs." + key + ".rotation_type", "curved");


                ItemStack boomerang;
                if (!isItemstack) {
                    boomerang = new ItemStack(Material.getMaterial(material.toUpperCase()));
                    ItemMeta meta = boomerang.getItemMeta();
                    meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
                    List<String> coloredLore = new ArrayList<>();
                    for (String s : lore) {
                        coloredLore.add(ChatColor.translateAlternateColorCodes('&', s));
                    }
                    meta.setLore(coloredLore);
                    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    meta.setCustomModelData(customModel);
                    if (enchanted) {
                        meta.addEnchant(Enchantment.DURABILITY, 1, true);
                    }
                    boomerang.setItemMeta(meta);
                } else {
                    boomerang = boomerItemStack;
                }

                ItemMeta meta = boomerang.getItemMeta();
                meta.getPersistentDataContainer().set(new NamespacedKey(UltraBoomerangs.plugin, "boomerang_id"), PersistentDataType.STRING, key);
                boomerang.setItemMeta(meta);

                boomerangs.put(key, boomerang);
                boomerDamage.put(key, damage);
                travelDistance.put(key, distance);
                clickType.put(key, BoomClickType);
                cooldownTime.put(key, coolDown);
                supportDurability.put(key, supportDurabilityOption);
                mcmmoSkills.put(key, mcmmoSkill);
                mcmmoSkillAmounts.put(key, mcmmoSkillAmount);
                boomerang_armorstand_x.put(key, boomerang_armorstand_x_value);
                boomerang_armorstand_y.put(key, boomerang_armorstand_y_value);
                boomerang_armorstand_z.put(key, boomerang_armorstand_z_value);
                rotationType.put(key, rotationTypeValue);


                UltraBoomerangs.plugin.getLogger().info("Loaded Boomerang: " + key);
            }
        }
    }
}
