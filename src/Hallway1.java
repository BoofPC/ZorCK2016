import tbge.*;

/**
 * Created by lynds on 6/1/2017.
 */
public class Hallway1 extends Area {
    public Hallway1(){
        super("Hallway 1");
        this.getDoors().put(Direction.SOUTH, new Door("Hallway 2"));
        //this.getDoors().put(Direction.NORTHWEST, new Door("Birkenfeld's Room"));
        this.description = "You've reached the end of the hallway! The stairs are blocked, so there is no way downstairs." +
                "\nThere is a door to the Northwest or you can go back the way you came.";
    }

    public boolean captureInput(VerbPhrase v, Context c){
        return Game.GO_TO_NEXT;
    }
}
