
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
    private HashMap<String,Boolean> state;
    private World world;
    
    public Area(World containingWorld){
        this.state = new HashMap<>();
        this.world = containingWorld;
    }
    
    public World getContainingWorld(){
        return this.world;
    }
    
    public abstract void interact(String command, Player player);
    
    public abstract void enter(Player player);
    
    public abstract void exit(Player player);
    
    public void addStateSwitch(String key, Boolean startState){
        this.state.put(key, startState);
    }
    
    public void setState(String key, Boolean newState){
        this.state.replace(key, newState);
    }
    
    public Boolean checkState(String key){
        return this.state.get(key);
    }
}
