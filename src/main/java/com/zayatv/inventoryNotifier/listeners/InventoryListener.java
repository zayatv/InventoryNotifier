package com.zayatv.inventoryNotifier.listeners;

import com.zayatv.inventoryNotifier.events.PlayerInventoryOpenEvent;
import com.zayatv.inventoryNotifier.events.PlayerInventoryCloseEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

public class InventoryListener implements Listener {
    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        if (event.getPlayer() instanceof Player) {
            Player player = (Player) event.getPlayer();
            Inventory inventory = event.getInventory();
            PlayerInventoryOpenEvent.invoke(player, inventory);
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if (event.getPlayer() instanceof Player) {
            Player player = (Player) event.getPlayer();
            Inventory inventory = event.getInventory();
            PlayerInventoryCloseEvent.invoke(player, inventory);
        }
    }
}
