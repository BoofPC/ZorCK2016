import tbge.*;

/**
 * Created by guerrer4154c on 5/31/2017.
 */

//TODO add talking to Ms. Fisher and giving Ms. Fisher coffee
public class FisherRoom extends Area{
    private String laterDescription = "History posters are all around on the walls. Ms. Fisher is frantically looking for some coffee.";
    private String itemDescription = "A lantern sits on a desk, perhaps it can light your way.";
    private boolean takeLantern = false;

    public FisherRoom(){
        super("Fisher's Room");

        this.description = "You enter the room. The class is empty with the exception of Ms. Fisher";

        this.getDoors().put(Direction.SOUTH,new Door("Hallway 17"));

        this.getInventory().add("lantern");

        this.getLocalActions().put(new VerbPhrase("description"), (c)->{
            System.out.println(description);
            if(!takeLantern){
                description = laterDescription + itemDescription;
            } else {
                description = laterDescription;
            }
            return !Game.GO_TO_NEXT;
        });
        }

        public boolean captureInput(VerbPhrase v, Context c){
            return Game.GO_TO_NEXT;
        }
    }


