package items;

import core.*;

public class LaserPointer extends Item {
    public LaserPointer(){
        super();
        this.usage().take(Usage.Take.TAKABLE);
        this.name("Laser Pointer")
            .synonym("laser", "pointer", "laserpionter");
    }

    @Override
    public void interact(final Command command, final Context context) {

    }
}
