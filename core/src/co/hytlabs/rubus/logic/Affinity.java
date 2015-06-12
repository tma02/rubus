package co.hytlabs.rubus.logic;

import java.util.HashMap;

/**
 * Rubus
 * Created by tma02 on 6/8/15.
 * Description: Store attribute buffs for affinities.
 */

public class Affinity {

    public static Affinity FORTITUDE = new Affinity("Fortitude", "Grants buffs that make staying alive easier.");
    public static Affinity PERCEPTION = new Affinity("Perception", "Grants buffs that make targeting monsters easier.");

    private String name;
    private String desc;
    private HashMap<Character.Attribute, Short> buffs;

    public Affinity(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.buffs = new HashMap<Character.Attribute, Short>();
    }

    public void addBuff(Character.Attribute attribute, short value) {
        this.buffs.put(attribute, value);
    }

    public short getBuff(Character.Attribute attribute) {
        return this.buffs.get(attribute);
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.desc;
    }

}
