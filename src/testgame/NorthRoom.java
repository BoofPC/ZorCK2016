package testgame;

import core.*;

import java.util.Arrays;
import java.util.function.Function;

/**
 * Created by Alex on 5/22/17.
 */
public class NorthRoom extends Area {
    private String initialDescription =  "The room has a giant angry troll inside who is guarding his treasure trove. "
            + "He looks hungry...";
    private String laterDescription = "The troll seems to be getting hungrier...";
    private int turnsInRoom;

    public boolean captureInput(VerbPhrase v, Context c){
        turnsInRoom++;
        switch (turnsInRoom){
            case 1:
                System.out.println(initialDescription);
                break;
            case 2:
            case 3:
            case 4:
                System.out.println(laterDescription);
                break;
            case 5:
                System.out.println("He finally loses his patience and eats you in one bite. You Lose.");
                c.getGame().quit();
                return !Game.GO_TO_NEXT;
        }
        return Game.GO_TO_NEXT;
    }

    public NorthRoom(){
        super("North Room");

        this.getDoors().put(Direction.SOUTH,new Door("Center Room"));

        this.getLocalActions().put(new VerbPhrase("kill","troll"),(c)->{
            System.out.println("You try to kill the troll but he kills you instead.");
            c.getGame().quit();
            return !Game.GO_TO_NEXT;
        });

        Function<Context,Boolean> f = (c)->{
            System.out.println("You give the troll the muffin and he is pleased. He gives you his treasure and a way"
                    + " out of the dungeon. You Win!!");
            c.getGame().quit();
            return !Game.GO_TO_NEXT;
        };
        this.getLocalActions().put(new VerbPhrase("give","muffin","troll"),f);
        this.getLocalActions().put(new VerbPhrase("give","troll","muffin"),f);

        turnsInRoom = 0;
    }
}
