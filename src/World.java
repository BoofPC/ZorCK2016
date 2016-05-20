/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexb
 */
public class World {
    private Area[][] map;
    private boolean[][] isAccessible;
    
    public World(int size){
        this.map = new Area[size][size];
        this.isAccessible = new boolean[size][size];
    }
    
    public void addArea(int x, int y, Area newArea){
        this.map[x][y] = newArea;
    }
    
    public Area getAreaAt(int x, int y){
        if(isAccessible[x][y]) return this.map[x][y];
        return null;
    }
    
    public void setAccessibility(int x, int y, boolean isAccessible){
        this.isAccessible[x][y] = isAccessible;
    }
}
