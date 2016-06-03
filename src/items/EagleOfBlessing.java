package items;

import core.*;

public class EagleOfBlessing extends Item{
    public EagleOfBlessing(){
        super();
        this.usage().take(Usage.Take.TAKABLE);
        this.setName("Eagle");
        this.addSynonym("Eagleofblessing");
        this.addSynonym("Eagle of blessing");
        this.addSynonym("Eaglet");
        this.addSynonym("Amurica");
        this.addSynonym("America");
    
    }

    @Override
    public void interact(final Command command, final Context context){
        if(command.getVerb().getTitle().equals("take")) {
            System.out.println("Wow this is a rare case when a bird in a dungeon helps you just dont go a fowl");
            context.getPlayer().addHp(5);
        }
    }

}