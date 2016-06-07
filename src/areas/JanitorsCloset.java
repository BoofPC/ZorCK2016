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
 * @author Kevin White
 */
public class JanitorsCloset extends Area {
    
    public JanitorsCloset(final World containingWorld){
        super(containingWorld);
        this.portals().east(new Portal(Portal.State.UNLOCKED, Hallway17.class));
        this.title("Janitor's Closet").initialDescription("A dark old Janitor's Closet. The room is oddly humid... " + "You see a pair of plastic sissors on the floor.")
                .description("This is the Janitor's Closet you see scissors and a small planter with grass." + 
                        "There is a door leaving where you entered to the east")
                .item(new Scissors())
                .item(new Grass());
        
       
           
    }
    
}

