package items;

import core.*;

/**
 *
 * @author Sonic Duck
 */
public class RecyclingBin extends Item{
    public RecyclingBin(){
        super();
        this.usage().take(Item.TOO_HEAVY);
        this.name("Recycling bin").synonym("bin","recycling bin","the bin","the recycling bin")
        .examine("It's a bin, with recycling in it.")
        .taste("You get a papercut on your tongue.")
        .smell("Smells like paper and Kickstart.")
        .sound("It doesn't seem much for conversation.")
        .inside(new Assignment());
    }
}
