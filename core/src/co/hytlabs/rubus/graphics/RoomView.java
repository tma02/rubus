package co.hytlabs.rubus.graphics;

import co.hytlabs.rubus.map.Room;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Rubus
 * Created by tma02 on 6/8/15.
 * Description: Component that displays the current room.
 */

public class RoomView extends View {

    private Room room;

    public RoomView(int x, int y, int width, int height, Room room) {
        super(x, y, width, height);
        this.room = room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public void render(SpriteBatch batch) {
        this.room.render(batch, this);
    }

}
