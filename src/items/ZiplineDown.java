package items;

import core.*;
import areas.*;

public class ZiplineDown extends Item {

    public ZiplineDown() {
        super();
        this.usage().take(Item.BOLTED_DOWN).use(USABLE);
        this.name("Zipline").synonym("zipline")
            .look("There is also a zipline down to the band room.")
            .examine("That zipline looks like fun!");
        this.portal(new Portal(true, LandingPad.class));
    }
}
