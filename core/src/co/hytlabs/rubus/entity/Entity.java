package co.hytlabs.rubus.entity;

import co.hytlabs.rubus.Rubus;
import co.hytlabs.rubus.map.TileLocation;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Rubus
 * Created by tma02 on 6/8/15.
 * Description: An entity which is rendered above the tile grid.
 */

public class Entity {

    private int id;
    private TileLocation location;
    private TextureRegion textureRegion;

    public Entity(int id, TileLocation location, TextureRegion textureRegion) {
        this.id = id;
        this.location = location;
        this.textureRegion = textureRegion;
    }

    public int getId() {
        return this.id;
    }

    public TileLocation getLocation() {
        return this.location;
    }

    public void setLocation(TileLocation tileLocation) {
        this.location = tileLocation;
    }

    public void render(SpriteBatch batch, float x, float y) {
        batch.draw(this.textureRegion, 0 + (x * Rubus.TEXTURE_SCALE), 0 + (y * Rubus.TEXTURE_SCALE), Rubus.TEXTURE_SCALE * this.textureRegion.getRegionWidth(), Rubus.TEXTURE_SCALE * this.textureRegion.getRegionHeight());
    }

    public void tick(int delta) {

    }

}
