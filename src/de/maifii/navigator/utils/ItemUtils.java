package de.maifii.navigator.utils;


// Code by Maifii 
// Zeit: 18:53 | 07 , 16
// Discord : MaifiiDE#3511

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtils {
    public static void setItemInInventory(Inventory inventory, Material material, String displayName, Integer slot) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(displayName);
        item.setItemMeta(itemMeta);
        inventory.setItem((int) slot, item);
    }
}