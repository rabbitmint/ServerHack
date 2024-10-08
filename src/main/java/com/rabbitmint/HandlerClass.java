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
        if (!event.getView().getTitle().equals(ChatColor.BLUE + "Utility Hack Menu")) return;

        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        if (clickedItem == null) return;

        if (clickedItem.getType() == Material.SPYGLASS) {
            event.setCancelled(true);
            player.closeInventory();
            Xray xRay = new Xray();
            xRay.openBodyInventory(player);
        }

        if (clickedItem.getType() == Material.SHIELD) {
            event.setCancelled(true);
            player.closeInventory();
            Antik antik = new Antik();
            antik.openBodyInventory(player);
        }

        if (clickedItem.getType() == Material.BOW) {
            event.setCancelled(true);
            player.closeInventory();
            Bow bow = new Bow();
            bow.openBodyInventory(player);
        }

        if (clickedItem.getType() == Material.DIAMOND_SWORDS) {
            event.setCancelled(true);
            player.closeInventory();
            Aura aura = new Aura();
            Aura.openBodyInventory(player);
        }
    }
}
