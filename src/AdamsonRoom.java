import tbge.Area;
import tbge.Context;
import tbge.Door;
import tbge.Game;
import tbge.Player;
import tbge.VerbPhrase;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rodrigu3163b
 */
public class AdamsonRoom extends Area{
    private String laterDescription = "A fairly large room filled with tables covered with computers.\n";
    private String trollDescription = "There is a 3D model of a troll blocking the door to the west.\n";
    private String noteDescription = "There is a Post-It Note on the desk.\n";
    private boolean noteRead = false;
    
    public AdamsonRoom(){
        super("Adamson's Room");
        this.getDoors().put(Direction.NORTH,new Door("Hallway 10"));
        this.getInventory().add("Troll");
        
        this.description = "Banners hang from the ceiling proclaiming the accomplishments of Students."
                + "\nIn the middle of the room lay 5 rows of highly advanced computers that are too complex"
                + "\nfor your simple mind to use. There seems to be a 3D printed model of a giant troll"
                + "\nthat's blocking the entrance to a door to the west. Wait, a Troll? Someone made"
                + "\nsomething that big? It seems that the Troll is made up of smaller parts glued together. If"
                + "\nonly there was someway you could cut it into smaller pieces as it is too heavy to move."
                + "\nAnyways there it a Post-It Note on the desk, may as well read it.";
        
        this.getLocalActions().put(new VerbPhrase("description"), (c)->{
            System.out.println(description);
            description = laterDescription;
            if(noteRead){
                description += noteDescription;
            }
            if(this.getInventory().contains("Troll")){
                description += trollDescription;
            }
            return !Game.GO_TO_NEXT;
        });
        
        this.getLocalActions().put(new VerbPhrase("cut up", "troll"), (c)->{
            if(this.getInventory().contains("Troll") && c.getPlayer().getInventory().contains("Sword")){
                System.out.println("You cut up the troll and move the pieces out of"
                + "/n your path.");
                this.getInventory().remove("Troll");
                this.getDoors().put(Direction.WEST,new Door("Broadcasting Room"));
            } else if(!c.getPlayer().getInventory().contains("Sword")) {
                System.out.println("You need something to cut up the troll with...");
            } else {
                System.out.println("You already cut up the troll...");
            }
            return !Game.GO_TO_NEXT;
        });
        
        this.getLocalActions().put(new VerbPhrase("west"), (c)->{
            if(this.getInventory().contains("Troll")){
                System.out.println("The troll is still in the way..."
                + "\nMaybe you could cut it up into smaller pieces to"
                + "\nmove it.");
            }
            return !Game.GO_TO_NEXT;
        });
        
        this.getLocalActions().put(new VerbPhrase("read", "note"), (c)->{
            noteRead = true;
            System.out.println("The Note Says: 'booth: compsci_is_fun!'");
            return !Game.GO_TO_NEXT;
        });        
    }
        public boolean captureInput(VerbPhrase v, Context c){
        return Game.GO_TO_NEXT;
    }
}
