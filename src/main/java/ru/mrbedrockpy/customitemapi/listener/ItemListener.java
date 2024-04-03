package ru.mrbedrockpy.customitemapi.listener;

import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import ru.mrbedrockpy.customitemapi.CustomItemAPI;
import ru.mrbedrockpy.customitemapi.item.Item;
import ru.mrbedrockpy.customitemapi.manager.ItemManager;

public class ItemListener implements Listener {

    public void onInteract(@NotNull PlayerInteractEvent event) {

        if (event.hasItem()) {  return;  }

        if (event.getItem() == null || event.getItem().getItemMeta() == null) {  return;  }

        PersistentDataContainer container = event.getItem().getItemMeta().getPersistentDataContainer();

        String id = container.get(CustomItemAPI.getNamespacedKey(), PersistentDataType.STRING);

        if (id == null) {
            return;
        }

        for (Item item: ItemManager.manager.getCustomItems()) {
            if (id.equals(item.getId())) item.onInteract(event);
            if (event.getClickedBlock() != null) item.onInteractAtBlock(event);
        }

    }

    public void onInteractAtEntity(PlayerInteractAtEntityEvent event) {

        ItemStack cursorItem = event.getPlayer().getItemOnCursor();

        if (cursorItem.getItemMeta() == null) {  return;  }

        PersistentDataContainer container = cursorItem.getItemMeta().getPersistentDataContainer();

        String id = container.get(CustomItemAPI.getNamespacedKey(), PersistentDataType.STRING);

        if (id == null) {
            return;
        }

        for (Item item: ItemManager.manager.getCustomItems()) {
            if (id.equals(item.getId())) item.onInteractAtEntity(event);
        }

    }

    public void onBlockBreak(BlockBreakEvent event) {

        ItemStack cursorItem = event.getPlayer().getItemOnCursor();

        if (cursorItem.getItemMeta() == null) {  return;  }

        PersistentDataContainer container = cursorItem.getItemMeta().getPersistentDataContainer();

        String id = container.get(CustomItemAPI.getNamespacedKey(), PersistentDataType.STRING);

        if (id == null) {
            return;
        }

        for (Item item: ItemManager.manager.getCustomItems()) {
            if (id.equals(item.getId())) item.onBlockBreak(event);
        }

    }

}
