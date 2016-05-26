package core;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList

/**
 *
 * @author alexb
 */

//remocing accessiblity, adding portals 
public class World {
    
    private ArrayList<Area> areas;

    public World(ArrayList<Area> areas){
        for(Area item: areas){
            this.areas.add(item);
        }
    }
    
    public void addArea(Area newArea){
        this.areas.add(newArea);
    }
    
    public Area getAreaAt(int id){
        for(Area item: areas){
            if(item.getID == id) return item;
        }
        return null;
    }
}
