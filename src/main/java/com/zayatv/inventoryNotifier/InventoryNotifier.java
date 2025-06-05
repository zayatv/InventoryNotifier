package com.zayatv.inventoryNotifier;

import org.bukkit.plugin.java.JavaPlugin;
import com.zayatv.inventoryNotifier.listeners.InventoryListener;

public final class InventoryNotifier extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new InventoryListener(), this);
    }
}