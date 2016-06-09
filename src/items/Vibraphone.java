package items;

import core.*;

public class Vibraphone extends Item {

    public Vibraphone() {
        super();
        this.usage().take(Item.TOO_HEAVY);
        this.name("Vibraphone").synonym("vibraphone", "not a marimba", "not a xylophone", "not a glockenspiel", "not a rachel", "not a cat", "not a dog", "not a tree", "not a timpani", "not a snare", "not a drum", "not a bass drum", "not a piano")
                .examine("A very strange looking piano. It has brassy looking bars"
                        + " across the top with tube underneath. There appears to be a"
                        + " motor attached to a flippy thing between the bars and tubes.")
                .inside(new Motor());
    }
}
