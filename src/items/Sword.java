package items;

import core.*;

public class Sword extends Item{

    public Sword(){
        super();
        this.usage().take(Usage.Take.TAKABLE);
        this.name("Elvish Sword");
        this.synonym("elvish sword");
        this.synonym("sword");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
