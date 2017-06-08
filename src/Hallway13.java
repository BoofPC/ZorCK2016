import tbge.*;

/**
 * Created by guerrer4154c on 6/6/2017.
 */
public class Hallway13 extends Area {
    public Hallway13(){
        super("Hallway 13");
        this.getDoors().put(Direction.SOUTH, new Door("Hallway 12"));

       //Can either choose to have a locked library or a barricaded library- but you aren't supposed to be able to get
        // to the Library from this hallway

        //this.getDoors().put(Direction.EAST, new Door("Library", "LibraryKey"));
        this.description = "You've reached the end of the hallway! The stairs are blocked, so there is no way downstairs." +
                "\nThe door to the Library appears to be blocked. Maybe you can find a back way in. Or maybe you should just go back " +
                "\nthe way you came.";
    }
    public boolean captureInput(VerbPhrase v, Context c){
        return Game.GO_TO_NEXT;
    }
}
