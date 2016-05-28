package core;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author alexb & pedro
 */
public class Player {
    public int hp;
    public String name;
    
    private List<Item> inventory;
    

    public Player(int hp, String name){
        this.hp = hp;
        this.name = name;
        
        this.inventory = new ArrayList<>();
    }
}
