import java.util.function.Function;
import tbge.*;

/**
 * Created by guerrer4154c on 6/6/2017.
 */

//TODO this room should still allow the player to move out of the room if they don't have the lantern
public class StaffLounge extends Area {
    private String laterDescription = "The light that you have makes it possible to see into the room. A"
            + "\nbroken copy machine rests in the corner of the room, the school should probably get a"
            + "\nnew one. Next to it is a recycling bin that is filled to the brim with old papers, most of them"
            + "\nare probably assignments that students turned in without putting their name on them. You"
            + "\nknow how frustrating that is for teachers. There is a table in the center of the room with a"
            + "\ncoffee cup on it, maybe someone left it here.";
    private String laterLaterDescription = "A small room that has an overflowing recycling bin, where teachers take a break."
            + "\nIt smells of coffee.";
    private boolean trash = false;
    public StaffLounge(){
        super("Staff Lounge");
        this.getDoors().put(Direction.NORTH,new Door("Hallway 14"));
        this.description = "Dim lighting makes it nearly impossible for you to see in the room.";
        this.getInventory().add("coffee");
        
        
        this.getLocalActions().put(new VerbPhrase("use","lantern"), (c)->{
            if(c.getPlayer().getInventory().contains("lantern")){
            System.out.println("You turn on the lantern! Now you can see!");
            System.out.println(description = laterDescription);
            this.description = laterLaterDescription;
            c.getState().add("lantern_on");
            }
            return !Game.GO_TO_NEXT;
            });
        
        this.getLocalActions().put(new VerbPhrase("take","coffee"), (c)->{
            if(this.getInventory().contains("coffee")){
            ((ZorCK)(c.getGame())).addPoints(10);
            c.getPlayer().getInventory().add("coffee");
            this.getInventory().remove("coffee");
            System.out.println("You take the coffee. The cup feels warm to the touch.");
            }
            return !Game.GO_TO_NEXT;
        });
        
        this.getLocalActions().put(new VerbPhrase("search", "recycle"), (c)->{
            if(trash == false){
            System.out.println("Hey, you found an old assignment. Mr. Booth needed that, right?");
            c.getPlayer().getInventory().add("assignment");
            ((ZorCK)(c.getGame())).addPoints(10);
            trash = true;
            } else {
                System.out.println("You already searched the recycle bin...");
            }
            return !Game.GO_TO_NEXT;
        });
        
    }
    
    @Override
    public boolean captureInput(VerbPhrase v,Context c){
        if(c.getState().contains("lantern_on") || v.getDirection() != Area.Direction.NODIRECTION){
            return Game.GO_TO_NEXT;
        }else if(!(v.equals(new VerbPhrase("use","lantern")))
                && !c.getState().contains("lantern_on")){
            System.out.println(description);
            return !Game.GO_TO_NEXT;
        } else {
        return Game.GO_TO_NEXT;
        }
    }
}
