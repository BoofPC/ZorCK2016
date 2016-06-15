package items;

import core.*;
/**
 *
 * @author coons5457w
 */
public class FitzLunch extends Item{

    private boolean ate;

    public FitzLunch(){
        super();
        this.usage().food(Item.EDIBLE).take(Item.TAKABLE);
        this.name("lunch")
            .synonym("fitzlunch", "mr fitz lunch", "Fitz's lunch", "Mr. Fitz's Lunch",
                    "Mr. Fitz's lunch", "mr fitz's lunch", "fitz's lunch")
            .examine("Fresh salad made from the plants in Mr. Fitz's garden.")
            .taste("Very starchy.")
            .smell("It's scent is balsamic vinegar.")
            .sound("There is no particular sound.");
            this.ate = false;
    }

    @Override
    public boolean interact(final Command command, final Context context){
        if(command.getVerb().getTitle().equals("Eat") &&
            command.getNoun().name().equals("lunch") && !this.ate){
            System.out.println("You ate Mr. Fitz's lunch.");
            System.out.println("Your max HP just went up by 3!");
            context.getPlayer().setMaxHp(context.getPlayer().getMaxHp() + 3);
            context.getPlayer().setHp(context.getPlayer().getHp() + 3);
            context.getPlayer().getCurrentArea().removeItem(command.getNoun());
            this.ate = true;
            return true;
        }
        return false;
    }
}
