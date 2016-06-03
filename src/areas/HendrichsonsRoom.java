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

    public HendrichsonsRoom(final World containingWorld) {
        super(containingWorld);
        this.getPortals().west(new Portal(Portal.State.UNLOCKED, "Hallway01"));
        this.setInitialDescription("You are in Hendrichson's room. It contains lab benches "
                + "with chemicals and physics projects. You see a balloon on the floor "
                + "that looks as if it has been recently used.");
        this.setDescription("You are in Hendrichson's room.");
        this.setDark(false);
        this.setSmell("It smells like sodium chloride.");
        this.setTaste("It doesn't taste like anything.");
        this.setSound("You don't hear anything. It is eerie...");
        this.addItem(new Door(false, "Western Door", null, this.getPortals().west()));
    }

    @Override
    public void interact(final Command command, final Context context) {
        Item noun;
        noun = command.getNoun();
        if(command.getVerb().getTitle().equals("look")){
            System.out.println(this.getDescription());
        }

        if(command.getVerb().getTitle().equals("take") && command.getNoun().equals("balloon")){
            System.out.println("The saliva from the previous user of the balloon "
                    + "acts as adhesive to keep the balloon on the ground.");
        }

        if(command.getVerb().getTitle().equals("drink") && (command.getNoun().equals("chemical") || command.getNoun().equals("chemicals"))){
            final Player player = context.getPlayer();
            System.out.println("Bad choice. You have died.");
            player.setDeath(Game.Status.SUICIDE);
        }

        else{
           if(command.getNoun() !=  null) {
            noun.interact(command, context);
        }
            if(!context.getSkipGeneral()) {
                command.getVerb().run(command, context);
            }
        }
    }
}
