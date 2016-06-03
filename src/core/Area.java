package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Area{
    //this is a 10 element array that has portals in 
    //each of the cardinal and half-cardinal directions as well as up and down.
    private final Portals portals; 
    private World world;
    private String title;
    private String initialDescription;
    private String description;
    private String taste;
    private String smell;
    private String sound;
    private boolean dark;
    private boolean firstVisit;
    
    public List<Item> items;
    
    private HashMap<String,Boolean> state;
    
    public Area(World containingWorld){
       this.portals = new Portals();
       this.world = containingWorld;
       this.state = new HashMap<>();
       this.items = new ArrayList<Item>();
       this.firstVisit = true;
    }
    
    public World getContainingWorld(){
        return this.world;
    }
    
    public abstract void interact(Command command, Context context);
    
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
    
    public Portals getPortals() {
        return this.portals;
    }
    
    public World.Direction getDirection(Portal portal){
        for(World.Direction d : World.Direction.values()){
            if(portal == this.portals.getPortal(d)) return d;
        }
        return null;
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
    
    public void setTaste(String input){
        this.taste = input;
    }
    
    public String getSmell(){
        return this.smell;
    }
    
    public void setSmell(String input){
        this.smell = input;
    }
    
    public String getSound(){
        return this.sound;
    }
    
    public void setSound(String input){
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
    
    public List<Item> getItems(){
        return this.items;
    }
    
    public Item getItem(String title) {
        for (Item item : this.items) {
            if (item.getName().equals(title)) {
                return item;
            }
        }
        return null;
    }
    
    public boolean getDark(){
        return this.dark;
    }
    
    public void setDark(boolean dark){
        this.dark = dark;
    }
    
    public boolean getFirstVisit(){
        return this.firstVisit;
    }
}
