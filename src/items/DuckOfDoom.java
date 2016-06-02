package items;

import core.*;

public class DuckOfDoom extends Item{
    public DuckOfDoom(){
        super();
        setUsageKey(Item.TAKE,1);
        setUsageKey(Item.EAT,1);
        setName("Duck");
        addSynonym("duck");
        addSynonym("duckofdoom");
        addSynonym("duck of doom");
        addSynonym("duckling");
        addSynonym("duckery");
        addSynonym("mallard");
        addSynonym("loon");
    }
    
    @Override
    public void interact(Command command, Context context){
        if(command.getVerb().getTitle().equals("take")) {
            System.out.println("You should know better than to pick up a duck in a dungeon!");
            context.getPlayer().addHp(-5);
        }
    }
    
}
