package core;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int hp;
    private int maxHp;
    private String name;
    private Area currentArea;
    private int score;
    private boolean prayer;
    private Game.Status death;
    private boolean sit;
    
    private List<Item> inventory;
    

    public Player(int hp, String name){
        this.hp = hp;
        this.maxHp = hp;
        this.name = name;
        this.prayer = false;
        this.death = Game.Status.KEEP_PLAYING;
        this.sit = false;
        
        this.inventory = new ArrayList<>();
    }

    public String getName(){
        return this.name;
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
    
    public boolean hasMatching(Item item){
        for(Item item2: this.inventory){
            if(item == item2) return true;
        }
        return false;
    }
    
    public Item[] listInventory(){
        Item[] list = new Item[this.inventory.size()];
        for(int i = 0; i < this.inventory.size(); i++){
            list[i] = this.inventory.get(i);
        }
        return list;
    }
    
    public Item getItem(String name){
        for(Item item: this.inventory){
            if(name.equals(item.getName())) return item;
        }
        return null;
    }
    
    public Area getCurrentArea(){
        return this.currentArea;
    }
    
    public void setCurrentArea(Area area){
        this.currentArea = area;
    }
    
    public void setScore(int n){
        this.score = n;
    }
    
    public int getScore(){
        return this.score;
    }
    
    public void addScore(int n){
        this.score += n;
    }
    
    public void setHp(int n){
        this.hp = n;
    }
    
    public int getHp(){
        return this.hp;
    }
    
    public void addHp(int n){
        this.hp += n;
    }
    
    public void setMaxHp(int n){
        this.maxHp = n;
    }
    
    public int getMaxHp(){
        return this.maxHp;
    }
    
    public void setPrayer(boolean bool){
        this.prayer = bool;
    }
    
    
    public boolean getPrayer(){
        return this.prayer;
    }
    
    public void setSit(boolean bool){
        this.sit = bool;
    }
    
    public boolean getSit(){
        return this.sit;
    }
    
    public void setDeath(Game.Status death){
        this.death = death;
    }
    
    public Game.Status getDeath(){
        return this.death;
    }
}
