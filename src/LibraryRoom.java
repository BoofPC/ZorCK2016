import tbge.*;

/**
 * Created by guerrer4154c on 6/5/2017.
 */
public class LibraryRoom extends Area {
    private String laterDescription = "Aisles filled with book stand next to comfy couches. A laptop lies on a table.";
    private String itemDescription = "Booth's laptop lies on a table, you should get it to him.";
    private boolean takeLaptop = false;

    public LibraryRoom(){
        super("Library");
        this.description = "Immediately the smell of books surrounds you." +
                "\nYou’ve entered the library, in the distance there’s a table with a laptop on it";
        this.getDoors().put(Direction.NORTH,new Door("Secret Passage"));
        this.getInventory().add("laptop");

        this.getLocalActions().put(new VerbPhrase("description"), (c)->{
            System.out.println(description);
            if(!takeLaptop){
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
