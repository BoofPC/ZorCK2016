package items;

import core.*;

public class FluxCapacitor extends Item{

    public FluxCapacitor(){
        super();
        this.usage().take(Usage.Take.TAKABLE);
        this.setName("Flux Capacitor");
        this.addSynonym("flux capacitor");
        this.setDescription("This is one of the parts of the time"
                + " machine!");

    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
