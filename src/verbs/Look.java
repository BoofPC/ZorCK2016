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
        if (player.getCurrentArea().getItems().size() == 0) {
            desc.add(player.getCurrentArea().getDescription());
        } else {
            desc.add(player.getCurrentArea().getDescription());
            desc.add("");
            desc.add("This Area contains:");
            for (final Item item : player.getCurrentArea().getItems()) {
                desc.add(item.name());
            }
        }
        if (player.getCurrentArea().getDark() != true) {
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
