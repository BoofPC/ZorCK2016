package items;

import core.*;

public class Sword extends Item{

    public Sword(){
        super();
        this.usage().take(Item.TAKABLE);
        this.name("Elvish Sword")
            .synonym("elvish sword", "sword");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
