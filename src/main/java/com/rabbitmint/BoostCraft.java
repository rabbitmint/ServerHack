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

public class BoostCraft implements Listener {
    public void openBodyInventory(Player player) {
        Inventory BoostCraftInventory = Bukkit.createInventory(null, 9, ChatColor.YELLOW + "Boost Craft Hack Menu");

        ItemStack BoostCraft10 = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta meta10 = BoostCraft10.getItemMeta();
        meta10.setDisplayName(ChatColor.BLUE +"가속 켜기");
        BoostCraft10.setItemMeta(meta10);
        BoostCraftInventory.setItem(0, BoostCraft10);

        ItemStack glassPane11 = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta metaRemove = glassPane11.getItemMeta();
        metaRemove.setDisplayName(ChatColor.RED +"가속 제거");
        glassPane11.setItemMeta(metaRemove);
        BoostCraftInventory.setItem(7, glassPane11);

        ItemStack exit = new ItemStack(Material.BARRIER);
        ItemMeta metaExit = exit.getItemMeta();
        metaExit.setDisplayName(ChatColor.WHITE +"메뉴 나가기");
        exit.setItemMeta(metaExit);
        BoostCraftInventory.setItem(8, exit);

        player.openInventory(BoostCraftInventory);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals(ChatColor.YELLOW + "Boost Craft Hack Menu")) return;

        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        if (clickedItem == null) return;
        event.setCancelled(true);

        if (clickedItem.getType() == Material.RED_STAINED_GLASS_PANE) {
            String playerName = player.getName();
            String clearCommand = "effect clear " + playerName + " minecraft:haste";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), clearCommand);
            player.closeInventory();
        } else if (clickedItem.getType() == Material.BLUE_STAINED_GLASS_PANE) {
            String playerName = player.getName();
            String clearCommand = "effect clear " + playerName + " minecraft:haste";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), clearCommand);
            String command = "effect give " + playerName + " minecraft:haste infinite 100";
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
            player.closeInventory();
        } else if (clickedItem.getType() == Material.BARRIER) {
            player.closeInventory();
        }
    }
}
