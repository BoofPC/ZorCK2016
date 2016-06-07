package items;

import core.*;

public class BoothBust extends Item {

    public BoothBust() {
        super();

        //cannot pick up

        this.name("Booth Bust")
            .synonym("booth bust", "bust", "statue", "bust of booth")
            .description("It's a well-made bronze likeness of Mr. Booth.");
    }
}
