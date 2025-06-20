# InventoryNotifier

InventoryNotifier is a lightweight, reusable Minecraft (Paper/Spigot) plugin library that allows you to easily subscribe to player inventory open and close events. It is designed to be integrated into other plugins, making it easy to react to inventory events without boilerplate code.

## Features
- Subscribe to inventory open/close events with simple Java lambdas
- No need to manually fire or handle Bukkit events—just subscribe and react
- Works for all inventories that Bukkit/Paper supports (see limitations)
- Easy integration into existing plugins

## Usage

### 1. Add as a Dependency
- Build this plugin and place the JAR in your server's `plugins` folder.
- Or, add it as a dependency in your plugin's build system (Maven/Gradle).
- Add to your `plugin.yml`:
  ```yaml
  depend: [InventoryNotifier]
  ```

### 2. Subscribe to Events
In your plugin's `onEnable` or initialization code:

```java
import com.zayatv.inventoryNotifier.events.PlayerInventoryOpenEvent;
import com.zayatv.inventoryNotifier.events.PlayerInventoryCloseEvent;

@Override
public void onEnable() {
    PlayerInventoryOpenEvent.subscribe((player, inventory) -> {
        player.sendMessage("You opened an inventory!");
    });
    PlayerInventoryCloseEvent.subscribe((player, inventory) -> {
        player.sendMessage("You closed an inventory!");
    });
}
```

## Limitations
- **Player Inventory:** Bukkit/Paper does not fire an event when a player opens their own inventory (by pressing 'E'). This is a limitation of the Minecraft server API.
- **Supported Events:** All other inventory types (chests, furnaces, etc.) are supported out of the box.

## Extending
- You can add more event types or custom logic by editing the `InventoryListener` or event classes.
- PRs and suggestions are welcome!

## License
MIT License

## Credits
Created by ZayaTV
