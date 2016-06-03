package items;

import core.*;

public class EagleOfBlessing extends Item{
    public EagleOfBlessing(){
        super();
        this.usage().take(Item.TAKABLE);
        this.name("Eagle")
            .synonym("Eagleofblessing")
            .synonym("Eagle of blessing")
            .synonym("Eaglet")
            .synonym("Amurica")
            .synonym("America");
    
    }

    @Override
    public void interact(final Command command, final Context context){
        if(command.getVerb().getTitle().equals("take")) {
            System.out.println("Wow this is a rare case when a bird in a dungeon helps you just dont go a fowl");
            context.getPlayer().addHp(5);
        }
    }

}