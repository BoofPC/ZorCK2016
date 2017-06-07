import tbge.*;

/**
 * Created by guerrer4154c on 6/6/2017.
 */

//TODO change description -> don't necessarily want to mention rooms that don't exist in the game.
public class Hallway12 extends Area {
    public Hallway12() {
        super("Hallway 12");
        this.getDoors().put(Direction.EAST, new Door("Hallway 11"));
        this.getDoors().put(Direction.WEST, new Door("Hallway 14"));
        this.getDoors().put(Direction.NORTH, new Door("Hallway 13"));
        this.description = "A room is to the south, however it seems to be locked. It's labeled"
                + "\n'ASL Romano\". How would you get inside?";
        this.getLocalActions().put(new VerbPhrase("south"), (c) -> {
            System.out.println("The door seems to be locked, maybe there is another way"
                    + "\n to get in...");
            return !Game.GO_TO_NEXT;
        });
    }
        public boolean captureInput(VerbPhrase v, Context c){return Game.GO_TO_NEXT;}
}
