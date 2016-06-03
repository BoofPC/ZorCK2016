package core;

import java.util.HashMap;

public class World {
    /**
     * Direction constants for use in world traversal.
     */
    public static enum Direction {
        NORTH, EAST, SOUTH, WEST, NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST, UP, DOWN
    }

    private final HashMap<String, Area> map;


    public World() {
        this.map = new HashMap<>();
    }

    public void addArea(final String areaName, final Area newArea) {
        this.map.put(areaName, newArea);
    }

    public Area getArea(final String name) {
        return this.map.get(name);
    }
}
