package core;

import java.util.HashMap;

// TODO Figure out what this comment is here for. It shouldn't be here or should be a JavaDoc.
// remocing accessiblity, adding portals
public class World {

    //Direction constants for use by Areas when assigning portals.
    public static enum Direction {
        NORTH, EAST, SOUTH, WEST, NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST, UP, DOWN
    }

    private HashMap<String, Area> map;


    public World() {
        this.map = new HashMap<>();
    }

    public void addArea(String areaName, Area newArea) {
        this.map.put(areaName, newArea);
    }

    public Area getArea(String name) {
        return this.map.get(name);
    }
}
