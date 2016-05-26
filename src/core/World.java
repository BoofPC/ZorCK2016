package core;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexb
 */

//remocing accessiblity, adding portals 
public class World {
    private Area[][] map;
    

    public World(int size){
        this.map = new Area[size][size];
    }
    
    public void addArea(int x, int y, Area newArea){
        this.map[x][y] = newArea;
    }
    
    public Area getAreaAt(int x, int y){
        return this.map[x][y];
    }
}
