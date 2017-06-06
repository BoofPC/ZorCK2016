import tbge.*;

/**
 * Created by guerrer4154c on 6/6/2017.
 */
public class Hallway16 extends Area {
    public Hallway16(){
        super("Hallway16");
        this.getDoors().put(Direction.WEST, new Door("Hallway17"));
        this.getDoors().put(Direction.EAST, new Door("Hallway15"));
        this.description = "This part of the hallway seems pretty boring."
        +"\nMaybe if you continue down the path, you will be lead to somewhere important?";
    }
    public boolean captureInput(VerbPhrase v, Context c){
        return Game.GO_TO_NEXT;
    }
}
