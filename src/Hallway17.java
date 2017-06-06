import tbge.*;

/**
 * Created by guerrer4154c on 6/6/2017.
 */
public class Hallway17 extends Area {
    public Hallway17(){
        super("Hallway17");
        this.getDoors().put(Direction.EAST, new Door("Hallway16"));
        this.getDoors().put(Direction.NORTH, new Door("Fisher's Room"));
        this.description = "Students are huddled together on the stairs that lead to the lower floors, perhaps you"
                +"\nshould leave them alone. Fisher's room is to the north of here, how about checking it out?";
    }
    public boolean captureInput(VerbPhrase v, Context c){
        return Game.GO_TO_NEXT;
    }
}
