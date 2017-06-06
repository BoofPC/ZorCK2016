import tbge.*;

/**
 * Created by guerrer4154c on 6/6/2017.
 */
public class Hallway15 extends Area {
    public Hallway15(){
        super("Hallway15");
        this.getDoors().put(Direction.WEST, new Door("Hallway16"));
        this.getDoors().put(Direction.EAST, new Door ("Hallway 14"));
        this.getDoors().put(Direction.NORTH, new Door("Oishi's Room"));
        this.description = "A language that you don't understand can be heard from Oishi sensei's room to the north of you."
        +"\nPerhaps you ought to check it out?";
    }
    public boolean captureInput(VerbPhrase v, Context c){
        return Game.GO_TO_NEXT;
    }
}
