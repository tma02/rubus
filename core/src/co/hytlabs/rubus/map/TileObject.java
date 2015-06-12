package co.hytlabs.rubus.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Rubus
 * Created by tma02 on 6/8/15.
 * Description: An object on the tile grid.
 */

public class TileObject {

    private Tile tile;
    private TextureRegion textureRegion;
    private boolean clipping;

    public TileObject(Tile tile, TextureRegion textureRegion, boolean clipping) {
        this.tile = tile;
        this.textureRegion = textureRegion;
        this.clipping = clipping;
    }

    public Tile getTile() {
        return this.tile;
    }

    public boolean isClipping() {
        return this.clipping;
    }

    public void render(SpriteBatch batch) {
        batch.draw(this.textureRegion, 0, 0);
    }

}
