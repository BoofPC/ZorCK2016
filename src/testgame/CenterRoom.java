package testgame;

import core.*;

import java.util.function.Function;

/**
 * Created by Alex on 5/22/17.
 */
public class CenterRoom extends Area {
    private String laterDescription = "You are in a large-ish room which is mostly empty except for a table with"
            +" a pair of scissors on it. There are doors to the North and East of you.";

    public CenterRoom(){
        super("Center Room");
        this.getDoors().put(Direction.NORTH,new Door("North Room","NorthKey"));
        this.getDoors().put(Direction.EAST,new Door("East Room"));

        this.getInventory().add("scissors");

        this.description = "The lights are off so it's too dark to see. Maybe you can find the switch and"
                +" shed some light on the situation...";

        Function<Context,Boolean>switchOn = (c)-> {
            System.out.println("You flip the switch turning on the light. Now you can see!");
            System.out.println(description = laterDescription);
            c.getState().add("center_light_on");
            return !Game.GO_TO_NEXT;
        };
        this.getLocalActions().put(new VerbPhrase("switch","light"), switchOn);
        this.getLocalActions().put(new VerbPhrase("switch","lights"), switchOn);

        this.getLocalActions().put(new VerbPhrase("take","scissors"),(c)->{
            description = "You are in a large-ish room which is mostly empty except for a table. There are doors "
                    + "to the North and East of you";
            System.out.println("You take the scissors. Whoa, those look super pointy--make sure NOT to run with them!");
            if(this.getInventory().remove("scissors")){
                c.getPlayer().getInventory().add("scissors");
            } else {
                System.out.println("You already took those!");
            }

            return !Game.GO_TO_NEXT;
        });

        Function<Context,Boolean> f = (c) -> {
            if(c.getPlayer().getInventory().contains("NorthKey")){
                this.getDoors().get(Direction.NORTH).unlock("NorthKey");
            }
            return !Game.GO_TO_NEXT;
        };
        this.getLocalActions().put(new VerbPhrase("unlock","door"),f);
        this.getLocalActions().put(new VerbPhrase("use","NorthKey"),f);
        this.getLocalActions().put(new VerbPhrase("open","door"),f);
        this.getLocalActions().put(new VerbPhrase("unlock","North"),f);
        this.getLocalActions().put(new VerbPhrase("unlock","North","door"),f);
    }

    @Override
    public boolean captureInput(VerbPhrase v,Context c){
        if(!c.getState().contains("center_light_on")
                && !(v.equals(new VerbPhrase("switch","light"))
                || v.equals(new VerbPhrase("turn","light"))
                || v.equals(new VerbPhrase("switch","lights")))
                || v.equals(new VerbPhrase("turn","lights"))){
            System.out.println(description);
            return !Game.GO_TO_NEXT;
        }
        return Game.GO_TO_NEXT;
    }

}
