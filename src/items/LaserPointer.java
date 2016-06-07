package items;

import core.*;

public class LaserPointer extends Item {
    public LaserPointer(){
        super();
        this.usage().take(Usage.Take.TAKABLE);
        this.name("Laser Pointer")
                .synonym("laser")
                .synonym("pointer")
                .synonym("laserpionter");
    }

}
