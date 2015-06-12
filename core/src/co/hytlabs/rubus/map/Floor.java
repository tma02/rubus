package co.hytlabs.rubus.map;

/**
 * Rubus
 * Created by tma02 on 6/8/15.
 * Description: A single floor in a dungeon in Rubus.
 */

public class Floor {

    private byte level;
    private Dungeon dungeon;
    private Room[][] rooms;

    public Floor(byte level, Dungeon dungeon)
    {
        this.level = level;
        this.dungeon = dungeon;
        this.rooms = new Room[256][256];
        this.generate();
    }

    public void generate() {
        this.rooms[128][128] = new Room(this, (byte) 0, (byte) 0, (short) 12, (short) 7);
    }

    public byte getLevel() {
        return this.level;
    }

    public Dungeon getDungeon() {
        return this.dungeon;
    }

    public Room getRoom(byte x, byte y) {
        return this.rooms[x + 128][y + 128];
    }

}
