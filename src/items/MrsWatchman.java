package items;

import core.*;
import verbs.*;

public class MrsWatchman extends Item {

    public MrsWatchman() {
        super();
        this.name("Mrs.Watchman")
                .look("Mrs.Watchman is at the door to the compsci room.")
                .synonym("Mrs.watchman", "mrs.Watchman", "mrs.watchman", "Watchman", "watchman");
    }

    @Override
    public boolean interact(final Command command, final Context context) {
        final Verb verb = command.getVerb();
        final Player player = context.getPlayer();
        final Item key = player.getItem(Key.SecretPassage.class);
        if (verb.getClass().equals(Talk.class)) {
            if (key == null) {
                System.out.println("Can you find me the key to the secret passage to the compsci room. If you do i will give you some interesting information on Mr.Booth ");
                return true;
            } else {
                System.out.println("You found the key. Thank you, and here is the information I promise");
                context.getPlayer().removeItem(key);
                context.getPlayer().addItem(new IncriminatingEvidence());
                return true;
            }
        }
        return false;
    }
}
