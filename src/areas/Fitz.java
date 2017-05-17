package areas;

import java.io.Serializable;

import core.*;
import items.*;

public class Fitz extends Area<Fitz.State> {
    public static class State implements Serializable {
        private static final long serialVersionUID = -6367328032330573609L;
        public boolean takeCoffee = false;
        public boolean drinkCoffee = false;
        public boolean takeLunch = false;
        public boolean eatLunch = false;
    }

    public Fitz(final World containingWorld) {
        super(containingWorld);
        this.portals().north(new Portal(false, SecretPassage.class));
        this.title("Mr. Fitz's Room")
                .description("This is Mr. Fitz's Room, otherwise know as"
                        + " 'The Dungeon of torture.' There is a secret passage to"
                        + " the north. In this room you can find Mr. Fitz sipping coffee, his lunch,"
                        + " and a desk.")
                .shortDescription("This is Mr. Fitz's Room.").taste("It tastes of sadness.")
                .smell("It smells of coffee.").sound("Fernat's last therorem being solved.")
                .item(new MrFitz()).item(new Coffee()).item(new Desk());
    }

    @Override
    public void interact(final Command command, final Context context) {
        final State state = this.state();
        if (command.getVerb().getTitle().equals("Drink")
                && command.getNoun().name().equals("coffee") && !state.drinkCoffee) {
            context.getPlayer().setMaxHp(context.getPlayer().getMaxHp() + 1);
            context.getPlayer().setHp(context.getPlayer().getHp() + 1);
            context.getPlayer().getCurrentArea().removeItem(command.getNoun());
            System.out.println("You drank the coffee. It tastes very bitter.");
            System.out.println("Your max HP just went up by 1!");
            System.out.println("Mr. Fitz attacked! 3 damage!");
            context.getPlayer().setHp(context.getPlayer().getHp() - 3);
            state.takeCoffee = true;
            state.drinkCoffee = true;
        } else if (command.getVerb().getTitle().equals("Take")
                && command.getNoun().name().equals("coffee") && !state.takeCoffee) {
            context.getPlayer().addItem(new Coffee());
            System.out.println("You took the coffee and put it in the bag.");
            System.out.println("Mr. Fitz attacked! 3 damage!");
            context.getPlayer().setHp(context.getPlayer().getHp() - 3);
            context.getPlayer().getCurrentArea().removeItem(command.getNoun());
            state.takeCoffee = true;
        } else if (command.getVerb().getTitle().equals("Talk")
                && command.getNoun().name().equals("Mr. Fitz")) {
            System.out.println("Mr. Fitz says 'Sup?'");
        } else if (command.getVerb().getTitle().equals("Sit")
                && command.getNoun().name().equals("desk")) {
            System.out.println("You sat in the desk and got out of your chair.");
        } else if (command.getVerb().getTitle().equals("Eat")
                && command.getNoun().name().equals("lunch") && !state.eatLunch) {
            System.out.println("You ate Mr.Fitz's lunch.");
            System.out.println("Your max HP just went up by 3!");
            System.out.println("Mr. Fitz attacked! 5 damage!");
            context.getPlayer().setMaxHp(context.getPlayer().getMaxHp() + 3);
            context.getPlayer().setHp(context.getPlayer().getHp() + 3);
            context.getPlayer().getCurrentArea().removeItem(command.getNoun());
            context.getPlayer().setHp(context.getPlayer().getHp() - 5);
            state.takeLunch = true;
            state.eatLunch = true;
        } else {
            super.interact(command, context);
        }
    }

}
