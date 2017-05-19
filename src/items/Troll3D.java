package items;

import core.*;

public class Troll3D extends Item{
    
    public Troll3D(){
        super();
        this.usage().breakable(Item.BREAKABLE);
        this.examine("A very large 3D model of a hideous troll stands before you.\n"
                + " It's large size makes it impossible to move forward. Perhaps\n"
                + " if you were able to cut it into smaller pieces...");
    }
}
