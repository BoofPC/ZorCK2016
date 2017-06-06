import tbge.*;

/**
 * Created by guerrer4154c on 6/6/2017.
 */
public class Hallway12 extends Area {
    public Hallway12() {
        super("Hallway12");
        this.getDoors().put(Direction.EAST, new Door("Hallway11"));
        this.getDoors().put(Direction.WEST, new Door("Hallway 14"));
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
