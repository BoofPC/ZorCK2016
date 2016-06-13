package areas;

import core.*;
import items.*;

/**
 *
 * @author coons5457w
 */
public class SecretPassageLevel1 extends Area {
    
    public SecretPassageLevel1(final World containingWorld) {
        
        super(containingWorld);

        this.portals()
                .up(new Portal(true, Cafeteria.class))
                .south(new Portal(true, Fitz.class));
        this.title("Secret Passage")
                .description("It's Mr.Fitz secret passage. Up is the cafeteria." + 
                            "South is Mr.Fitz room. There are no items.")
                .shortDescription("It's Mr.Fitz secret passage.").articleThe(true)
                .state("First",true)
                .taste("Wallpaper and dried old paint. Why are you licking the walls again?")
                .smell("Old textbooks.")
                .sound("The crying echo of a prisoner strung to the wall.");
    }
}
