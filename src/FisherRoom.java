import tbge.Area;
import tbge.Door;

/**
 * Created by guerrer4154c on 5/31/2017.
 */
public class FisherRoom extends Area{
    private String laterDescription = "History posters are all around on the walls. Mrs. Fischer is frantically looking for some coffee.";
    public FisherRoom(){
        super("Fisher's Room");
        this.description = "You enter the room. The class is empty with the exception of Mrs. Fischer"
        this.getDoors().put(Direction.SOUTH,new Door("Hallway17"));
        this.getInventory().add("Lantern");
    }
}

