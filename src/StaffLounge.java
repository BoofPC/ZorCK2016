import tbge.*;

/**
 * Created by guerrer4154c on 6/6/2017.
 */
public class StaffLounge extends Area {
    public StaffLounge(){
        super("Staff Lounge");
        this.getDoors().put(Direction.NORTH,new Door("Hallway 14"));
        this.description = "Dim lighting makes it nearly impossible for you to see in the room.";
    }

    public boolean captureInput(VerbPhrase v, Context c){
        return Game.GO_TO_NEXT;
    }
}
