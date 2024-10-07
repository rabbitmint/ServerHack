package com.rabbitmint;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.ChatColor;

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
        Inventory menuInventory = Bukkit.createInventory(null, 9, ChatColor.DARK_RED + "Hack Menu");

        ItemStack body = new ItemStack(Material.ARMOR_STAND);
        ItemMeta itemMeta2 = body.getItemMeta();
        if (itemMeta2 != null) {
            itemMeta2.setDisplayName(ChatColor.GRAY + "Body Hack");
            body.setItemMeta(itemMeta2);
        }
        menuInventory.setItem(0, body);

        player.openInventory(menuInventory);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals(ChatColor.DARK_RED + "Hack Menu")) return;

        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        if (clickedItem == null) return;

        if (clickedItem.getType() == Material.ARMOR_STAND) {
            event.setCancelled(true);
            player.closeInventory();
            BodyClass bodyClass = new BodyClass();
            bodyClass.openBodyInventory(player);
        }
    }
}
