package co.hytlabs.rubus.map;

/**
 * Rubus
 * Created by tma02 on 6/8/15.
 * Description: A representation of a room location in a dungeon.
 */

public class RoomLocation {

    private byte floor;
    private byte roomX, roomY;

    public RoomLocation(byte floor, byte roomX, byte roomY) {
        this.floor = floor;
        this.roomX = roomX;
        this.roomY = roomY;
    }

    public RoomLocation(Floor floor, byte roomX, byte roomY) {
        this(floor.getLevel(), roomX, roomY);
    }

    public byte getFloor() {
        return this.floor;
    }

    public byte getX() {
        return this.roomX;
    }

    public byte getY() {
        return this.roomY;
    }

}
