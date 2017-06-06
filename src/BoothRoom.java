import com.sun.org.apache.xerces.internal.xs.StringList;
import tbge.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by lynds on 6/5/2017.
 */

//TODO add talking to Booth
public class BoothRoom extends Area {
    private List<String> BoothsInventory;

    public BoothRoom(){
        super("Booth's Room");
        this.getDoors().put(Direction.EAST, new Door("Hallway 2"));
        this.description = "You see various physics and robotics posters on the wall. On a table there is a stack of " +
                "\nPhysics Textbooks. In the corner sits Mr. Booth eating a snack and listening to music.";
        this.getLocalActions().put(new VerbPhrase("read", "textbook"), this::readTextbook);
        this.getLocalActions().put(new VerbPhrase("give","pen", "Mr.Booth"), this::givePen);
        this.getLocalActions().put(new VerbPhrase("give", "red_pen", "Mr.Booth"), this::givePen);
        this.getLocalActions().put(new VerbPhrase("give", "calculator", "Mr.Booth"),this::giveCalc);
        this.getLocalActions().put(new VerbPhrase("give", "assignment", "Mr.Booth"),this::giveAssignment);
        this.getLocalActions().put(new VerbPhrase("give", "laptop", "Mr.Booth"),this::giveLaptop);
        this.getLocalActions().put(new VerbPhrase("talk", "Mr.Booth"), this::talkBoof);
        this.BoothsInventory = new ArrayList<>();
    }

    public boolean talkBoof(Context c){
        if(!c.getState().contains("instructions_given")){
            System.out.println("Hey! If you want me to grade your assignment, I need the following things:\n" +
                    "    Red pen\n" +
                    "    Calculator\n" +
                    "    Assignment\n" +
                    "    Unlocked Laptop\n" +
                    "I think you can find a red pen in the Broadcasting room.");
            c.getState().add("instructions_given");
        }else{
            System.out.println("I still need the following items to grade:");
            if(!BoothsInventory.contains("pen")){
                System.out.println("    Red pen");
            }
            if(!BoothsInventory.contains("calculator")){
                System.out.println("    Calculator");
            }
            if(!BoothsInventory.contains("assignment")){
                System.out.println("    Assignment");
            }
            if(!BoothsInventory.contains("laptop")){
                System.out.println("    Laptop");
            }
        }
        return !Game.GO_TO_NEXT;
    }

    public boolean readTextbook(Context c){
        System.out.println("IKJ!");
        if(!c.getState().contains("read_textbook")){
            c.getState().add("read_textbook");
            ((ZorCK)(c.getGame())).addPoints(10);
        }
        return !Game.GO_TO_NEXT;
    }

    public boolean givePen(Context c){
        if(c.getPlayer().getInventory().remove("pen")){
            this.BoothsInventory.add("pen");
            System.out.println("You gave Booth the red pen!");
            win(c);
        }else{
            System.out.println("You don't have a pen to give!");
        }
        return !Game.GO_TO_NEXT;
    }

    public boolean giveCalc(Context c){
        if(c.getPlayer().getInventory().remove("calculator")){
            this.BoothsInventory.add("calculator");
            System.out.println("You gave Mr.Booth the calculator!");
            win(c);
        }else{
            System.out.println("You don't have a calculator to give!");
        }
        return !Game.GO_TO_NEXT;
    }

    public boolean giveAssignment(Context c){
        if(c.getPlayer().getInventory().remove("assignment")){
            this.BoothsInventory.add("assignment");
            System.out.println("You gave Booth your assignment");
            win(c);
        }else{
            System.out.println("You don't have an assignment to give!");
        }
        return !Game.GO_TO_NEXT;
    }

    public boolean giveLaptop(Context c){
        if(c.getState().contains("laptop_unlocked")&&c.getPlayer().getInventory().remove("Laptop")){
            this.BoothsInventory.add("Laptop");
            System.out.println("You gave Booth the laptop!");
            win(c);
        }else if(c.getPlayer().getInventory().contains("Laptop")){
            System.out.println("You must unlock the laptop before you give it to me!");
        }else{
            System.out.println("You don't have the laptop!");
        }
        return !Game.GO_TO_NEXT;
    }

    public void win(Context c){
        if(BoothsInventory.contains("calculator")&&BoothsInventory.contains("assignment")&&BoothsInventory.contains("pen")
                &&BoothsInventory.contains("Laptop")){
            System.out.println();
            System.out.println("Mr. Booth has everything he needs to grade! He grades your assignment- you got 99%..." +
                    "\nguess you were missing a semicolon... Whoops.");
            System.out.println("You won! Your score was: " + ((ZorCK)c.getGame()).getPoints());
            c.getGame().quit();
        }
    }

    public boolean captureInput(VerbPhrase v, Context c){
        return Game.GO_TO_NEXT;
    }
}
