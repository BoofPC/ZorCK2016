package items;

import core.*;

public class BoothBust extends Item {

    public BoothBust() {
        super();

        //cannot pick up

        this.setName("Booth Bust");
        this.addSynonym("booth bust");
        this.addSynonym("bust");
        this.addSynonym("statue");
        this.addSynonym("bust of booth");

        this.setDescription("It's a well-made bronze likeness of Mr. Booth.");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
