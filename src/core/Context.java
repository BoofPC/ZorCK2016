package core;

import java.util.HashMap;

public final class Context {
    
    private final Player player;
    private final World world;
    private final HashMap<String, Boolean> state;
    private boolean skipGeneral;
    
    public Context(Player player, World world){
        this.player = player;
        this.world = world;
        this.state = new HashMap<>();
        this.skipGeneral = false;
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
    
    public void setSkipGeneral(boolean skipGeneral){
        this.skipGeneral = skipGeneral;
    }
    
    public boolean getSkipGeneral(){
        return this.skipGeneral;
    }
}
