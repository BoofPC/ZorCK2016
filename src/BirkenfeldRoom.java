import tbge.*;

/**
 * Created by lynds on 6/2/2017.
 */
public class BirkenfeldRoom extends Area {

    public BirkenfeldRoom(){
        super("Birkenfeld's Room");

        this.getDoors().put(Direction.SOUTHEAST, new Door("Hallway 1"));

        this.description = "You shiver as you look around. It’s as if all the air conditioning " +
                "\nin the school goes to this room. Mr. Birkenfeld is at his desk, doing some chemistry calculations " +
                "\non his calculator. In the room you see piles and piles of Mr. Birkenfeld’s packets. On one of the " +
                "\nlab benches, you see a chemical.";

        this.getInventory().add("chemical");


        this.getLocalActions().put(new VerbPhrase("take", "chemical"), this::takeChemical);
        this.getLocalActions().put(new VerbPhrase("talk", "Birkenfeld"), this::talk);
        this.getLocalActions().put(new VerbPhrase("talk", "Mr.Birkenfeld"), this::talk);
        this.getLocalActions().put(new VerbPhrase("give", "chemical", "Mr.Birkenfeld"),this::giveChemical);
        this.getLocalActions().put(new VerbPhrase("give", "chemical", "Birkenfeld"),this::giveChemical);

    }

    public boolean takeChemical(Context c){
        if(this.getInventory().remove("chemical")){
            c.getPlayer().getInventory().add("chemical");
            description = "Mr. Birkenfeld is still at the desk using his calculator...";
            System.out.println("You took the chemical!");
            return !Game.GO_TO_NEXT;
        }else{
            System.out.println("You already took that!");
            return !Game.GO_TO_NEXT;
        }
    }

    public boolean talk(Context c){
        if(!c.getState().contains("birkenfeld_gave_calculator")){
            System.out.println("Hello! What’s that? … You want my calculator? Well you will have to trade me something for it…");
        }else{
            System.out.println("You are such a bright young scholar!");
        }
        return !Game.GO_TO_NEXT;
    }

    public boolean giveChemical(Context c){
        if(c.getPlayer().getInventory().remove("chemical")){
            c.getPlayer().getInventory().add("calculator");
            System.out.println("Oh thank you for reminding me, I need to test that lab… Here take this calculator.");
            c.getState().add("birkenfeld_gave_calculator");
        }else{
            System.out.println("You don't even have a chemical.");
        }
        return !Game.GO_TO_NEXT;
    }

    public boolean captureInput(VerbPhrase v, Context c){
        return Game.GO_TO_NEXT;
    }
}
