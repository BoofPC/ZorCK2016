package verbs;

import core.*;

public class Point extends Verb {
    public Point() {
        super("point",
                Verb.usage().noun()
                ,"aim");
    }

    @Override
    public void run(final Command command, final Context construct) {
        if(construct.getPlayer().hasItem("Laser Pointer") && command.getNoun().hasMatching("snacks")){
            System.out.println("The cat jumps up on the self and knocks "
                    + "over some treats. You eat them.");
            construct.getPlayer().addHp(10);
        }
        else{//will make it work with laser pointer
            System.out.println("It is rude to point!");
        }
    }
}
