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
                continue;
            }
            next = captureInput(v, c);
            if (next && c.getGlobalActions().get(v) != null) {
                next = c.getGlobalActions().get(v).apply(c);
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
                    next = c.getWorld().getCurrentArea().captureInput(v, c);
                }
                if (next && c.getWorld().getCurrentArea().getLocalActions().get(v) != null) {
                    next = c.getWorld().getCurrentArea().getLocalActions().get(v).apply(c);
                }
            }
        }
    }

    public boolean captureInput(VerbPhrase v, Context c){
        return true;
    }

    public void quit(){
        this.playing = false;
    }
}
