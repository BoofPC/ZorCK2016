import tbge.*;

/**
 * Created by lynds on 6/5/2017.
 */
public class SecretPassage extends Area {
    public SecretPassage(){
        super("Secret Passage");
        this.getDoors().put(Direction.EAST, new Door("Hallway 3"));
        this.getDoors().put(Direction.SOUTH, new Door("Library"));
        this.description = "You entered the Teacher’s Secret Passage! The lighting is a little dim, " +
                "but you see a door at the end of the hallway to the south...";
    }

    public boolean captureInput(VerbPhrase v, Context c){
        return Game.GO_TO_NEXT;
    }
}
