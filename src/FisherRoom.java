import tbge.Area;
import tbge.Door;
import tbge.Game;
import tbge.VerbPhrase;

/**
 * Created by guerrer4154c on 5/31/2017.
 */
public class FisherRoom extends Area{
    private String laterDescription = "History posters are all around on the walls. Mrs. Fischer is frantically looking for some coffee.";
    private String itemDescription = "A lantern sits on a desk, perhaps it can light your way.";
    private boolean takeLantern = false;
    public FisherRoom(){
        super("Fisher's Room");
        this.description = "You enter the room. The class is empty with the exception of Mrs. Fischer"+
                "\nPosters depicting politicians and important moments in history are all around on the walls."+
                "\nMrs.Fisher sits at her desk muttering things to herself.";
        this.getDoors().put(Direction.SOUTH,new Door("Hallway17"));
        this.getInventory().add("Lantern");
        this.getLocalActions().put(new VerbPhrase("take","Lantern"),(c)-> {
            description = laterDescription;
            System.out.println("You took the lantern, now you can see your way through the dark hallway");
            if (this.getInventory().remove("Lantern")) {
                c.getPlayer().getInventory().add("Lantern");
                takeLantern = true;
            } else {
                System.out.println("You already took that!");
            }
            return !Game.GO_TO_NEXT;
        });
        this.getLocalActions().put(new VerbPhrase("description"), (c)->{
            System.out.println(description);
            if(takeLantern == false){
                description = laterDescription + itemDescription;
            } else {
                description = laterDescription;
            }
            return !Game.GO_TO_NEXT;
        });
        }
    }


