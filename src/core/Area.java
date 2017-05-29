package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Area{
    private final Map<Direction,Door> doors;
    private final Map<VerbPhrase, Function<Context,Boolean>> localActions;
    private final List<String> inventory;
    private final String name;
    private final String id;
    public String description;

    public Area(String name){
        this.doors = new HashMap<>();
        this.localActions = new HashMap<>();
        this.inventory = new ArrayList<>();
        this.name = name;
        this.id = toID(name);
        this.description = "";
    }

    public boolean captureInput(VerbPhrase v, Context c){
        boolean pass;
        if(this.localActions.get(v) != null){
            pass = this.localActions.get(v).apply(c);
        } else {
            System.out.println("What?");
            pass = false;
        }
        return pass;
    }

    public static String toID(String name){
        return String.join("", name.split("\\s&&\\p{Punct}")).toLowerCase();
    }

    public String getName(){
        return this.name;
    }

    public String getId(){
        return this.id;
    }

    public Map<Direction,Door> getDoors(){
        return this.doors;
    }

    public Map<VerbPhrase, Function<Context,Boolean>> getLocalActions(){
        return this.localActions;
    }

    public List<String> getInventory(){ return this.inventory; }

    public static enum Direction{
        NORTH,NORTHEAST,EAST,SOUTHEAST,SOUTH,SOUTHWEST,WEST,NORTHWEST,UP,DOWN, NODIRECTION
    }
}
