package com.rabbitmint;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CrouchAndSwapHandListener implements Listener {
    private boolean isSneaking = false;

    @EventHandler
    public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        isSneaking = event.isSneaking();
    }

    @EventHandler
    public void onPlayerSwapHandItems(PlayerSwapHandItemsEvent event) {
        Player player = event.getPlayer();
        if (isSneaking) {
            openMenu(player);
            event.setCancelled(true);
        }
    }

    private void openMenu(Player player) {
        Inventory menuInventory = Bukkit.createInventory(null, 9, "Hack Menu");
        ItemStack item1 = new ItemStack(Material.WOODEN_AXE);
        menuInventory.setItem(0, item1);
        player.openInventory(menuInventory);
    }
}
