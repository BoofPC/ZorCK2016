import tbge.*;

/**
 * Created by guerrer4154c on 6/6/2017.
 */

//TODO-> key should be mentioned when a player types look or look around as well...
public class OishiRoom extends Area {
    private String laterDescription = "You enter the room. Oishi is still grading papers.\n";
    private String itemDescription = "You see the staff lounge key on Oishi sensei's desk.\n";
    private boolean takeKey = false;

    public OishiRoom(){
        super("Oishi's Room");
        this.getDoors().put(Direction.SOUTH,new Door("Hallway 15"));
        this.getInventory().add("staffloungekey");

        this.description = "You enter the room. Anime posters and Shodo cover the walls"
        +"\nOishi Sensei is frantically grading papers and speaking very fast on the phone";

        this.getLocalActions().put(new VerbPhrase("description"), (c)->{
            System.out.println(description);
            if(takeKey == false){
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
