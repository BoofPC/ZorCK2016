package testgame;

import core.*;

import java.util.Arrays;
import java.util.function.Function;

/**
 * Created by Alex on 5/22/17.
 */
public class EastRoom extends Area {
    private String laterDescription = "There is a box in the corner with a muffin and the NorthKey in it.";

    public boolean captureInput(VerbPhrase v, Context c){
        if(c.getPlayer().getInventory().contains("muffin")){
            this.description = "There is a box in the corner with some crumbs and the NorthKey in it.";
        }
        if(c.getPlayer().getInventory().contains("North Key")){
            this.description = "There is a box in the corner with a muffin in it.";
        }
        if(c.getPlayer().getInventory().containsAll(Arrays.asList("NorthKey","muffin"))) {
            this.description = "There is a box in the corner with nothing in it.";
        }
        return Game.GO_TO_NEXT;
    }

    public EastRoom(){
        super("East Room");

        this.getDoors().put(Direction.WEST,new Door("Center Room"));

        this.description = "The room is empty except for a box in the corner";

        this.getLocalActions().put(new VerbPhrase("open","box"),(c)->{
            System.out.println("You open the box and notice there is the NorthKey and a muffin inside.");
            c.getState().add("east_box_open");
            description = laterDescription;
            this.getInventory().add("muffin");
            this.getInventory().add("NorthKey");
            return !Game.GO_TO_NEXT;
        });

        Function<Context,Boolean> f = (c)->{
            System.out.println("Got it.");
            this.getInventory().remove("NorthKey");
            c.getPlayer().getInventory().add("NorthKey");
            return !Game.GO_TO_NEXT;
        };
        this.getLocalActions().put(new VerbPhrase("take","key"),f);
        this.getLocalActions().put(new VerbPhrase("take","NorthKey"),f);

        this.getLocalActions().put(new VerbPhrase("take","muffin"),(c)->{
            System.out.println("Got it.");
            this.getInventory().remove("muffin");
            c.getPlayer().getInventory().add("muffin");
            return !Game.GO_TO_NEXT;
        });
    }
}
