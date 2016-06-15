package items;

import core.*;

public class CloggedToilet extends Item {
    private Item contents = new Key.RestroomWindow();

    public CloggedToilet() {
        super();
        this.usage().take(Item.BOLTED_DOWN).plungable(Item.PLUNGABLE);
        this.name("Clogged Toilet")
            .synonym("clogged toilet")
            .synonym("toilet")
            .examine("A clogged toilet");
    }

    @Override
    public boolean interact(final Command command, final Context context) {
        final Verb verb = command.getVerb();
        final Player player = context.getPlayer();

        //verb Plunge checks for plunger in inventory
        if (verb.getTitle().equals("plunge")) {
            if (this.contents != null) {
                player.getCurrentArea().item(this.contents);
                System.out.println("The toilet geysers and shoots out a "
                + this.contents.name());
                this.contents = null;
            } else {
                System.out.println("Nothing happens.");
            }
            return true;
        } else {
            return false;
        }
    }
}
