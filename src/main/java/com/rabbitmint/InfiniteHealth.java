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

public class InfiniteHealth implements Listener {
    public void openBodyInventory(Player player) {
        Inventory InfiniteHealthInventory = Bukkit.createInventory(null, 9, "Infinite Health Hack Menu");

        ItemStack InfiniteHealth10 = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta meta10 = InfiniteHealth10.getItemMeta();
        meta10.setDisplayName(ChatColor.BLUE +"무적");
        InfiniteHealth10.setItemMeta(meta10);
        InfiniteHealthInventory.setItem(0, InfiniteHealth10);

        ItemStack glassPane = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta metaRemove = glassPane.getItemMeta();
        metaRemove.setDisplayName(ChatColor.RED +"무적 제거");
        glassPane.setItemMeta(metaRemove);
        InfiniteHealthInventory.setItem(7, glassPane);

        ItemStack exit = new ItemStack(Material.BARRIER);
        ItemMeta metaExit = exit.getItemMeta();
        metaExit.setDisplayName(ChatColor.WHITE +"메뉴 나가기");
        exit.setItemMeta(metaExit);
        InfiniteHealthInventory.setItem(8, exit);

        player.openInventory(InfiniteHealthInventory);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals("Infinite Health Hack Menu")) return;

        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        if (clickedItem == null) return;
        event.setCancelled(true);

        if (clickedItem.getType() == Material.RED_STAINED_GLASS_PANE) {
            String playerName = player.getName();
            String clearCommand = "effect clear " + playerName + " minecraft:instant_health";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), clearCommand);
            player.closeInventory();
        } else if (clickedItem.getType() == Material.BLUE_STAINED_GLASS_PANE) {
            String playerName = player.getName();
            String clearCommand = "effect clear " + playerName + " minecraft:instant_health";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), clearCommand);
            String command = "effect give " + playerName + " minecraft:instant_health infinite 99";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
            player.closeInventory();
        } else if (clickedItem.getType() == Material.BARRIER) {
            player.closeInventory();
        }
    }
}
