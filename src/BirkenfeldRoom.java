import tbge.Area;
import tbge.Context;
import tbge.Game;
import tbge.VerbPhrase;

/**
 * Created by lynds on 6/2/2017.
 */
public class BirkenfeldRoom extends Area {

    public BirkenfeldRoom(){
        super("Birkenfeld's Room");
        this.description = "You shiver as you look around. It’s as if all the air conditioning " +
                "\nin the school goes to this room. Mr. Birkenfeld is at his desk, doing some chemistry calculations " +
                "\non his calculator. In the room you see piles and piles of Mr. Birkenfeld’s packets. On one of the " +
                "\nlab benches, you see some hydrochloric acid.";

        this.getInventory().add("hydrochloric acid");

        this.getLocalActions().put(new VerbPhrase("take", "acid"), this::takeAcid);
        this.getLocalActions().put(new VerbPhrase("take", "hydrochloric", "acid"),this::takeAcid);
        this.getLocalActions().put(new VerbPhrase("talk", "Birkenfeld"), this::talk);
        this.getLocalActions().put(new VerbPhrase("give", "acid"),this::giveAcid);

    }

    public boolean takeAcid(Context c){
        if(this.getInventory().remove("hydrochloric acid")){
            c.getPlayer().getInventory().add("hydrochloric acid");
            description = "Mr. Birkenfeld is still at the desk using his calculator...";
            System.out.println("You took the hydrochloric acid!");
            return !Game.GO_TO_NEXT;
        }else{
            System.out.println("You already took that!");
            return !Game.GO_TO_NEXT;
        }
    }

    public boolean talk(Context c){
        return !Game.GO_TO_NEXT;
    }

    public boolean giveAcid(Context c){
        return !Game.GO_TO_NEXT;
    }
}
