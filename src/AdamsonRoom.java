import tbge.Area;
import tbge.Door;
import tbge.Game;
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
    private String laterDescription = "A fairly large room filled with tables covered with computers.";
    private String trollDescription = "There is a 3D model of a troll blocking the door to the west.";
    private String noteDescription = "There is a Post-It Note on the desk.";
    private boolean noteRead = false;
    private boolean trollKilled = false;
    
    public AdamsonRoom(){
        super("Adamson's Room");
        this.getDoors().put(Direction.NORTH,new Door("Hallway10"));
        this.getDoors().put(Direction.WEST,new Door("Broadcasting"));
        this.getInventory().add("Note");
        this.getInventory().add("Troll");
        
        this.description = "Banners hang from the ceiling proclaiming the accomplishments of Students."
                + " In the middle of the room lay 5 rows of highly advanced computers that are too complex"
                + " for your simple mind to use. There seems to be a 3D printed model of a giant troll "
                + "that's blocking the entrance to a door to the west. Wait, a Troll? Someone made "
                + "something that big? It seems that the Troll is made up of smaller parts glued together. If "
                + "only there was someway you could cut it into smaller pieces as it is too heavy to move. "
                + "Anyways there is a Post-It Note on the desk, may as well read it.";
        
        this.getLocalActions().put(new VerbPhrase("description"), (c)->{
            System.out.println(description);
            description = laterDescription;
            if(noteRead == true){
                description += noteDescription;
            }
            if(trollKilled == true){
                description += trollDescription;
            }
            return !Game.GO_TO_NEXT;
        });
        
        
    }
}
