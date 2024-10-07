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

public class SpeedHack implements Listener {
    public void openBodyInventory(Player player) {
        Inventory speedInventory = Bukkit.createInventory(null, 9, "Speed Hack Menu");

        ItemStack speed10 = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta meta10 = speed10.getItemMeta();
        meta10.setDisplayName(ChatColor.LIGHT_PURPLE +"속도 1단");
        speed10.setItemMeta(meta10);
        speedInventory.setItem(0, speed10);

        ItemStack speed20 = new ItemStack(Material.CHAINMAIL_BOOTS);
        ItemMeta meta20 = speed20.getItemMeta();
        meta20.setDisplayName(ChatColor.BLUE +"속도 2단");
        speed20.setItemMeta(meta20);
        speedInventory.setItem(1, speed20);

        ItemStack speed30 = new ItemStack(Material.IRON_BOOTS);
        ItemMeta meta30 = speed30.getItemMeta();
        meta30.setDisplayName(ChatColor.GREEN +"속도 3단");
        speed30.setItemMeta(meta30);
        speedInventory.setItem(2, speed30);

        ItemStack speed40 = new ItemStack(Material.GOLDEN_BOOTS);
        ItemMeta meta40 = speed40.getItemMeta();
        meta40.setDisplayName(ChatColor.YELLOW +"속도 4단");
        speed40.setItemMeta(meta40);
        speedInventory.setItem(3, speed40);

        ItemStack speed50 = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta50 = speed50.getItemMeta();
        meta50.setDisplayName(ChatColor.GOLD +"속도 5단");
        speed50.setItemMeta(meta50);
        speedInventory.setItem(4, speed50);

        ItemStack speed60 = new ItemStack(Material.NETHERITE_BOOTS);
        ItemMeta meta60 = speed60.getItemMeta();
        meta60.setDisplayName(ChatColor.RED +"속도 6단");
        speed60.setItemMeta(meta60);
        speedInventory.setItem(5, speed60);

        ItemStack glassPane = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta metaRemove = glassPane.getItemMeta();
        metaRemove.setDisplayName(ChatColor.WHITE +"속도 제거");
        glassPane.setItemMeta(metaRemove);
        speedInventory.setItem(7, glassPane);

        ItemStack exit = new ItemStack(Material.BARRIER);
        ItemMeta metaExit = exit.getItemMeta();
        metaExit.setDisplayName(ChatColor.WHITE +"메뉴 나가기");
        exit.setItemMeta(metaExit);
        speedInventory.setItem(8, exit);

        player.openInventory(speedInventory);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals("Speed Hack Menu")) return;

        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        if (clickedItem == null) return;
        event.setCancelled(true);

        if (clickedItem.getType() == Material.RED_STAINED_GLASS_PANE) {
            String playerName = player.getName();
            String clearCommand = "effect clear " + playerName + " minecraft:speed";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), clearCommand);
            player.closeInventory();
        } else if (clickedItem.getType() == Material.LEATHER_BOOTS) {
            String playerName = player.getName();
            String clearCommand = "effect clear " + playerName + " minecraft:speed";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), clearCommand);
            String command = "effect give " + playerName + " minecraft:speed infinite 10";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
            player.closeInventory();
        } else if (clickedItem.getType() == Material.CHAINMAIL_BOOTS) {
            String playerName = player.getName();
            String clearCommand = "effect clear " + playerName + " minecraft:speed";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), clearCommand);
            String command = "effect give " + playerName + " minecraft:speed infinite 20";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
            player.closeInventory();
        } else if (clickedItem.getType() == Material.IRON_BOOTS) {
            String playerName = player.getName();
            String clearCommand = "effect clear " + playerName + " minecraft:speed";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), clearCommand);
            String command = "effect give " + playerName + " minecraft:speed infinite 30";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
            player.closeInventory();
        } else if (clickedItem.getType() == Material.GOLDEN_BOOTS) {
            String playerName = player.getName();
            String clearCommand = "effect clear " + playerName + " minecraft:speed";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), clearCommand);
            String command = "effect give " + playerName + " minecraft:speed infinite 40";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
            player.closeInventory();
        } else if (clickedItem.getType() == Material.DIAMOND_BOOTS) {
            String playerName = player.getName();
            String clearCommand = "effect clear " + playerName + " minecraft:speed";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), clearCommand);
            String command = "effect give " + playerName + " minecraft:speed infinite 50 ";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
            player.closeInventory();
        } else if (clickedItem.getType() == Material.NETHERITE_BOOTS) {
            String playerName = player.getName();
            String clearCommand = "effect clear " + playerName + " minecraft:speed";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), clearCommand);
            String command = "effect give " + playerName + " minecraft:speed infinite 60";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
            player.closeInventory();
        } else if (clickedItem.getType() == Material.BARRIER) {
            player.closeInventory();
        }
    }
}
