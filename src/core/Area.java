package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public abstract class Area{
    /**
     *  This stores portals in each {@link World.Direction}.
     */
    private final Portals portals;
    private final World world;
    private String title;
    private String initialDescription;
    private String description;
    private String taste;
    private String smell;
    private String sound;
    private boolean dark;
    private boolean firstVisit;

    private final List<Item> items;

    private final HashMap<String,Boolean> state;

    public Area(final World containingWorld){
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

    public void enter(final Player player){
       if(this.firstVisit && !this.dark){
           System.out.println(this.initialDescription);
           this.firstVisit = false;
       }else if (this.firstVisit && player.getItem("Lantern") != null){
       	   if(player.getItem("Lantern").active()){
                     System.out.println(
                         player.getCurrentArea().getInitialDescription());
                     this.firstVisit = false;
                 }else{
                     System.out.println("It's too dark to see!");
                 }
       }else if(this.firstVisit){
       	   System.out.println("It's too dark to see!");
       } else {
        System.out.println(this.description);
    }
    }

    public Portals getPortals() {
        return this.portals;
    }

    public World.Direction getDirection(final Portal portal){
        return Arrays.stream(World.Direction.values())
                .filter(d -> portal == this.portals.getPortal(d)).findAny().orElse(null);
    }

    public String getTitle(){
	return this.title;
    }

    public void setTitle(final String title){
        this.title = title;
    }

    public String getInitialDescription(){
        return this.initialDescription;
    }

    public void setInitialDescription(final String description){
        this.initialDescription = description;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(final String description){
        this.description = description;
    }

    public String getTaste(){
        return this.taste;
    }

    public void setTaste(final String input){
        this.taste = input;
    }

    public String getSmell(){
        return this.smell;
    }

    public void setSmell(final String input){
        this.smell = input;
    }

    public String getSound(){
        return this.sound;
    }

    public void setSound(final String input){
        this.sound = input;
    }

    public boolean getState(final String name){
        return this.state.get(name);
    }

    public void setState(final String name, final boolean bool){
        this.state.put(name,bool);
    }

    public void addItem(final Item item){
        this.items.add(item);
    }

    public void removeItem(final Item item){
        this.items.remove(item);
    }

    public boolean hasMatching(final Item item){
        return this.items.stream().anyMatch(i -> i == item);
    }

    public List<Item> getItems(){
        return this.items;
    }

    public Item getItem(final String title) {
        return this.items.stream().filter(i -> i.name().equals(title)).findFirst().orElse(null);
    }

    public boolean getDark(){
        return this.dark;
    }

    public void setDark(final boolean dark){
        this.dark = dark;
    }

    public boolean getFirstVisit(){
        return this.firstVisit;
    }
}
