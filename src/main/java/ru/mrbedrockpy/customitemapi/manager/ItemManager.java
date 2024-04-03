package ru.mrbedrockpy.customitemapi.manager;

import ru.mrbedrockpy.customitemapi.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemManager<T> {

    public static final ItemManager<? extends Item> manager = new ItemManager<>();

    private final List<T> customItems = new ArrayList<>();

    public void register(List<T> items) {
        customItems.addAll(items);
    }

    public List<T> getCustomItems() {
        return customItems;
    }

}
