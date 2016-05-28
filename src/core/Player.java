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
    Area currentArea;
    
    private List<Item> inventory;
    

    public Player(int hp, String name){
        this.hp = hp;
        this.name = name;
        
        this.inventory = new ArrayList<>();
    }

    public void rename(String name){
        this.name = name;
    }
    
    public void addItem(Item item){
        this.inventory.add(item);
    }
    
    public void removeItem(Item item){
        this.inventory.remove(item);
    }
    
    public boolean ifItem(Item item){
        for(Item item2: this.inventory){
            if(item == item2) return true;
        }
        return false;
    }
    
    public String[] listInventory(){
        String[] list = new String[this.inventory.size()];
        for(int i = 0; i < this.inventory.size(); i++){
            list[i] = this.inventory.get(i).getName();
        }
        return list;
    }
    
    public Area getCurrentArea(){
        return this.currentArea;
    }
    
    public void setCurrentArea(Area area){
        this.currentArea = area;
    }
}
