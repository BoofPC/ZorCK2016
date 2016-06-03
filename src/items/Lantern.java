package items;

import core.*;

public class Lantern extends Item{

    public Lantern(){
        super();
        this.usage().take(Usage.Take.TAKABLE).active(Usage.Active.OFF);
        this.setName("Lantern");
        this.addSynonym("lantern");
        this.addSynonym("light");
        this.addSynonym("flashlight");

    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
