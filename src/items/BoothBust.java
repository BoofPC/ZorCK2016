package items;

import core.*;

public class BoothBust extends Item {

    public BoothBust() {
        super();

        //cannot pick up

        this.name("Booth Bust");
        this.synonym("booth bust");
        this.synonym("bust");
        this.synonym("statue");
        this.synonym("bust of booth");

        this.description("It's a well-made bronze likeness of Mr. Booth.");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
