import tbge.Context;
import tbge.Game;
import tbge.VerbPhrase;

/**
 * Created by lynds on 5/31/2017.
 */
public class ZorCK extends Game {

    private int points;

    public ZorCK(){
        super("Player", new MyWorld(), new Dictionary());
        points = 0;
    }

    public void addPoints(int points){
        this.points+=points;
    }

    public int getPoints(){
        return this.points;
    }

    public boolean captureInput(VerbPhrase v, Context c){
        super.captureInput(v,c);
        if(v.getVerb().equals("quit")){
            System.out.println("I hope to see you again soon!");
            c.getGame().quit();
        }
        return !Game.GO_TO_NEXT;
    }

    public static void main(String[] args){
        ZorCK game = new ZorCK();
        game.start();
    }

}
