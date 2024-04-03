package ru.mrbedrockpy.customitemapi;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
import ru.mrbedrockpy.customitemapi.listener.ItemListener;

public final class CustomItemAPI extends JavaPlugin {

    private static CustomItemAPI instance;

    private static NamespacedKey KEY;

    @Override
    public void onEnable() {

        instance = this;

        KEY = new NamespacedKey(this, this.getName());

        getServer().getPluginManager().registerEvents(new ItemListener(), this);

    }

    @Override
    public void onDisable() {

    }

    public static CustomItemAPI getInstance() {
        return instance;
    }

    public static NamespacedKey getNamespacedKey() {
        return KEY;
    }

}
