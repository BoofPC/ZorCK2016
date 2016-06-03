package items;

import core.*;

public class FluxCapacitor extends Item{

    public FluxCapacitor(){
        super();
        this.setUsageKey(Item.TAKE, 1);
        this.setName("Flux Capacitor");
        this.addSynonym("flux capacitor");
        this.setDescription("This is one of the parts of the time"
                + " machine!");

    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
