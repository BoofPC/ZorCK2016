import tbge.*;

/**
 * Created by lynds on 6/1/2017.
 */
public class Hallway6 extends Area {
    public Hallway6(){
        super("Hallway 6");
        this.getDoors().put(Direction.NORTH, new Door("Hallway 5"));
        //this.getDoors().put(Direction.SOUTH, new Door("Hallway 8"));
        this.description = "Yup. The hallway just keeps going.";
    }

    public boolean captureInput(VerbPhrase v, Context c) {
        return Game.GO_TO_NEXT;
    }
}
