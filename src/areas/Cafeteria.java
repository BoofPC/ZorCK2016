package areas;

import core.*;
import items.*;

public class Cafeteria extends Area{
    public Cafeteria (final World containingWorld) {
        
        super(containingWorld);

        this.portals()
                .up(new Portal(false, Hallway04.class))
                .down(new Portal(false, SecretPassageLevel1.class));
        this.title("The Cafeteria")
                .description("It's the cafeteria. Up takes you the third floor via Elevator. " +
                        "Down is the Secret passage. There are a group of kids eating lunch.")
                .shortDescription("It's the cafeteria.").articleThe(true)
                .state("First",true)
                .taste("Pizza.")
                .smell("Pizza.")
                .sound("Chattering.")
                .state("take_lunch", false)
                .state("east_lunch", false)
                .item(new Kiddies())
                .item(new FitzLunch());
    }
    
    public void interact(Command command, Context context){
            if(command.getVerb().getTitle().equals("Eat") && 
                    command.getNoun().name().equals("lunch") && 
                    !this.state("eat_lunch")){
                System.out.println("You ate some kid's lunch.");
                System.out.println("Your max HP just went up by 3!");
                System.out.println("A kid attacked! 3 damage!");
                this.state("take_lunch", true);
                this.state("eat_lunch", true);
                context.getPlayer().setMaxHp(context.getPlayer().getMaxHp() + 3);
                context.getPlayer().setHp(context.getPlayer().getHp() + 3);
                context.getPlayer().getCurrentArea().removeItem(command.getNoun());
                context.getPlayer().setHp(context.getPlayer().getHp() - 3);
            }
            else if(command.getVerb().getTitle().equals("Take") && 
                    command.getNoun().name().equals("fitz's lunch") && 
                    !this.state("take_lunch")){
                System.out.println("You took Mr. Fitz's lunch and put it in the bag.");
                System.out.println("A kid attacked! 2 damage!");
                this.state("take_lunch", true);
                context.getPlayer().setHp(context.getPlayer().getHp() - 2);
                context.getPlayer().addItem(new FitzLunch());
            }
            else{
                super.interact(command, context);
            }
    }
}
