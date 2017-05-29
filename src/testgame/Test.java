package testgame;

import core.*;

import java.util.Scanner;

public class Test extends Game{
    public Test(){
        super("Booth", new MyWorld(), new Dictionary());
    }

    public boolean captureInput(VerbPhrase v, Context c){
        super.captureInput(v,c);
        if(v.getVerb().equals("run") && c.getPlayer().getInventory().contains("scissors")){
            System.out.println("You fall on your scissors and die as your spleen is impaled by them."
                    +" I told you those were sharp but you wouldn't listen! Now you're dead and YOU LOSE!");
            c.getGame().quit();
        }
        return !Game.GO_TO_NEXT;
    }


    public static void main(String[] args){
        Test game = new Test();
        game.start();
    }


}
