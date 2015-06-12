package co.hytlabs.rubus.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Rubus
 * Created by tma02 on 6/8/15.
 * Description: A dungeon in Rubus.
 */

public class Dungeon {

    private Floor[] floors;

    public Dungeon(Difficulty difficulty, byte floors) {
        this.floors = new Floor[floors];
        for (byte i = 0; i < floors; i++) {
            this.floors[i] = new Floor(i, this);
        }
    }

    public Floor[] getFloors() {
        return this.floors;
    }

    public void render(SpriteBatch batch) {

    }

    public enum Difficulty {
        NORMAL,
        HARD,
        NIGHTMARE
    }

}
