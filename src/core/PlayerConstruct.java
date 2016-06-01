package core;

/**
 *
 * @author pedro
 */
public class PlayerConstruct {
    
    private Player player;
    private World world;
    
    public PlayerConstruct(Player player, World world){
        this.player = player;
        this.world = world;
    }
    
    public Player getPlayer(){
        return this.player;
    }
    
    public World getWorld(){
        return this.world;
    }
    
}
