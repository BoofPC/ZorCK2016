package core;

import java.util.HashMap;

/**
 *
 * @author pedro
 */
public final class Context {
    
    private final Player player;
    private final World world;
    private final HashMap<String, Boolean> state;
    
    public Context(Player player, World world){
        this.player = player;
        this.world = world;
        this.state = new HashMap<>();
    }

    public Player getPlayer() {
        return player;
    }

    public World getWorld() {
        return world;
    }

    public HashMap<String, Boolean> getState() {
        return state;
    }
}
