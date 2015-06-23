package co.hytlabs.rubus.entity;

import co.hytlabs.rubus.graphics.Animation;
import co.hytlabs.rubus.logic.Character;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import java.util.HashMap;

/**
 * Rubus
 * Created by tma02 on 6/13/15.
 * Description: Entity object of the player character.
 */

public class CharacterEntity extends Entity {

    private Character character;
    private DeltaCounter walkNorthCounter;
    private DeltaCounter walkEastCounter;
    private DeltaCounter walkSouthCounter;
    private DeltaCounter walkWestCounter;

    public CharacterEntity(Character character, HashMap<Animation.Type, Animation> animations) {
        super(0, character.getLocation(), animations);
        this.character = character;
        final Character fChar = character;
        this.walkNorthCounter = new DeltaCounter(new Runnable() {
            @Override
            public void run() {
                fChar.getLocation().addY((short) 1);
            }
        }, 20);
        this.walkEastCounter = new DeltaCounter(new Runnable() {
            @Override
            public void run() {
                fChar.getLocation().addX((short) 1);
            }
        }, 20);
        this.walkSouthCounter = new DeltaCounter(new Runnable() {
            @Override
            public void run() {
                fChar.getLocation().addY((short) -1);
            }
        }, 20);
        this.walkWestCounter = new DeltaCounter(new Runnable() {
            @Override
            public void run() {
                fChar.getLocation().addX((short) -1);
            }
        }, 20);
    }

    /*@Override
    public void render(SpriteBatch batch, float x, float y) {

    }*/

    @Override
    public void tick(int delta) {
        super.tick(delta);
        boolean walk = false;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            this.walkNorthCounter.tick(delta);
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
                this.walkNorthCounter.tick(delta);
            }
            walk = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            this.walkWestCounter.tick(delta);
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
                this.walkWestCounter.tick(delta);
            }
            this.direction = Entity.Direction.LEFT;
            walk = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            this.walkSouthCounter.tick(delta);
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
                this.walkSouthCounter.tick(delta);
            }
            walk = true;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            this.walkEastCounter.tick(delta);
            if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
                this.walkEastCounter.tick(delta);
            }
            this.direction = Entity.Direction.RIGHT;
            walk = true;
        }
        if (walk) {
            this.setState(Animation.Type.WALK);
        }
        else {
            this.walkNorthCounter.reset();
            this.walkEastCounter.reset();
            this.walkSouthCounter.reset();
            this.walkWestCounter.reset();
            this.setState(Animation.Type.IDLE);
        }
        this.setLocation(this.character.getLocation());
    }

}
