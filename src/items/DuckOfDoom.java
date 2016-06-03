package items;

import core.*;

public class DuckOfDoom extends Item{
    public DuckOfDoom(){
        super();
        this.setUsageKey(Item.TAKE,1);
        this.setUsageKey(Item.EAT,1);
        this.setName("Duck");
        this.addSynonym("duck");
        this.addSynonym("duckofdoom");
        this.addSynonym("duck of doom");
        this.addSynonym("duckling");
        this.addSynonym("duckery");
        this.addSynonym("mallard");
        this.addSynonym("loon");
    }

    @Override
    public void interact(final Command command, final Context context){
        if(command.getVerb().getTitle().equals("take")) {
            System.out.println("You should know better than to pick up a duck in a dungeon!");
            context.getPlayer().addHp(-5);
        }
    }

}
