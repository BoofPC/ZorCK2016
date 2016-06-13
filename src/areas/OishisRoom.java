package areas;
import core.*;
import items.*;
import verbs.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Sonic Duck
 */
public class OishisRoom extends Area{
    
    public OishisRoom(World containingWorld){
        super(containingWorld);
        this.portals().south(new Portal(Portal.State.UNLOCKED, Hallway15.class));
        this.title("Oishi's Room");
        this.description("You find yourself in Oishi's room. Papers \n"
                + "in better Japanese than you can speak are strewn all over the \n"
                + "floor seemingly at complete random. Oishi remains in front of a \n"
                + "white board which has so much writing on it, that none of \n"
                + "it remains legible anymore. He seems to be teaching to an \n"
                + "entirely empty room. \n")
            .shortDescription("This is Oishi's room. He remains at the front"
                + "of the room teaching, not noticing your presence. \n")
            .dark(false)
            .smell("Smells like a room that hasn't been cleaned in several days.")
            .taste("Tastes like sushi (that's racist).") //Is this acceptable?
            .sound("Complete silence except Oishi speaking rapidly in Japanese.")
            .item(new RecyclingBin())
            .item(new Desk())
            .item(new Door(false, "Southern Door", null, this.portals().south()));
            
    }
       
    @Override
    public void interact(Command command, Context context){
        final Verb verb = command.getVerb();
        if(verb.getTitle().equals("look")){
            System.out.println(this.shortDescription());
        }
        else{
            final Item noun = command.getNoun();
            if(verb.getTitle().equals("examine") && noun.equals("recycling bin")){
                System.out.println("Oh, hey, look! \n"
                        + "It's your homework assignment. \n");
                context.getPlayer().getItem(RecyclingBin.class)
                        .drop(context.getPlayer().getCurrentArea());
            }
            else if(verb.getTitle().equals("examine") && noun.equals("desk")){
                System.out.println("Don't be selfish, you're not\n"
                        + "the only one who sits here. It's been\n"
                        + "cleaned out.");
            }
            else {
                super.interact(command, context);
            }
        }
    }
}