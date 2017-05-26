package testgame;

import core.*;

import java.util.Scanner;

public class Test extends Game{
    public Test(){
        super("Booth", new MyWorld(), new Dictionary());
    }

    public boolean captureInput(VerbPhrase v, Context c){
        if(v.equals(new VerbPhrase("quit"))) {
            this.quit();
            return !GO_TO_NEXT;
        }

        if(v.equals(new VerbPhrase("get","inventory"))
                || v.equals(new VerbPhrase("print","inventory"))
                || v.equals(new VerbPhrase("inventory"))){
            System.out.println("Your inventory:");
            for (String s : c.getPlayer().getInventory()) {
                System.out.println(s);
            }
            return !GO_TO_NEXT;
        }
        return GO_TO_NEXT;
    }


    public static void main(String[] args){
        Test game = new Test();
        game.start();
    }


}
