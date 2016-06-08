package core;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class World {
    /**
     * Direction constants for use in world traversal.
     */
    public static enum Direction {
        NORTH, EAST, SOUTH, WEST, NORTHEAST, SOUTHEAST, SOUTHWEST, NORTHWEST, UP, DOWN
    }

    private final HashMap<Class<? extends Area>, Area> map;


    public World() {
        this.map = new HashMap<>();
    }

    public World addArea(final Class<? extends Area> areaName, final Area newArea) {
        this.map.put(areaName, newArea);
        return this;
    }

    public World addArea(final Class<? extends Area> areaName) {
        try {
            return this.addArea(areaName, areaName.getConstructor(World.class).newInstance(this));
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Area getArea(final Class<? extends Area> area) {
        return this.map.get(area);
    }
}
