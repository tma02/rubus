package co.hytlabs.rubus.graphics;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Rubus
 * Created by tma02 on 6/23/15.
 * Description: Utility class to render animation frames.
 */

public class Animation {

    private ArrayList<TextureRegion> textures;
    private int speed;
    private Animation.Type type;
    private int deltaCounter;
    private int frame;

    public Animation(TextureRegion[] textures, int speed, Animation.Type type) {
        this.textures = new ArrayList<TextureRegion>();
        this.textures.addAll(Arrays.asList(textures));
        this.speed = speed;
        this.type = type;
        this.deltaCounter = 0;
        this.frame = 0;
    }

    public void tick(int delta) {
        this.deltaCounter += delta;
        if (this.deltaCounter > this.speed) {
            this.frame++;
            this.frame %= this.textures.size();
            this.deltaCounter = 0;
        }
    }

    public void setCurrentFrame(int frame) {
        this.frame = frame;
    }

    public TextureRegion getCurrentFrame() {
        return this.textures.get(this.frame);
    }

    public void setFrame(int frame, TextureRegion texture) {
        this.textures.add(frame, texture);
    }

    public enum Type {
        IDLE,
        GESTURE,
        WALK,
        ATTACK,
        DEATH
    }

}
