package items;

import core.*;

public class PostIt extends Item {

    public PostIt() {
        super();
        this.usage().take(Item.TAKABLE).read(Item.READABLE).food(Item.EDIBLE);
        this.name("Post-it Note")
            .examine("It's a note written by Booth!")
            .synonym("post-it note", "postit note", "note", "postit", "sticky note")
            .read("PASSWORD: #Ch8ngE_M3")
            .taste("Why did you eat a post-it note?!?");
    }

    @Override
    public boolean interact(Command command, Context context) {
        this.read("PASSWORD: " + context.getPassword());
        return false;
    }
}
