package co.hytlabs.rubus.item;

import java.util.HashMap;

/**
 * Rubus
 * Created by tma02 on 6/8/15.
 * Description: Generates item objects for game use.
 */

public class ItemFactory {

    private HashMap<Integer, Item> items;

    public ItemFactory() {
        this.items = new HashMap<Integer, Item>();
    }

    public Item getItem(int id) {
        return this.items.get(id);
    }

    public void registerItem(int id, Item item) {
        this.items.put(id, item);
    }

}
