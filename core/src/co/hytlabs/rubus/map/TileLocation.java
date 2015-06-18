package co.hytlabs.rubus.map;

/**
 * Rubus
 * Created by tma02 on 6/8/15.
 * Description: A representation of a tile location in a dungeon.
 */

public class TileLocation {

    private RoomLocation roomLocation;
    private short tileX, tileY;

    public TileLocation(byte floor, byte roomX, byte roomY, short tileX, short tileY) {
        this.roomLocation = new RoomLocation(floor, roomX, roomY);
        this.tileX = tileX;
        this.tileY = tileY;
    }

    public TileLocation(RoomLocation roomLocation, short tileX, short tileY) {
        this.roomLocation = roomLocation;
        this.tileX = tileX;
        this.tileY = tileY;
    }

    public RoomLocation getRoomLocation() {
        return this.roomLocation;
    }

    public short getX() {
        return this.tileX;
    }

    public short getY() {
        return this.tileY;
    }

    public void addX(short x) {
        this.tileX += x;
    }

    public void addY(short y) {
        this.tileY += y;
    }

    public boolean isAtEdge(Dungeon dungeon) {
        Floor floor = dungeon.getFloors()[this.roomLocation.getFloor()];
        Room room = floor.getRoom(this.roomLocation.getX(), this.roomLocation.getY());
        return this.tileX == 0 || this.tileY == 0 || room.getWidth() == this.tileX || room.getHeight() == this.tileY;
    }

    public Direction getEdge(Dungeon dungeon) {
        Floor floor = dungeon.getFloors()[this.roomLocation.getFloor()];
        Room room = floor.getRoom(this.roomLocation.getX(), this.roomLocation.getY());
        if (this.tileX == 0 && this.tileY == 0) {
            return Direction.NORTHWEST;
        }
        else if (this.tileX == 0 && this.tileY != 0) {
            if (this.tileY == room.getHeight()) {
                return Direction.SOUTHWEST;
            }
            return Direction.WEST;
        }
        else if (this.tileX != 0 && this.tileY == 0) {
            if (this.tileX == room.getWidth()) {
                return Direction.NORTHEAST;
            }
            return Direction.NORTH;
        }
        else if (this.tileX == room.getWidth() && this.tileY == room.getHeight()) {
            return Direction.SOUTHEAST;
        }
        else if (this.tileX == room.getWidth() && this.tileY != room.getHeight()) {
            return Direction.EAST;
        }
        else if (this.tileX != room.getWidth() && this.tileY == room.getHeight()) {
            return Direction.SOUTH;
        }
        return null;
    }

    public Tile[] getSurroundingTiles(Dungeon dungeon) {
        Floor floor = dungeon.getFloors()[this.roomLocation.getFloor()];
        Room room = floor.getRoom(this.roomLocation.getX(), this.roomLocation.getY());
        Tile[] tiles = new Tile[8];
        tiles[Direction.NORTH.ordinal()] = room.getTile(this.tileX, (short) (this.tileY + 1));
        tiles[Direction.EAST.ordinal()] = room.getTile((short) (this.tileX + 1), this.tileY);
        tiles[Direction.SOUTH.ordinal()] = room.getTile(this.tileX, (short) (this.tileY - 1));
        tiles[Direction.WEST.ordinal()] = room.getTile((short) (this.tileX - 1), this.tileY);
        tiles[Direction.NORTHEAST.ordinal()] = room.getTile((short) (this.tileX + 1), (short) (this.tileY + 1));
        tiles[Direction.NORTHWEST.ordinal()] = room.getTile((short) (this.tileX - 1), (short) (this.tileY + 1));
        tiles[Direction.SOUTHEAST.ordinal()] = room.getTile((short) (this.tileX + 1), (short) (this.tileY - 1));
        tiles[Direction.SOUTHWEST.ordinal()] = room.getTile((short) (this.tileX - 1), (short) (this.tileY - 1));
        return tiles;
    }

    public Tile.Type[] getSurroundingTileTypes(Dungeon dungeon) {
        Tile[] tiles = this.getSurroundingTiles(dungeon);
        Tile.Type[] tileTypes = new Tile.Type[8];
        for (int i = 0; i < 8; i++) {
            tileTypes[i] = tiles[i].getType();
        }
        return tileTypes;
    }

}
