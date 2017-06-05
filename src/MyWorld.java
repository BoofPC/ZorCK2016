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
        area = new BirkenfeldRoom();
            areas.put(area.getId(), area);
        area = new BoothRoom();
            areas.put(area.getId(), area);

        //add all Hallways here- so we can make sure we don't miss one
        area = new Hallway1();
            areas.put(area.getId(), area);
        area = new Hallway2();
            areas.put(area.getId(), area);
        area = new Hallway3();
            areas.put(area.getId(), area);
        area = new Hallway4();
            areas.put(area.getId(), area);
        area = new Hallway5();
            areas.put(area.getId(), area);
        area = new Hallway6();
            areas.put(area.getId(), area);
    }

    public MyWorld(){
        super("Comp Sci Room");
    }
}
