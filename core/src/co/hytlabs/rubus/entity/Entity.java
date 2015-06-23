package co.hytlabs.rubus.entity;

import co.hytlabs.rubus.Rubus;
import co.hytlabs.rubus.graphics.Animation;
import co.hytlabs.rubus.map.TileLocation;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;

/**
 * Rubus
 * Created by tma02 on 6/8/15.
 * Description: An entity which is rendered above the tile grid.
 */

public class Entity {

    private int id;
    private TileLocation location;
    protected Entity.Direction direction;
    private TextureRegion textureRegion;
    private HashMap<Animation.Type, Animation> animations;
    protected Animation.Type state;

    public Entity(int id, TileLocation location, HashMap<Animation.Type, Animation> animations) {
        this.id = id;
        this.location = location;
        this.direction = Entity.Direction.RIGHT;
        this.animations = animations;
        this.state = Animation.Type.IDLE;
        this.textureRegion = null;
    }

    public Entity(int id, TileLocation location, TextureRegion textureRegion) {
        this.id = id;
        this.location = location;
        this.direction = Entity.Direction.RIGHT;
        this.textureRegion = textureRegion;
        this.animations = null;
        this.state = null;
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

    public void render(SpriteBatch batch) {
        TextureRegion texture;
        if (this.animations == null) {
            texture = this.textureRegion;
        }
        else {
            texture = this.animations.get(this.state).getCurrentFrame();
        }
        texture.flip(this.direction.ordinal() == 0, false);
        batch.draw(texture, this.location.getRawCoords()[0], this.location.getRawCoords()[1], Rubus.TEXTURE_SCALE * texture.getRegionWidth(), Rubus.TEXTURE_SCALE * texture.getRegionHeight());
        texture.flip(this.direction.ordinal() == 0, false);
    }

    public void setState(Animation.Type state) {
        if (this.state == state) {
            return;
        }
        this.animations.get(this.state).setCurrentFrame(0);
        this.state = state;
    }

    public void tick(int delta) {
        /*for (Animation animation : this.animations.values()) {
            animation.tick(delta);
        }*/
        this.animations.get(this.state).tick(delta);
    }

    public enum Direction {
        LEFT,
        RIGHT
    }

}
