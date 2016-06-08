package items;
import core.*;
/**
 *
 * @author Bailee
 */
public class Microwave extends Item {

    public Microwave() {
        super();

        //can examine but cannot use

        this.name("Microwave")
            .synonym("microwave")
            .examine("There is a steaming HotPocket still in this microwave."
                    + "It's probably a Staff Member's so you better not move it.")
            .smell("It smells like a ham and cheese HotPocket.");
    }
}
