package com.zayatv.inventoryNotifier.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Inventory;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiConsumer;

public class PlayerInventoryOpenEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final Player player;
    private final Inventory inventory;
    private static final List<BiConsumer<Player, Inventory>> callbacks = new CopyOnWriteArrayList<>();

    public PlayerInventoryOpenEvent(Player player, Inventory inventory) {
        this.player = player;
        this.inventory = inventory;
    }

    public Player getPlayer() {
        return player;
    }

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public static void subscribe(BiConsumer<Player, Inventory> callback) {
        callbacks.add(callback);
    }

    public static void unsubscribe(BiConsumer<Player, Inventory> callback) {
        callbacks.remove(callback);
    }

    public static void invoke(Player player, Inventory inventory) {
        for (BiConsumer<Player, Inventory> callback : callbacks) {
            callback.accept(player, inventory);
        }
    }
}
