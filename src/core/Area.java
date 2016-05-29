package core;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author alexb & pedro
 */
public abstract class Area{
    //this is a 10 element array that has portals in 
    //each of the cardinal and half-cardinal directions as well as up and down.
    private final Portal[] portals; 
    private World world;
    private String title;
    private String initialDescription;
    private String description;
    public ArrayList<Item> items;
    
    private HashMap<String,Boolean> state;
    
    public Area(World containingWorld){
       this.portals = new Portal[10];
       this.world = containingWorld;
       this.state = new HashMap<>();
       this.items = new ArrayList<Item>();
    }
    
    public World getContainingWorld(){
        return this.world;
    }
    
    public abstract void interact(String command, Player player);
    
    public abstract void enter(Player player);
    
    public abstract void exit(Player player);
    
    public void setPortal(int direction, Portal portal){
        this.portals[direction] = portal;
    }
    //allow other classes to get the portal value where you can lock or unlock 
    //it, and check its state. This is ideal because it is more direct than 
    //having Portal helper methods in Area
    public Portal getPortal(int direction){
        if(this.portals[direction] == null) return new Portal(true,null);
        else return this.portals[direction];
    }
	
    public String getTitle(){
	return this.title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
	
    public String getInitialDescription(){
        return this.initialDescription;
    }
    
    public void setInitialDescription(String description){
        this.initialDescription = description;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
	
    public boolean getState(String name){
        return this.state.get(name);
    }
	
    public void setState(String name, boolean bool){
	this.state.put(name,bool);
    }
    
    public void addItem(Item item){
        this.items.add(item);
    }
    
    public void removeItem(Item item){
        this.items.remove(item);
    }
    
    public boolean hasMatching(Item item){
        for(Item item2: this.items){
            if(item == item2) return true;
        }
        return false;
    }
    
    public Item[] listItems(){
        Item[] list = new Item[this.items.size()];
        for(int i = 0; i < this.items.size(); i++){
            list[i] = this.items.get(i);
        }
        return list;
    }
    
    
    
}
