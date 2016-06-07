package verbs;

import core.*;
import java.util.Arrays;

public class Point extends Verb {
    public Point() {
        super("point",
                Verb.usage().noun()
                ,"aim");
    }

    @Override
    public void run(Command command, Context construct) {
        if(construct.getPlayer().hasItem("Laser Pointer") && command.getNoun().hasMatching("snacks") && construct.getPlayer().getCurrentArea().equals("DuanesRoom")){
            System.out.println("The cat pumps up on the self and knocks over some treats. your eat them.");
            construct.getPlayer().addHp(10);
        }
        else{//will make it work with laser pointer
            System.out.println("It is rude to point!");
        }
    }
}
