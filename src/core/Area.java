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
    private String taste;
    private String smell;
    private String sound;
    private boolean dark;
    private boolean firstVisit;
    
    public ArrayList<Item> items;
    
    private HashMap<String,Boolean> state;
    
    public Area(World containingWorld){
       this.portals = new Portal[10];
       this.world = containingWorld;
       this.state = new HashMap<>();
       this.items = new ArrayList<Item>();
       this.firstVisit = true;
    }
    
    public World getContainingWorld(){
        return this.world;
    }
    
    public abstract void interact(String command, Player player);
    
    public void enter(Player player){
       if(this.firstVisit && !this.dark){
           System.out.println(this.initialDescription);
           this.firstVisit = false;
       }else if (this.firstVisit && player.getItem("Lantern") != null){
       	   if(player.getItem("Lantern").getActive()){
                     System.out.println(
                         player.getCurrentArea().getInitialDescription());
                     this.firstVisit = false;
                 }else{
                     System.out.println("It's too dark to see!");
                 }
       }else if(this.firstVisit){
       	   System.out.println("It's too dark to see!");
       }else System.out.println(this.description);
    }
    
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
    
    public int getDirection(Portal portal){
        for(int i = 0; i < this.portals.length; i++){
            if(portal == this.portals[i]) return i;
        }
        return -1;
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
    
    public String getTaste(){
        return this.taste;
    }
    
    private void setTaste(String input){
        this.taste = input;
    }
    
    public String getSmell(){
        return this.smell;
    }
    
    private void setSmell(String input){
        this.smell = input;
    }
    
    public String getSound(){
        return this.sound;
    }
    
    private void setSound(String input){
        this.sound = input;
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
    
    public boolean getDark(){
        return this.dark;
    }
    
    public void setDark(boolean dark){
        this.dark = dark;
    }
}
