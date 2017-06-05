
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
public class Hallway10 extends Area{
    public Hallway10(){
        super("Hallway 10");
        this.getDoors().put(Direction.SOUTH, new Door("Adamson's Room"));
        this.getDoors().put(Direction.EAST, new Door("Hallway 9"));
        this.getDoors().put(Direction.WEST, new Door("Hallway 11"));
        
        this.description = "Doors with small windows on them are to the south. Inside you can see lots of "
                + "\ncomputers. Maybe this is some kind of computer lab?";
    }
        public boolean captureInput(VerbPhrase v, Context c){
        return Game.GO_TO_NEXT;
    }
}
