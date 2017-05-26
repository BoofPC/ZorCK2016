package testgame;

import core.Area;
import core.World;

/**
 * Created by Alex on 5/24/17.
 */
public class MyWorld extends World {
    static{
    Area area;

    area = new CenterRoom();
        areas.put(area.getId(),area);

    area = new NorthRoom();
        areas.put(area.getId(),area);

    area = new EastRoom();
        areas.put(area.getId(),area);
    }

    public MyWorld(){
        super("Center Room");
    }
}
