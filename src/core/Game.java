package core;

import java.util.Scanner;

/**
 * Created by Alex on 5/24/17.
 */
public abstract class Game {
    public static final boolean GO_TO_NEXT = true;

    private Context c;
    private boolean playing;
    private Scanner console;
    private Interpretable dictionary;
    private Interpreter interpreter;
    private int turn;

    public void updateContext(Context c){
        this.c = c;
    }

    public Game(String playerName, World world, Interpretable dictionary) {
        this.c = new Context(new Player(playerName), world, this);
        this.playing = true;
        this.console = new Scanner(System.in);
        this.dictionary = dictionary;
        this.interpreter = new Interpreter(dictionary);
        this.turn = 1;
    }

    public void start(){
        while(playing){
            System.out.println(c.getWorld().getCurrentArea().getName());
            System.out.print("["+turn+"]> ");
            turn++;
            String input = console.nextLine();
            VerbPhrase v = interpreter.interpret(input);
            boolean next = true;
            if(v == null) continue;
            if(v.getVerb().equals("WAT")){
                System.out.println("I don't understand--can you say that another way?");
                System.out.println();
                continue;
            }
            if(next) {
                next = c.getWorld().getCurrentArea().captureInput(v, c);
            }
            if (next && c.getWorld().getCurrentArea().getLocalActions().get(v) != null) {
                next = c.getWorld().getCurrentArea().getLocalActions().get(v).apply(c);
            }
            if(next && v.getType() == VerbPhrase.VerbType.MOVE){
                if(c.getWorld().getCurrentArea().getDoors().get(v.getDirection()) != null){
                    next = c.getWorld().getCurrentArea().captureInput(v, c);
                    if (next && c.getWorld().getCurrentArea().getLocalActions().get(v) != null) {
                        next = c.getWorld().getCurrentArea().getLocalActions().get(v).apply(c);
                    }
                    c.getWorld().move(v.getDirection());
                }else{
                    System.out.println("You can't move that direction.");
                    next = false;
                }
            }else {
                if(next) {
                    next = captureInput(v, c);
                }
                if (next && c.getGlobalActions().get(v) != null) {
                    next = c.getGlobalActions().get(v).apply(c);
                }
            }
            System.out.println();
        }
    }

    public boolean captureInput(VerbPhrase v, Context c) {

        if (v.equals(new VerbPhrase("quit"))) {
            this.quit();
            return !GO_TO_NEXT;
        } else if (v.equals(new VerbPhrase("get", "inventory"))
                || v.equals(new VerbPhrase("print", "inventory"))
                || v.equals(new VerbPhrase("inventory"))) {
            System.out.println();
            System.out.println("Your inventory:");
            for (String s : c.getPlayer().getInventory()) {
                System.out.println(s);
            }
            System.out.println();
            return !GO_TO_NEXT;
        } else if (v.getVerb().equals("take")) {
            if (c.getWorld().getCurrentArea().getInventory().contains(v.getDirectObject())) {
                int ndx = c.getWorld().getCurrentArea().getInventory().indexOf(v.getDirectObject());
                c.getPlayer().getInventory().add(c.getWorld().getCurrentArea().getInventory().remove(ndx));
                System.out.println(v.getDirectObject() + " was added to your inventory.");
            } else {
                System.out.println("There's no " + v.getDirectObject() + " you can take!");
            }
        } else if (v.equals(new VerbPhrase("look", "around")) || v.equals(new VerbPhrase("description"))) {
            System.out.println(c.getWorld().getCurrentArea().description);
        } else if (v.getVerb().equals("give")) {
            if (c.getPlayer().getInventory().contains(v.getDirectObject())
                    || c.getPlayer().getInventory().contains(v.getIndirectObject())) {
                System.out.println("You can't give that away!");
            } else {
                System.out.println("You don't have anything like that to give!");
            }
        }else if(v.getVerb().equalsIgnoreCase("help")){
            System.out.println();
            System.out.println("You can type:");
            System.out.println("'help' to print this list");
            System.out.println("'inventory' to print the items in your inventory");
            System.out.println("'description' to print a description of the room you are currently in");
            System.out.println("'quit' to quit the game");
            System.out.println("'go' or 'move' plus any direction on the compass or up or down to move to the area in that direction");
            System.out.println("Or any phrase in the form VERB DIRECT_OBJECT INDIRECT_OBJECT");
        }else{
            System.out.println("You can't do that here.");
        }

        return GO_TO_NEXT;
    }

    public void quit(){
        this.playing = false;
    }
}
