
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
public class Hallway9 extends Area{
    public Hallway9(){
        super("Hallway 9");
        this.getDoors().put(Direction.SOUTH, new Door("ISS Room"));
        this.getDoors().put(Direction.EAST, new Door("Hallway 8"));
        this.getDoors().put(Direction.WEST, new Door("Hallway 10"));
        
        this.description = "A door labeled \"ISS Room\" is to the south. That's where students get sent if"
                + "\nthey get in trouble. Perhaps something useful is in there?";
    }
        public boolean captureInput(VerbPhrase v, Context c){
        return Game.GO_TO_NEXT;
    }
}
