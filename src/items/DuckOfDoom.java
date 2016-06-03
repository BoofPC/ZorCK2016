package items;

import core.*;

public class DuckOfDoom extends Item{
    public DuckOfDoom(){
        super();
        this.usage().take(Usage.Take.TAKABLE);
        this.name("Duck");
        this.synonym("duck");
        this.synonym("duckofdoom");
        this.synonym("duck of doom");
        this.synonym("duckling");
        this.synonym("duckery");
        this.synonym("mallard");
        this.synonym("loon");
    }

    @Override
    public void interact(final Command command, final Context context){
        if(command.getVerb().getTitle().equals("take")) {
            System.out.println("You should know better than to pick up a duck in a dungeon!");
            context.getPlayer().addHp(-5);
        }
    }

}
