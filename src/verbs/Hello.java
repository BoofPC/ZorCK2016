package verbs;

import core.*;

import java.util.Random;

public class Hello extends Verb {

    public Hello() {
        super("hello", Verb.usage().bare().noun(), "hi", "good day", "good morning",
                "good afternoon", "good evening");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final int n = new Random().nextInt(10);
        switch (n) {
            case 0:
                System.out.println("Good day");
                break;
            case 1:
                System.out.println("Hey, there");
                break;
            case 2:
                System.out.println("Greetings");
                break;
            case 3:
                System.out.println("Hi");
                break;
            case 4:
                System.out.println("You have something in your teeth");
                break;
            case 5:
                System.out.println("What's up?");
                break;
            case 6:
                System.out.println("Hello, " + construct.getPlayer().getName());
                break;
            case 7:
                System.out.println("Nice weather we're having");
                break;
            case 8:
                System.out.println("Howdy");
                break;
            default:
                System.out.println("Hello");
                break;
        }
    }
}
