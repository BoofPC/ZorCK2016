package core;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexb
 */
public abstract class Area {
    private ArrayList<Portal> portals;
    private World world;
    
    public Area(World containingWorld, ArrayList<Portal> portals){
        for(Portal item: portals){
            this.portals.add(item);
        }
        this.world = containingWorld;
    }
    
    public World getContainingWorld(){
        return this.world;
    }
    
    public abstract void interact(String command, Player player);
    
    public abstract void enter(Player player);
    
    public abstract void exit(Player player);
    
    public void addPortal(Portal portal){
        this.portals.add(portal);
    }
    
    public void setPortal(Portal portal, Boolean newState){
        this.portal.setAccessible(newState);
    }
    
    public Boolean checkPortal(Portal portal){
        return this.portal.getAccessible();
    }
}
