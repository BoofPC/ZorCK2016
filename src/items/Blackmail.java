package items;

import core.*;

/**
 *
 * @author dayley3391b
 */
public class Blackmail extends Item {

    public Blackmail() {
        super();
        this.usage().take(Item.TAKABLE);
        this.name("Blackmail")
                .description("It's a note from an unknown author...")
                .synonym("mail");
    }
    @Override
    public void interact(final Command command, final Context context){

    }
}