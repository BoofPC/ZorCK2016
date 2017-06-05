import tbge.Context;
import tbge.Game;
import tbge.VerbPhrase;

/**
 * Created by lynds on 5/31/2017.
 */
public class ZorCK extends Game {

    private int points;
    private int countdown;

    public ZorCK(){
        super("Player", new MyWorld(), new Dictionary());
        points = 0;
        countdown = 10;
    }

    public void addPoints(int points){
        this.points+=points;
    }

    public int getPoints(){
        return this.points;
    }

    public boolean captureInput(VerbPhrase v, Context c){

        /*if(c.getState().contains("tasted_chemical")){
            countdown--;
            if(countdown<=0){
                System.out.println("You die!");
                c.getGame().quit();
            }
            System.out.println("countdown decreased");
        }else if(v.equals(new VerbPhrase("taste", "chemical"))&&c.getPlayer().getInventory().contains("chemical")){
                c.getState().add("tasted_chemical");
                System.out.println("You tasted the chemical... You feel a little funny...");
        }else if(v.equals(new VerbPhrase("taste", "chemical"))){
            System.out.println("You don't have a chemical to taste!");
        }*/

        if(v.equals(new VerbPhrase("drink", "chemical"))&&c.getPlayer().getInventory().contains("chemical")){
            System.out.print("You die!");
            c.getGame().quit();
        }else{
            super.captureInput(v,c);
        }
        return !Game.GO_TO_NEXT;
    }

    public static void main(String[] args){
        ZorCK game = new ZorCK();
        game.start();
    }

}
