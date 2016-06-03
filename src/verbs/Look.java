package verbs;

import java.util.ArrayList;
import java.util.List;

import core.*;

public class Look extends Verb {

    public Look() {
        super("look",
                new String[]{"l"},
                new boolean[]{true, false, true});
    }

    public void run(Command command, Context construct) {
        command.getDirection();
        command.getNoun();

        Player player = construct.getPlayer();
        construct.getWorld();

        List<String> desc = new ArrayList<>();
        if (player.getCurrentArea().getItems().size() == 0) {
            desc.add(player.getCurrentArea().getDescription());
        } else {
            desc.add(player.getCurrentArea().getDescription());
            desc.add("");
            desc.add("This Area contains:");
            for (final Item item : player.getCurrentArea().getItems()) {
                desc.add(item.getName());
            }
        }
        if (player.getCurrentArea().getDark() != true) {
            for (String item : desc) {
                System.out.println(item);
            }
        } else if (player.getItem("Lantern") != null) {
            if (player.getItem("Lantern").getActive()) {
                for (String item : desc) {
                    System.out.println(item);
                }
            } else {
                System.out.println("It's too dark to see!");
            }
        } else {
            System.out.println("It's too dark to see!");
        }
    }
}
