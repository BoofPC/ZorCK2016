package areas;

import core.*;
import items.*;

public class Hallway10 extends Area<NoState> {
    public Hallway10(final World containingWorld) {
        super(containingWorld);

        this.portals().south(new Portal(false, AdamsonsRoom.class))
                .west(new Portal(false, Hallway11.class)).east(new Portal(false, Hallway09.class));
        this.title("Hallway")
                .description("To the south there are glass double doors that "
                        + "lead too to Mr. Adamsons room with multiple posters that "
                        + "exclaim \"SkillsUSA Meeting on THURSDAY!\"\n Everything "
                        + "seems to be based off technology for some reason.... \n"
                        + "This must be the main CTE classroom. To the north there "
                        + "is a door to the KUGR room where the broadcast is "
                        + "produced live every friday. \nHallways continue to the east"
                        + " and to the west.")
                .shortDescription("There are doors to the north and south and hallways to"
                        + " the east and west.")
                .articleThe(true).smell("This hallway smells just like fresh laser engraved wood!")
                .sound("You can hear the industrial 3D printer and numerous computers"
                        + " from here.")
                .item(new Door(true, "Southern Door", null, this.portals().south()));
    }
}
