import tbge.Area;
import tbge.World;

/**
 * Created by lynds on 5/31/2017.
 */
public class MyWorld extends World {

    static{
        Area area;
        area = new CSRoom();
            areas.put(area.getId(), area);
    }

    public MyWorld(){
        super("Comp Sci Room");
    }
}
