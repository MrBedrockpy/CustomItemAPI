package ru.mrbedrockpy.customitemapi.item;

import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import ru.mrbedrockpy.customitemapi.CustomItemAPI;

import java.util.Collections;
import java.util.List;

public abstract class Item {

    public abstract String getId();

    public abstract Material getMaterial();

    public abstract String getName();

    public List<String> getLore() {
        return Collections.emptyList();
    }

    public ItemMeta getItemMeta() {
        return new ItemStack(getMaterial()).getItemMeta();
    }

    public boolean isUnbreakable() {
        return false;
    }

    public void onInteract(PlayerInteractEvent event) {}

    public void onInteractAtEntity(PlayerInteractAtEntityEvent event) {}

    public void onInteractAtBlock(PlayerInteractEvent event) {}
    
    public void onBlockBreak(BlockBreakEvent event) {}

    public final ItemStack build() {
        ItemStack itemStack = new ItemStack(getMaterial());

        itemStack.setItemMeta(getItemMeta());
        itemStack.getItemMeta().setDisplayName(getName());
        itemStack.getItemMeta().setLore(getLore());
        itemStack.getItemMeta().setUnbreakable(isUnbreakable());

        itemStack.getItemMeta().getPersistentDataContainer().set(CustomItemAPI.getNamespacedKey(), PersistentDataType.STRING, getId());

        return itemStack;
    }

}
