import tbge.*;

/**
 * Created by guerrer4154c on 5/31/2017.
 */

//TODO add talking to Ms. Fisher and giving Ms. Fisher coffee
public class FisherRoom extends Area{
    private String laterDescription = "History posters are all around on the walls. Ms. Fisher is frantically looking for some coffee.";
    private String itemDescription = "A lantern sits on a desk, perhaps it can light your way.";
    private boolean takeLantern = false;

    public FisherRoom(){
        super("Fisher's Room");

        this.description = "A small classroom with posters lining the walls. Ms. Fisher is grading papers at her desk."
                + "\nShe seems to be falling asleep. Maybe she could use some coffee. There is a lantern on her desk."
                + "\nIt could be helpful to light up dark rooms.";

        this.getDoors().put(Direction.SOUTH,new Door("Hallway 17"));

        this.getInventory().add("lantern");
        
        this.getLocalActions().put(new VerbPhrase("take", "lantern"), (c)->{
            if(this.getInventory().contains("lantern")){
                System.out.println("You got the lantern. You can use it to light up dark rooms.");
                c.getPlayer().getInventory().add("lantern");
                this.getInventory().remove("lantern");
            }
            return !Game.GO_TO_NEXT;
            });

        this.getLocalActions().put(new VerbPhrase("description"), (c)->{
            System.out.println(description);
            if(!takeLantern){
                description = laterDescription + itemDescription;
            } else {
                description = laterDescription;
            }
            return !Game.GO_TO_NEXT;
        });
        
        this.getLocalActions().put(new VerbPhrase("look"), (c)->{
            System.out.println(description);
            if(!takeLantern){
                description = laterDescription + itemDescription;
            } else {
                description = laterDescription;
            }
            return !Game.GO_TO_NEXT;
        });
        
        this.getLocalActions().put(new VerbPhrase("give", "coffee", "Ms.Fisher"), (c)->{
        if(c.getPlayer().getInventory().remove("coffee")){
            System.out.println("Thank you for the coffee. I really needed it to be active this morning.");
            c.getState().add("fisher_got_coffee");
            ((ZorCK)c.getGame()).addPoints(10);
        }else{
            System.out.println("You don't even have any coffee.");
        }
        return !Game.GO_TO_NEXT;
        });
        
        this.getLocalActions().put(new VerbPhrase("give", "coffee", "Fisher"), (c)->{
        if(c.getPlayer().getInventory().remove("coffee")){
            System.out.println("Thank you for the coffee. I really needed it to be active this morning.");
            c.getState().add("fisher_got_coffee");
            ((ZorCK)c.getGame()).addPoints(10);
        }else{
            System.out.println("You don't even have any coffee.");
        }
        return !Game.GO_TO_NEXT;
        });
        
        this.getLocalActions().put(new VerbPhrase("talk", "Fisher"), (c)->{
        if(!c.getState().contains("fisher_got_coffee")){
            System.out.println("Hello! I would talk to you, but I would really like some coffee first...");
        }else{
            System.out.println("Thank you so much for the coffee!");
        }
        return !Game.GO_TO_NEXT;
        });
        
        this.getLocalActions().put(new VerbPhrase("talk", "Ms.Fisher"), (c)->{
        if(!c.getState().contains("fisher_got_coffee")){
            System.out.println("Hello! I would talk to you, but I would really like some coffee first...");
        }else{
            System.out.println("Thank you so much for the coffee!");
        }
        return !Game.GO_TO_NEXT;
        });
        
        }

        public boolean captureInput(VerbPhrase v, Context c){
            return Game.GO_TO_NEXT;
        }
    }


