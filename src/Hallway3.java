import tbge.*;

/**
 * Created by lynds on 6/1/2017.
 */
public class Hallway3 extends Area {
    public Hallway3(){
        super("Hallway 3");
        this.getDoors().put(Direction.WEST, new Door("Secret Passage", "SecretPassageKey"));
        this.getDoors().put(Direction.NORTH, new Door("Hallway 2"));
        this.getDoors().put(Direction.SOUTH, new Door("Hallway 4"));
        this.description = "There is a door off the hallway to the west. It appears to be locked...";
        this.getLocalActions().put(new VerbPhrase("unlock", "door"), this::unlockDoor);
    }

    public boolean unlockDoor(Context c){
        if(c.getPlayer().getInventory().contains("SecretPassageKey")){
            this.getDoors().get(Direction.WEST).unlock("SecretPassageKey");
            System.out.println("You unlocked the door!");
            description = "There is a door off the hallway to the west.";
        }else{
            System.out.println("You don't have the key!");
        }
        return !Game.GO_TO_NEXT;
    }

    public boolean captureInput(VerbPhrase v, Context c) {
        if(c.getPlayer().getInventory().contains("SPKey")){
            description+= "But you have a key that might just fit into the lock!";
        }
        return Game.GO_TO_NEXT;
    }
}
