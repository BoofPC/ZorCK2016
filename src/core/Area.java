package core;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexb & pedro
 */
public abstract class Area{
    //this is a 10 element array that has portals in 
    //each of the cardinal and half-cardinal directions as well as up and down.
    private final Portal[] portals; 
    private World world;
    private String title;
    private String description;
    
    private HashMap<String,Boolean> state;
    
    public Area(World containingWorld){
       this.portals = new Portal[10];
       this.world = containingWorld;
       this.state = new HashMap<>();
    }
    
    public World getContainingWorld(){
        return this.world;
    }
    
    public abstract void interact(String command, Player player);
    
    public abstract void enter(Player player);
    
    public abstract void exit(Player player);
    
    public void setPortal(Portal portal, int direction){
        this.portals[direction] = portal;
    }
    //allow other classes to get the portal value where you can lock or unlock 
    //it, and check its state. This is ideal because it is more direct than 
    //having Portal helper methods in Area
    public Portal getPortal(int direction){
        return this.portals[direction];
    }
	
    public String getTitle(){
	return this.title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
	
    public String getDescription(){
        return this.description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
}
