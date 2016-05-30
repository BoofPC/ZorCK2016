package core;

import items.*;

/**
 *
 * @author keith5387h & pedro & alexb
 */
public class Portal {
   
    boolean locked;
    String target; //Should be the id of an area to go to
    
    public Portal(boolean locked, String target){
        this.locked = locked;
        this.target = target;
    }
    
    public boolean isLocked(){
        return this.locked;
    }
    
    public void lock(){
        this.locked = true;
    }
    
    public void unlock(){
        this.locked = false;
    }
    
    public String getTarget(){
        return this.target;
    }
    
    public Item getDoor(Area currentArea){
        for(int i = 0; i < currentArea.listItems().length; i++){
            if(currentArea.listItems()[i].getPortal() == this) return currentArea.listItems()[i];
        }
        return null;
    }
}
