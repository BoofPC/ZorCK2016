package core;

import java.util.HashMap;
import java.util.Random;

public final class Context {

    private final Player player;
    private final World world;
    private final HashMap<String, Boolean> state;
    private boolean skipGeneral;
    private String password;

    public Context(final Player player, final World world){
        this.player = player;
        this.world = world;
        this.state = new HashMap<>();
        this.skipGeneral = false;
        Random rand = new Random();
        int n = rand.nextInt(7);
        switch (n) {
            case 0:
                this.password = "compsci_is_fun!";
                break;
            case 1:
                this.password = "d0ughnuts";
                break;
            case 2:
                this.password = "dickcheneymademoneyoff911";
                break;
            case 3:
                this.password = "password";
                break;
            case 4:
                this.password = "admin";
                break;
            case 5:
                this.password = "I'mInAGlassCaseOfEmotion!";
                break;
            case 6:
                this.password = "Stay Classy, Central Kitsap";
                break;
            default:
                this.password = "Great Odin's Raven";    
                break; 
        }
        System.out.println(n);
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
    
    public String getPassword(){
        return this.password;
    }
}
