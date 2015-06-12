package co.hytlabs.rubus.map;

import co.hytlabs.rubus.Rubus;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Rubus
 * Created by tma02 on 6/8/15.
 * Description: A tile in a room.
 */

public class Tile {

    private TileLocation location;
    private Type type;
    private int textureRegionIndex;

    public Tile(TileLocation location, Type type) {
        this.location = location;
        this.type = type;
        this.textureRegionIndex = -1;
    }

    public TextureRegion getTextureRegion() {
        Tile.Type[] tiles = this.location.getSurroundingTileTypes(Rubus.instance.getCharacter().getDungeon());
        if (tiles != null) {
            if (Rubus.instance.getFloorTextureMap().containsKey(Arrays.asList(tiles))) {
                TextureRegion[] regions = Rubus.instance.getFloorTextureMap().get(Arrays.asList(tiles));
                if (this.textureRegionIndex == -1) {
                    this.textureRegionIndex = (int) (Math.random() * regions.length);
                }
                return regions[this.textureRegionIndex];
            }
        }
        return Rubus.instance.getDungeonTiles()[0][6];
    }

    public Type getType() {
        return this.type;
    }

    public void render(SpriteBatch batch, float x, float y) {
        batch.draw(this.getTextureRegion(), 0 + (x * Rubus.TEXTURE_SCALE), 0 + (y * Rubus.TEXTURE_SCALE), Rubus.TEXTURE_SCALE * this.getTextureRegion().getRegionWidth(), Rubus.TEXTURE_SCALE * this.getTextureRegion().getRegionHeight());
    }

    public enum Type {
        EMPTY,
        FLOOR
    }

}
