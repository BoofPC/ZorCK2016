package verbs;

import java.util.ArrayList;
import java.util.List;

import core.*;

public class Look extends Verb {

    public Look() {
        super("look", Verb.usage().bare().direction(), "l");
    }

    @Override
    public void run(final Command command, final Context construct) {
        final Player player = construct.getPlayer();

        final List<String> desc = new ArrayList<>();
        desc.add(player.getCurrentArea().description());
        if (player.getCurrentArea().items().size() > 0) {
            desc.add("");
            desc.add("This Area contains:");
            for (final Item item : player.getCurrentArea().items()) {
                desc.add(item.name());
            }
        }
        if (player.getCurrentArea().dark() != true) {
            desc.forEach(System.out::println);
        } else if (player.getItem("Lantern") != null) {
            if (player.getItem("Lantern").active()) {
                for (final String line : desc) {
                    System.out.println(line);
                }
            } else {
                System.out.println("It's too dark to see!");
            }
        } else {
            System.out.println("It's too dark to see!");
        }
    }
}
