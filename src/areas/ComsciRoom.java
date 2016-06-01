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
 * @author allen3368r
 */
public class ComsciRoom extends Area{

    public ComsciRoom(World containingWorld) {
        super(containingWorld);
        setPortal(1, new Portal(false, "Hallway5"));
        setPortal(2, new Portal(false, "Wachtman's room"));
        //change the portal to go to hallway when hallway is made
        setTitle("Comsci Room");
        setInitialDescription("This is the Comsci room, Room 317.");
        setDescription("This is the Comsci Room, room 317");
        
    }

    @Override
    public void interact(Command command, PlayerConstruct construct) {
        
    }

   
    
}
