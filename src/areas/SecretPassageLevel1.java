package areas;

import core.*;

/**
 *
 * @author coons5457w
 */
public class SecretPassageLevel1 extends Area<NoState> {

    public SecretPassageLevel1(final World containingWorld) {

        super(containingWorld);

        this.portals().up(new Portal(false, Cafeteria.class)).south(new Portal(false, Fitz.class));
        this.title("Secret Passage")
                .description("It's Mr.Fitz secret passage. Up is the cafeteria. "
                        + "South is Mr.Fitz room. There are no items.")
                .shortDescription("It's Mr.Fitz secret passage.").articleThe(true)
                .taste("Wallpaper and dried old paint. Why are you licking the walls again?")
                .smell("Old textbooks.").sound("The crying echo of a prisoner strung to the wall.");
    }
}
