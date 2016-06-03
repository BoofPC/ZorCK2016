package core;

import java.util.HashMap;

public final class Context {

    private final Player player;
    private final World world;
    private final HashMap<String, Boolean> state;
    private boolean skipGeneral;

    public Context(final Player player, final World world){
        this.player = player;
        this.world = world;
        this.state = new HashMap<>();
        this.skipGeneral = false;
    }

    public Player getPlayer() {
        return this.player;
    }

    public World getWorld() {
        return this.world;
    }

    public HashMap<String, Boolean> getState() {
        return this.state;
    }

    public void setSkipGeneral(final boolean skipGeneral){
        this.skipGeneral = skipGeneral;
    }

    public boolean getSkipGeneral(){
        return this.skipGeneral;
    }
}
