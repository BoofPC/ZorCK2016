
import tbge.Area;
import tbge.Context;
import tbge.Door;
import tbge.Game;
import tbge.VerbPhrase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rodrigu3163b
 */
public class Hallway11 extends Area{
    public Hallway11(){
        super("Hallway 11");
        this.getDoors().put(Direction.EAST, new Door("Hallway 10"));
        //this.getDoors().put(Direction.WEST, new Door("Hallway 12"));
        this.description = "A room is to the south, however it seems to be locked. It's labeled"
                + "\n\"Broadcasting Room\". How would you get inside?";
        
        this.getLocalActions().put(new VerbPhrase("south"), (c)->{
            System.out.println("The door seems to be locked, maybe there is another way"
                    + "\n to get in...");
            return !Game.GO_TO_NEXT;
        });
    }
        public boolean captureInput(VerbPhrase v, Context c){
        return Game.GO_TO_NEXT;
    }
}
