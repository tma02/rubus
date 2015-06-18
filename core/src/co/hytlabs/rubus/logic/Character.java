package co.hytlabs.rubus.logic;

import co.hytlabs.rubus.map.Dungeon;
import co.hytlabs.rubus.map.Room;
import co.hytlabs.rubus.map.TileLocation;

import java.util.HashMap;

/**
 * Rubus
 * Created by tma02 on 6/8/15.
 * Description: A character save in Rubus.
 */

public class Character {

    private String name;
    private Profession profession;
    private Affinity affinity;
    private Dungeon dungeon;
    private TileLocation location;
    private HashMap<Attribute, Short> attributes;

    public Character(Profession profession, Affinity affinity) {
        this.profession = profession;
        this.affinity = affinity;
        this.attributes = new HashMap<Attribute, Short>();
    }

    public Profession getProfession() {
        return this.profession;
    }

    public Affinity getAffinity() {
        return this.affinity;
    }

    public void setDungeon(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    public Dungeon getDungeon() {
        return this.dungeon;
    }

    public short getAttribute(Attribute attribute) {
        return this.attributes.get(attribute);
    }

    public TileLocation getLocation() {
        return this.location;
    }

    public void setLocation(TileLocation tileLocation) {
        this.location = tileLocation;
    }

    public Room getRoom() {
        return this.dungeon.getFloors()[this.location.getRoomLocation().getFloor()].getRoom(this.location.getRoomLocation().getX(), this.location.getRoomLocation().getY());
    }

    public enum Profession {
        WARRIOR,
        RANGER
    }

    public enum Attribute {
        HEALTH,
        MANA,
        STRENGTH
    }

}
