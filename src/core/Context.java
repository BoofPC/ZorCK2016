package core;

import java.util.HashMap;

/**
 *
 * @author pedro
 */
public class Context {
    
    public final Player player;
    public final World world;
    public final HashMap<String, Boolean> state;
    
    public Context(Player player, World world){
        this.player = player;
        this.world = world;
        this.state = new HashMap<>();
    }  
}
