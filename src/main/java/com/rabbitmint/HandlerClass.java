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

        ItemStack xrayitem = new ItemStack(Material.SPYGLASS);
        ItemMeta xrayMeta = xrayitem.getItemMeta();
        if (xrayMeta != null) {
            xrayMeta.setDisplayName(ChatColor.AQUA + "X-Ray Hack");
            xrayitem.setItemMeta(xrayMeta);
        }
        bodyInventory.setItem(0, xrayitem);

        ItemStack antikitem = new ItemStack(Material.SHIELD);
        ItemMeta antikMeta = antikitem.getItemMeta();
        if (antikMeta != null) {
            antikMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Anti Knockback");
            antikitem.setItemMeta(antikMeta);
        }
        bodyInventory.setItem(1, antikitem);
    
        ItemStack bowitem = new ItemStack(Material.BOW);
        ItemMeta bowMeta = bowitem.getItemMeta();
        if (bowMeta != null) {
            bowMeta.setDisplayName(ChatColor.RED + "Auto Bow Hack");
            bowitem.setItemMeta(bowMeta);
        }
        bodyInventory.setItem(2, bowitem);

        ItemStack auraitem = new ItemStack(Material.DIAMOND_SWORDS);
        ItemMeta auraMeta = auraitem.getItemMeta();
        if (auraMeta != null) {
            auraMeta.setDisplayName(ChatColor.YELLOW + "Kill Aura Hack");
            auraitem.setItemMeta(auraMeta);
        }
        bodyInventory.setItem(3, auraitem);

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
