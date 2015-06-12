package co.hytlabs.rubus.item;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Rubus
 * Created by tma02 on 6/8/15.
 * Description: A consumable item with charge and max charge.
 */

public abstract class ConsumableItem extends Item {

    private short charge, maxCharge;

    public ConsumableItem(int id, TextureRegion textureRegion, short charge, short maxCharge) {
        super(id, textureRegion);
        this.charge = charge;
        this.maxCharge = maxCharge;
    }

    public ConsumableItem(int id, TextureRegion textureRegion, short maxCharge) {
        this(id, textureRegion, maxCharge, maxCharge);
    }

    public short getCharge() {
        return this.charge;
    }

    public short removeCharge(short amount) {
        this.charge -= amount;
        return this.charge;
    }

    public short getMaxCharge() {
        return this.maxCharge;
    }

    public boolean hasCharge() {
        return this.charge > 0 || this.maxCharge == 0;
    }

}
