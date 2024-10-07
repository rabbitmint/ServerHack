package com.rabbitmint;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BodyClass implements Listener {
    public void openBodyInventory(Player player) {
        Inventory bodyInventory = Bukkit.createInventory(null, 9, "Body Hack Menu");

        ItemStack diamondBoots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = diamondBoots.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "Speed Hack");
        diamondBoots.setItemMeta(meta);
        bodyInventory.setItem(0, diamondBoots);
        player.openInventory(bodyInventory);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals("Body Hack Menu")) return;

        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        if (clickedItem == null) return;

        if (clickedItem.getType() == Material.DIAMOND_BOOTS) {
            event.setCancelled(true);
            player.closeInventory();
            SpeedHack speedHack = new SpeedHack();
            speedHack.openBodyInventory(player);
        }
    }
}
