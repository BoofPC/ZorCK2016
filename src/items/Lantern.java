package items;

import core.*;

public class Lantern extends Item{

    public Lantern(){
        super();
        this.usage().take(Usage.Take.TAKABLE).active(Usage.Active.OFF);
        this.name("Lantern")
            .synonym("lantern")
            .synonym("light")
            .synonym("flashlight");

    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
