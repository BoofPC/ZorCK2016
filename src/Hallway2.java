import tbge.*;

/**
 * Created by lynds on 6/1/2017.
 */
public class Hallway2 extends Area {
    public Hallway2(){
        super("Hallway 2");
        this.getDoors().put(Direction.WEST, new Door("Booth's Room"));
        this.getDoors().put(Direction.SOUTH, new Door("Hallway 3"));
        this.getDoors().put(Direction.NORTH, new Door("Hallway 1"));
        this.description = "There is a door to the west";
    }

    public boolean captureInput(VerbPhrase v, Context c){
        return Game.GO_TO_NEXT;
    }
}
