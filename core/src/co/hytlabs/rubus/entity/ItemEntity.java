package co.hytlabs.rubus.entity;

import co.hytlabs.rubus.item.Item;
import co.hytlabs.rubus.map.TileLocation;

/**
 * Rubus
 * Created by tma02 on 6/8/15.
 * Description: Entity of an item as it appears in the world.
 */

public class ItemEntity extends Entity {

    private Item item;

    public ItemEntity(int id, TileLocation location, Item item) {
        super(id, location, item.getTextureRegion());
        this.item = item;
    }

    public Item getItem() {
        return this.item;
    }

}
