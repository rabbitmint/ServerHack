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

public class JumpHack implements Listener {
    public void openBodyInventory(Player player) {
        Inventory jumpInventory = Bukkit.createInventory(null, 9, ChatColor.LIGHT_PURPLE + "Jump Hack Menu");

        ItemStack jump10 = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemMeta meta10 = jump10.getItemMeta();
        meta10.setDisplayName(ChatColor.LIGHT_PURPLE +"점프 1단");
        jump10.setItemMeta(meta10);
        jumpInventory.setItem(0, jump10);

        ItemStack jump20 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
        ItemMeta meta20 = jump20.getItemMeta();
        meta20.setDisplayName(ChatColor.BLUE +"점프 2단");
        jump20.setItemMeta(meta20);
        jumpInventory.setItem(1, jump20);

        ItemStack jump30 = new ItemStack(Material.IRON_LEGGINGS);
        ItemMeta meta30 = jump30.getItemMeta();
        meta30.setDisplayName(ChatColor.GREEN +"점프 3단");
        jump30.setItemMeta(meta30);
        jumpInventory.setItem(2, jump30);

        ItemStack jump40 = new ItemStack(Material.GOLDEN_LEGGINGS);
        ItemMeta meta40 = jump40.getItemMeta();
        meta40.setDisplayName(ChatColor.YELLOW +"점프 4단");
        jump40.setItemMeta(meta40);
        jumpInventory.setItem(3, jump40);

        ItemStack jump50 = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta50 = jump50.getItemMeta();
        meta50.setDisplayName(ChatColor.GOLD +"점프 5단");
        jump50.setItemMeta(meta50);
        jumpInventory.setItem(4, jump50);

        ItemStack jump60 = new ItemStack(Material.NETHERITE_LEGGINGS);
        ItemMeta meta60 = jump60.getItemMeta();
        meta60.setDisplayName(ChatColor.RED +"점프 6단");
        jump60.setItemMeta(meta60);
        jumpInventory.setItem(5, jump60);

        ItemStack glassPane1 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta metaRemove = glassPane1.getItemMeta();
        metaRemove.setDisplayName(ChatColor.WHITE +"점프 제거");
        glassPane1.setItemMeta(metaRemove);
        jumpInventory.setItem(7, glassPane1);

        ItemStack exit1 = new ItemStack(Material.BARRIER);
        ItemMeta metaExit = exit1.getItemMeta();
        metaExit.setDisplayName(ChatColor.WHITE +"메뉴 나가기");
        exit1.setItemMeta(metaExit);
        jumpInventory.setItem(8, exit1);

        player.openInventory(jumpInventory);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals(ChatColor.LIGHT_PURPLE + "Jump Hack Menu")) return;

        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        if (clickedItem == null) return;
        event.setCancelled(true);

        if (clickedItem.getType() == Material.RED_STAINED_GLASS_PANE) {
            String playerName = player.getName();
            String clearCommand = "effect clear " + playerName + " minecraft:jump_boost";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), clearCommand);
            player.closeInventory();
        } else if (clickedItem.getType() == Material.LEATHER_LEGGINGS) {
            String playerName = player.getName();
            String clearCommand = "effect clear " + playerName + " minecraft:jump_boost";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), clearCommand);
            String command = "effect give " + playerName + " minecraft:jump_boost infinite 10";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
            player.closeInventory();
        } else if (clickedItem.getType() == Material.CHAINMAIL_LEGGINGS) {
            String playerName = player.getName();
            String clearCommand = "effect clear " + playerName + " minecraft:jump_boost";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), clearCommand);
            String command = "effect give " + playerName + " minecraft:jump_boost infinite 20";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
            player.closeInventory();
        } else if (clickedItem.getType() == Material.IRON_LEGGINGS) {
            String playerName = player.getName();
            String clearCommand = "effect clear " + playerName + " minecraft:jump_boost";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), clearCommand);
            String command = "effect give " + playerName + " minecraft:jump_boost infinite 30";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
            player.closeInventory();
        } else if (clickedItem.getType() == Material.GOLDEN_LEGGINGS) {
            String playerName = player.getName();
            String clearCommand = "effect clear " + playerName + " minecraft:jump_boost";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), clearCommand);
            String command = "effect give " + playerName + " minecraft:jump_boost infinite 40";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
            player.closeInventory();
        } else if (clickedItem.getType() == Material.DIAMOND_LEGGINGS) {
            String playerName = player.getName();
            String clearCommand = "effect clear " + playerName + " minecraft:jump_boost";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), clearCommand);
            String command = "effect give " + playerName + " minecraft:jump_boost infinite 50 ";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
            player.closeInventory();
        } else if (clickedItem.getType() == Material.NETHERITE_LEGGINGS) {
            String playerName = player.getName();
            String clearCommand = "effect clear " + playerName + " minecraft:jump_boost";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), clearCommand);
            String command = "effect give " + playerName + " minecraft:jump_boost infinite 60";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
            player.closeInventory();
        } else if (clickedItem.getType() == Material.BARRIER) {
            player.closeInventory();
        }
    }
}
