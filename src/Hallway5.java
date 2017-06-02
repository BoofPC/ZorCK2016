import tbge.*;

/**
 * Created by lynds on 6/1/2017.
 */
public class Hallway5 extends Area{

    public Hallway5(){
        super("Hallway 5");
        this.getDoors().put(Direction.WEST, new Door("Comp Sci Room"));
        this.getDoors().put(Direction.NORTH, new Door("Hallway 4"));
        this.getDoors().put(Direction.SOUTH, new Door("Hallway 6"));
        this.description = "The Comp Sci Room is to the west, and the hallway continues to the south and north.";
    }

    public boolean captureInput(VerbPhrase v, Context c) {
        return Game.GO_TO_NEXT;
    }
}
