package areas;
import core.*;
import items.*;

/**
 *
 * @author pedro
 */

public class Fitz extends Area{

        public Fitz(World containingWorld){
            super(containingWorld);
            this.portals()
                .north(new Portal(false, SecretPassage.class));
            this.title("Mr. Fitz's Room")
                .description("This is Mr. Fitz's Room, otherwise know as"
                    + " 'The Dungeon of torture.' There is a secret passage to"
                    + " the north. In this room you can find Mr. Fitz sipping coffee, his lunch,"
                    + " and a desk.")
                .shortDescription("This is Mr. Fitz's Room.")
                .state("First",true)
                .state("take_coffee", false)
                .state("drink_coffee", false)
                .state("take_lunch", false)
                .state("eat_lunch", false)
                .taste("It tastes of sadness.")
                .smell("It smells of coffee.")
                .sound("Fernat's last therorem being solved.")
                .item(new MrFitz())
                .item(new FitzLunch())
                .item(new Coffee())
                .item(new Desk());
        }
       
        public void interact(Command command, Context context){
            if(command.getVerb().getTitle().equals("Drink") && 
                    command.getNoun().name().equals("coffee") && 
                    !this.state("drink_coffee")){
                context.getPlayer().setMaxHp(context.getPlayer().getMaxHp() + 1);
                context.getPlayer().setHp(context.getPlayer().getHp() + 1);
                context.getPlayer().getCurrentArea().removeItem(command.getNoun());
                System.out.println("You drank the coffee. It tastes very bitter.");
                System.out.println("Your max HP just went up by 1!");
                System.out.println("Mr. Fitz attacked! 3 damage!");
                context.getPlayer().setHp(context.getPlayer().getHp() - 3);
                this.state("take_coffee", true);
                this.state("drink_coffee", true);
            }
            else if(command.getVerb().getTitle().equals("Take") && 
                    command.getNoun().name().equals("coffee") && 
                    !this.state("take_coffee")){
                context.getPlayer().addItem(new Coffee());
                System.out.println("You took the coffee and put it in the bag.");
                System.out.println("Mr. Fitz attacked! 3 damage!");
                context.getPlayer().setHp(context.getPlayer().getHp() - 3);
                context.getPlayer().getCurrentArea().removeItem(command.getNoun());
                this.state("take_coffee", true);
            }
            else if(command.getVerb().getTitle().equals("Talk") && 
                    command.getNoun().name().equals("Mr. Fitz")){
                System.out.println("Mr. Fitz says 'Sup?'");
            }
            else if(command.getVerb().getTitle().equals("Sit") && 
                    command.getNoun().name().equals("desk")){
                System.out.println("You sat in the desk and got out of your chair.");
            }
            else if(command.getVerb().getTitle().equals("Eat") && 
                    command.getNoun().name().equals("lunch") && 
                    !this.state("eat_lunch")){
                System.out.println("You ate Mr.Fitz's lunch.");
                System.out.println("Your max HP just went up by 3!");
                System.out.println("Mr. Fitz attacked! 5 damage!");
                context.getPlayer().setMaxHp(context.getPlayer().getMaxHp() + 3);
                context.getPlayer().setHp(context.getPlayer().getHp() + 3);
                context.getPlayer().getCurrentArea().removeItem(command.getNoun());
                context.getPlayer().setHp(context.getPlayer().getHp() - 5);
                this.state("take_lunch", true);
                this.state("eat_lunch", true);
            }
            else if(command.getVerb().getTitle().equals("Take") && 
                    command.getNoun().name().equals("lunch") && 
                    !this.state("take_lunch")){
                System.out.println("You took Mr. Fitz's lunch and put it in the bag.");
                System.out.println("Mr. Fitz attacked! 5 damage!");
                context.getPlayer().setHp(context.getPlayer().getHp() - 5);
                context.getPlayer().addItem(new FitzLunch());
                this.state("take_lunch", true);
            }
            else{
                super.interact(command, context);
            } 
        }

}
