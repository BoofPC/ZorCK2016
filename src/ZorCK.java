import tbge.Context;
import tbge.Game;
import tbge.VerbPhrase;

import java.util.Random;

/**
 * Created by lynds on 5/31/2017.
 */
public class ZorCK extends Game {

    private int points;
    //private int countdown;

    public ZorCK(){
        super("Player", new MyWorld(), new Dictionary());
        points = 0;
        //countdown = 10;
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

        if(v.equals(new VerbPhrase("type", "comp_sci_is_fun!"))&&c.getPlayer().getInventory().contains("laptop")){
            c.getState().add("laptop_unlocked");
            System.out.println("You unlocked the laptop!");
        }else if(v.equals(new VerbPhrase("drink", "chemical"))&&c.getPlayer().getInventory().contains("chemical")){
            System.out.print("You die!");
            c.getGame().quit();
        }else if(v.equals(new VerbPhrase("look"))){
            System.out.println(c.getWorld().getCurrentArea().description);
        }
        else{
            super.captureInput(v,c);
        }
        return !Game.GO_TO_NEXT;
    }

    public static void main(String[] args){
        ZorCK game = new ZorCK();
        System.out.println("Welcome to\n"
                + "d8888888P                    a88888b. dP     dP\n"
                + "     .d8'                   d8'   `88 88   .d8'\n"
                + "   .d8'   .d8888b. 88d888b. 88        88aaa8P' \n"
                + " .d8'     88'  `88 88'  `88 88        88   `8b.\n"
                + "d8'       88.  .88 88       Y8.   .88 88     88\n"
                + "Y8888888P `88888P' dP        Y88888P' dP     dP\n\n");

        System.out.println("You wake up in the comp sci lab, and you realize that you only have a couple of hours before " +
                "\nschool ends. On the ground there is a note, and all the computers appear to be broken.");
        System.out.println();
        game.start();
    }

}
