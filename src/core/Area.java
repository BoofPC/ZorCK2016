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
public abstract class Area {
    private Portal[] portals;
    private World world;
    private int id;
	private String title;
	private String description;
    
    public Area(int id, World containingWorld, Portal[] portals){
        this.id = id;
        this.portals = {true,true,true,true,true,true,true,true};  	//all directions are locked by default,
																	//that way you could only import a 4 item
																	//array and ignore NE,SE,SW,NW
        for(int i = 0; i < portals.length; i++){
            this.portals[i] = portals[i];
        }
        this.world = containingWorld;
    }
    
    public World getContainingWorld(){
        return this.world;
    }
    
    public abstract void interact(String command, Player player);
    
    public abstract void enter(Player player);
    
    public abstract void exit(Player player);
    
    public void addPortal(int n,Portal portal){
        this.portals[n] = portal;
    }
    
    public void setPortalLock(int n, Boolean newState){
        if(newState)
            this.portals[n].lock();
        else
            this.portals[n].unlock();
    }
    
    public Boolean checkPortalLock(int n){
        return this.portals[n].isLocked();
    }
	
	public Portal getPortal(int n){
		return this.portals[n];
	}
    
    public int getId(){
        return this.id;
    }
	
	public String getTitle(){
		return this.title;
	}
	
	public String getDescription(){
		return this.description;
	}
}
