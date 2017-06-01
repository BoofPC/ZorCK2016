import tbge.Area;
import tbge.Context;
import tbge.Game;
import tbge.VerbPhrase;

/**
 * Created by lynds on 5/31/2017.
 */
public class CSRoom extends Area {

    public CSRoom(){
        super ("Comp Sci Room");
        this.description = "You wake up in the comp sci lab, and you realize that you only have a couple " +
                "\nof hours before school ends. On the ground there is a note, and all the computers appear to be broken.";    }

    public boolean captureInput(VerbPhrase v, Context c){
        return Game.GO_TO_NEXT;
    }
}
