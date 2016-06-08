package items;

import core.*;

/**
 *
 * @author Bailee
 */
public class VendingMachine extends Item {
    
    public VendingMachine() {
        super();
        
        this.name("Vending Machine")
                .synonym("oldvendingmachine", "old vending machine", "vending machine",
                    "vendingmachine")
                .examine("I wonder if the soda is really 50 cents?");
    }
    

}
