package co.hytlabs.rubus.entity;

import co.hytlabs.rubus.logic.Character;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Rubus
 * Created by tma02 on 6/13/15.
 * Description: Entity object of the player character.
 */

public class CharacterEntity extends Entity {

    private Character character;

    public CharacterEntity(Character character, TextureRegion textureRegion) {
        super(0, character.getLocation(), textureRegion);
        this.character = character;
    }

    /*@Override
    public void render(SpriteBatch batch, float x, float y) {

    }*/

    @Override
    public void tick(int delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            this.character.getLocation().addY((short) 1);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            this.character.getLocation().addX((short) -1);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            this.character.getLocation().addY((short) -1);
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            this.character.getLocation().addX((short) 1);
        }
        this.setLocation(this.character.getLocation());
    }

}
