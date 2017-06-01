import tbge.Context;
import tbge.Game;
import tbge.VerbPhrase;

/**
 * Created by lynds on 5/31/2017.
 */
public class ZorCK extends Game {

    public ZorCK(){
        super("Player", new MyWorld(), new Dictionary());
    }

    public boolean captureInput(VerbPhrase v, Context c){
        super.captureInput(v,c);
        return !Game.GO_TO_NEXT;
    }

    public static void main(String[] args){
        ZorCK game = new ZorCK();
        game.start();
    }
}
