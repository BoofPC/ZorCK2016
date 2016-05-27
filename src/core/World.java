package core;

import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author alexb & pedro
 */

//remocing accessiblity, adding portals 
public class World {

    //Direction constants for use by Areas when assigning portals.
    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;
    
    public static final int NORTHEAST = 4;
    public static final int SOUTHEAST = 5;
    public static final int SOUTHWEST = 6;
    public static final int NORTHWEST = 7;
    
    public static final int UP = 8;
    public static final int DOWN = 9;
    
    private HashMap<String,Area> map;


    public World(){
        this.map = new HashMap<>();
    }
    
    public void addArea(String areaName, Area newArea){
        this.map.put(areaName,newArea);
    }
    
    public Area getArea(String name){
        return this.map.get(name);
    }
}
