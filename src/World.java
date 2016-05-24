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
    private boolean[][] isAccessibleNorth;
    private boolean[][] isAccessibleSouth;
    private boolean[][] isAccessibleEast;
    private boolean[][] isAccessibleWest;
    
    public World(int size){
        this.map = new Area[size][size];
        this.isAccessibleNorth = new boolean[size][size];
        this.isAccessibleSouth = new boolean[size][size];
        this.isAccessibleEast = new boolean[size][size];
        this.isAccessibleWest = new boolean[size][size];
    }
    
    public void addArea(int x, int y, Area newArea){
        this.map[x][y] = newArea;
    }
    
    public Area getAreaAt(int x, int y){
        return this.map[x][y];
    }
    
    
    public void setAccessibilityNorth(int x, int y, boolean isAccessible){
        this.isAccessibleNorth[x][y] = isAccessible;
    }
    public void setAccessibilityEast(int x, int y, boolean isAccessible){
        this.isAccessibleEast[x][y] = isAccessible;
    }
    public void setAccessibilitySouth(int x, int y, boolean isAccessible){
        this.isAccessibleSouth[x][y] = isAccessible;
    }
    public void setAccessibilityWest(int x, int y, boolean isAccessible){
        this.isAccessibleWest[x][y] = isAccessible;
    }
}
