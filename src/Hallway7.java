import tbge.Area;
import tbge.Context;
import tbge.Door;
import tbge.Game;
import tbge.Player;
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
public class Hallway7 extends Area{
    public Hallway7(){
        super("Hallway 7");
        this.getDoors().put(Direction.EAST, new Door("Rooftop"));
        this.getDoors().put(Direction.WEST, new Door("Hallway 8"));
        this.description = "There seems to be a window at the end of the hallway; however, the glass is "
                + "\nshattered. There is a small balcony on the other side. Maybe a person could fit through? "
                + "\nBe careful though, the glass is sharp… ";
    
    }
    public boolean captureInput(VerbPhrase v, Context c){
        return Game.GO_TO_NEXT;
    }
}
