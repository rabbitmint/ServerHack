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

public class HandlerClass implements Listener {
    public void openBodyInventory(Player player) {
        Inventory bodyInventory = Bukkit.createInventory(null, 9, ChatColor.BLUE + "Utility Hack Menu");

        ItemStack speedHackBoots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta speedMeta = speedHackBoots.getItemMeta();
        if (speedMeta != null) {
            speedMeta.setDisplayName(ChatColor.AQUA + "X-Ray Hack");
            speedHackBoots.setItemMeta(speedMeta);
        }
        bodyInventory.setItem(0, speedHackBoots);

        ItemStack JumpHackLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta teleportMeta = JumpHackLeggings.getItemMeta();
        if (teleportMeta != null) {
            teleportMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Anti Knockback");
            JumpHackLeggings.setItemMeta(teleportMeta);
        }
        bodyInventory.setItem(1, JumpHackLeggings);
    
        ItemStack InfiniteHealth = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta HealthMeta = InfiniteHealth.getItemMeta();
        if (HealthMeta != null) {
            HealthMeta.setDisplayName(ChatColor.RED + "Auto Bow Hack");
            InfiniteHealth.setItemMeta(HealthMeta);
        }
        bodyInventory.setItem(2, InfiniteHealth);

        ItemStack BoostCraft = new ItemStack(Material.DIAMOND_SWORDS);
        ItemMeta BoostCraftMeta = BoostCraft.getItemMeta();
        if (BoostCraftMeta != null) {
            BoostCraftMeta.setDisplayName(ChatColor.YELLOW + "Kill Aura Hack");
            BoostCraft.setItemMeta(BoostCraftMeta);
        }
        bodyInventory.setItem(3, BoostCraft);

        player.openInventory(bodyInventory);
    }


    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals(ChatColor.BLUE + "Body Hack Menu")) return;

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

        if (clickedItem.getType() == Material.DIAMOND_CHESTPLATE) {
            event.setCancelled(true);
            player.closeInventory();
            InfiniteHealth infiniteHealth = new InfiniteHealth();
            infiniteHealth.openBodyInventory(player);
        }

        if (clickedItem.getType() == Material.DIAMOND_PICKAXE) {
            event.setCancelled(true);
            player.closeInventory();
            BoostCraft BoostCraft = new BoostCraft();
            BoostCraft.openBodyInventory(player);
        }
    }
}
