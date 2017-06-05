import tbge.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lynds on 6/5/2017.
 */
public class BoothRoom extends Area {
    private List<String> BoothsInventory;

    public BoothRoom(){
        super("Booth's Room");
        this.getDoors().put(Direction.EAST, new Door("Hallway 2"));
        this.description.equals("You see various physics and robotics posters on the wall. On a table there is a stack of " +
                "\nPhysics Textbooks. In the corner sits Mr. Booth eating a snack and listening to music.");
        this.getLocalActions().put(new VerbPhrase("read", "textbook"), this::readTextbook);
        this.BoothsInventory = new ArrayList<>();
        this.getInventory().add("pen");
    }

    public boolean readTextbook(Context c){
        System.out.println("IKJ!");
        if(!c.getState().contains("read_textbook")){
            c.getState().add("read_textbook");
            ((ZorCK)(c.getGame())).addPoints(10);
        }
        return !Game.GO_TO_NEXT;
    }

    //TODO fix giving red pen away
    public boolean captureInput(VerbPhrase v, Context c){
        if(v.getVerb().equals("give")){
            if(v.getDirectObject().equals("red pen")){
                if(c.getPlayer().getInventory().remove("red pen")){
                    System.out.println("You gave Mr. Booth the red pen!");
                    BoothsInventory.add("red pen");
                }
            }
        }
        return Game.GO_TO_NEXT;
    }
}
