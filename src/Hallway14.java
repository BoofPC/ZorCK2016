import tbge.*;

/**
 * Created by guerrer4154c on 6/6/2017.
 */
public class Hallway14 extends Area {
    public Hallway14(){
        super("Hallway14");
        this.getDoors().put(Direction.SOUTH, new Door("Staff Lounge", "Staff Lounge Key"));
        this.getDoors().put(Direction.EAST, new Door("Hallway12"));
        this.getDoors().put(Direction.WEST, new Door("Hallway15"));
        this.getDoors().put(Direction.NORTH, new Door ("Men's Restroom"));
    }
    public boolean unlockDoor(Context c){
        if(c.getPlayer().getInventory().contains("Staff Lounge Key")){
            this.getDoors().get(Direction.SOUTH).unlock("Staff Lounge");
            System.out.println("You unlocked the door!");
            description = "There is a door off the hallway to the south.";
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
