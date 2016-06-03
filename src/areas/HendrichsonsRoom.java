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
 * @author Alex Johnson
 */
public class HendrichsonsRoom extends Area{

    public HendrichsonsRoom(World containingWorld) {
        super(containingWorld);
        getPortals().west(new Portal(Portal.State.UNLOCKED, "Hallway1"));
        setInitialDescription("You are in Hendrichson's room. It contains lab benches "
                + "with chemicals and physics projects. You see a balloon on the floor "
                + "that looks as if it has been recently used.");
        setDescription("You are in Hendrichson's room.");
        setDark(false);
        setSmell("It smells like sodium chloride.");
        setTaste("It doesn't taste like anything.");
        setSound("You don't hear anything. It is eerie...");
        addItem(new Door(false, "Western Door", null, getPortals().west()));
    }

    @Override
    public void interact(Command command, Context context) {
        Item noun;
        noun = command.getNoun();
        if(command.getVerb().getTitle().equals("look")){
            System.out.println(getDescription());
        }
        
        if(command.getVerb().getTitle().equals("take") && command.getNoun().equals("balloon")){
            System.out.println("The saliva from the previous user of the balloon "
                    + "acts as adhesive to keep the balloon on the ground.");
        }
        
        if(command.getVerb().getTitle().equals("drink") && (command.getNoun().equals("chemical") || command.getNoun().equals("chemicals"))){
            Player player = context.getPlayer();
            System.out.println("Bad choice. You have died.");
            player.setDeath(Game.Status.SUICIDE);
        }
        
        else{
           if(command.getNoun() !=  null)
                noun.interact(command, context);
            if(!context.getSkipGeneral())
                command.getVerb().run(command, context);
        }
    }
}
