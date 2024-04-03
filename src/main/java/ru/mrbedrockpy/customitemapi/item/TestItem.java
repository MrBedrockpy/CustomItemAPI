package ru.mrbedrockpy.customitemapi.item;

import org.bukkit.Material;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Arrays;
import java.util.List;

public class TestItem extends Item {

    @Override
    public String getId() {
        return "hub";
    }

    @Override
    public Material getMaterial() {
        return Material.COMPASS;
    }

    @Override
    public String getName() {
        return "Return to Hub";
    }

    @Override
    public List<String> getLore() {
        return Arrays.asList("Hello", "World!");
    }

    @Override
    public void onBlockBreak(BlockBreakEvent event) {
        event.setCancelled(true);
    }

    @Override
    public void onInteract(PlayerInteractEvent event) {

    }
}
