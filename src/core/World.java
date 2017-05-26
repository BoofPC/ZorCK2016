package core;

import core.Area;
import core.Door;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class World {

    protected static final Map<String, Area> areas;
    protected Area currentArea;
    static {
        areas = new HashMap<>();
    }

    public World(String startingArea){
        this.currentArea = areas.get(Area.toID(startingArea));
    }

    public static Area getArea(String areaId){
        return areas.get(areaId);
    }

    public Area getCurrentArea() {
        return currentArea;
    }

    private void setCurrentArea(String areaId) {
        this.currentArea = areas.get(areaId);
    }

    public void move(Area.Direction direction){
        Door door;
        if((door = currentArea.getDoors().get(direction)) != null){
            if(door.pass() != null){
                this.setCurrentArea(door.pass());
            }
        } else {
            System.out.println("You can't go that way!");
        }
    }
}
