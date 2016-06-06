/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package areas;

import core.*;
import items.*;

/**
 *
 * @author fischer5731c
 */
public class BroadcastingRoom extends Area{
    public BroadcastingRoom(World containingWorld) {
        super(containingWorld);
        
        this.getPortals()
            .south(new Portal(Portal.State.UNLOCKED, "Hallway11"))
            .west(new Portal(Portal.State.UNLOCKED, "AdamsonRoom"));
        
        this.setTitle("Broadcasting Room");
        this.setInitialDescription("You eneter a room of depressed possiblitities. "
                + "Great things once happened here, "
                + "but no longer.");
        this.setDescription("");
        // Add any necessary doors
        // (Here, the door faces south)
        this.addItem(new Door(false, "Door to Mr Adamson's room", null, this.getPortals().west()));

        
        this.addItem(new DuckOfDoom());
        this.addItem(new LaserPointer());
    }

    @Override
    public void interact(Command command, Context context) {
         //To change body of generated methods, choose Tools | Templates.
    }
}
