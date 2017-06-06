import tbge.*;

/**
 * Created by guerrer4154c on 6/6/2017.
 */
public class Hallway13 extends Area {
    public Hallway13(){
        super("Hallway13");
        this.getDoors().put(Direction.SOUTH, new Door("Hallway12"));
        this.getDoors().put(Direction.EAST, new Door("Library"));
        this.description = "You've reached the end of the hallway! The stairs are blocked, so there is no way downstairs." +
                "\nThere is a door to the Northwest or you can go back the way you came.";
    }
    public boolean captureInput(VerbPhrase v, Context c){
        return Game.GO_TO_NEXT;
    }
}
