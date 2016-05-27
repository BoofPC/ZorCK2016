
package core;

/**
 *
 * @author keith5387h & pedro & alexb
 */
public class Portal {
   
    boolean locked;
    int target; //Should be the id of an area to go to
    
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
    
    public int getTarget(){
        return this.target;
    }
}
