import tbge.*;

/**
 * Created by guerrer4154c on 6/6/2017.
 */

//TODO add description
public class Hallway14 extends Area {
    public Hallway14(){
        super("Hallway 14");
        this.getDoors().put(Direction.SOUTH, new Door("Staff Lounge", "staffloungekey"));
        this.getDoors().put(Direction.EAST, new Door("Hallway 12"));
        this.getDoors().put(Direction.WEST, new Door("Hallway 15"));

        this.getLocalActions().put(new VerbPhrase("unlock", "door"), this::unlockDoor);
    }
    public boolean unlockDoor(Context c){
        if(c.getPlayer().getInventory().contains("staffloungekey")){
            this.getDoors().get(Direction.SOUTH).unlock("staffloungekey");
            System.out.println("You unlocked the door!");
            description = "There is a door off the hallway to the south.";
        }else{
            System.out.println("You don't have the key!");
        }
        return !Game.GO_TO_NEXT;
        }
    public boolean captureInput(VerbPhrase v, Context c) {
        if(c.getPlayer().getInventory().contains("staffloungekey")){
            description = "But you have a key that might just fit into the lock!";
        }
        return Game.GO_TO_NEXT;
    }
}
