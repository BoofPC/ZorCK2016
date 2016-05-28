package core;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
}
