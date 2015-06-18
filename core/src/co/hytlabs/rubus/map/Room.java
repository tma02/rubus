package co.hytlabs.rubus.map;

import co.hytlabs.rubus.entity.Entity;
import co.hytlabs.rubus.graphics.RoomView;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Rubus
 * Created by tma02 on 6/8/15.
 * Description: A room on a floor in Rubus.
 */

public class Room {

    private byte roomX, roomY;
    private short width, height;
    private RoomLocation location;
    private ArrayList<Entity> entities;
    private Tile[][] tiles;

    public Room(Floor floor, byte roomX, byte roomY, short width, short height) {
        this.roomX = roomX;
        this.roomY = roomY;
        this.width = width;
        this.height = height;
        this.location = new RoomLocation(floor.getLevel(), roomX, roomY);
        this.entities = new ArrayList<Entity>();
        this.tiles = new Tile[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                this.tiles[x][y] = new Tile(new TileLocation(this.location, (short) x, (short) y), Tile.Type.FLOOR);
            }
        }
    }

    public short getWidth() {
        return this.width;
    }

    public short getHeight() {
        return this.height;
    }

    public Tile getTile(short x, short y) {
        //If it's out of this room, it's empty
        if (x < 0 || x >= this.width || y < 0 || y >= this.height) {
            return new Tile(new TileLocation(this.location, x, y), Tile.Type.EMPTY);
        }
        return this.tiles[x][y];
    }

    public Tile getTile(TileLocation location) {
        return this.getTile(location.getX(), location.getY());
    }

    public int spawnEntity(Entity entity) {
        this.entities.add(entity);
        return this.entities.size() - 1;
    }

    public void removeEntity(Entity entity) {
        this.entities.remove(entity);
    }

    public void render(SpriteBatch batch, RoomView roomView) {
        for (int x = 0; x < this.tiles.length; x++) {
            for (int y = 0; y < this.tiles[x].length; y++) {
                this.tiles[x][y].render(batch, roomView.getX() + (x * 16), roomView.getY() + (y * 16));
            }
        }
        //render walls
    }

    public void renderEntities(SpriteBatch batch, RoomView roomView) {
        for (Entity entity : this.entities) {
            float x = entity.getLocation().getX();
            float y = entity.getLocation().getY();
            entity.tick(0);
            entity.render(batch, roomView.getX() + (x * 16), roomView.getY() + (y * 16));
        }
    }

}
