
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
public class Hallway8 extends Area{
    public Hallway8(){
        super("Hallway 8");
        this.getDoors().put(Direction.NORTH, new Door("Hallway 6"));
        this.getDoors().put(Direction.EAST, new Door("Hallway 7"));
        this.getDoors().put(Direction.WEST, new Door("Hallway 9"));
        
        this.description = "The hallway continues to the west and the east, as well as opening to the"
                + "\nsouth. It reeks of cheap perfume, most likely because you're so close to the Women's "
                + "\nrestroom.";
    }
        public boolean captureInput(VerbPhrase v, Context c){
        return Game.GO_TO_NEXT;
    }
}
