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

        ItemStack speedHackBoots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta speedMeta = speedHackBoots.getItemMeta();
        if (speedMeta != null) {
            speedMeta.setDisplayName(ChatColor.AQUA + "Speed Hack");
            speedHackBoots.setItemMeta(speedMeta);
        }
        bodyInventory.setItem(0, speedHackBoots);

        ItemStack JumpHackLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta teleportMeta = JumpHackLeggings.getItemMeta();
        if (teleportMeta != null) {
            teleportMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Jump Hack");
            JumpHackLeggings.setItemMeta(teleportMeta);
        }
        bodyInventory.setItem(1, JumpHackLeggings);

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

        if (clickedItem.getType() == Material.DIAMOND_LEGGINGS) {
            event.setCancelled(true);
            player.closeInventory();
            JumpHack jumpHack = new JumpHack();
            jumpHack.openBodyInventory(player);
        }
    }
}
