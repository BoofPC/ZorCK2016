package items;

import core.*;

public class DuckOfDoom extends Item {
    public DuckOfDoom() {
        super();
        this.usage().take(Item.TAKABLE);
        this.name("Duck").synonym("duck", "duckofdoom", "duck of doom", "duckling", "duckery",
                "mallard", "loon");
    }

    @Override
    public void interact(final Command command, final Context context) {
        if (command.getVerb().getTitle().equals("take")) {
            System.out.println("You should know better than to pick up a duck in a dungeon!");
            context.getPlayer().addHp(-5);
        }
    }

}
