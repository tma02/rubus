package co.hytlabs.rubus.item;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Rubus
 * Created by tma02 on 6/8/15.
 * Description: An in-game item for Rubus.
 */

public class Item {

    private int id;
    private TextureRegion textureRegion;

    public Item(int id, TextureRegion textureRegion) {
        this.id = id;
        this.textureRegion = textureRegion;
    }

    public int getId() {
        return this.id;
    }

    public TextureRegion getTextureRegion() {
        return this.textureRegion;
    }

}
