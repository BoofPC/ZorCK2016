package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Area {
    /**
     * This stores portals in each {@link World.Direction}.
     */
    private final Portals portals = new Portals();
    private final World world;
    private String title;
    private String initialDescription;
    private String description;
    private String taste;
    private String smell;
    private String sound;
    private boolean dark;
    private boolean firstVisit = true;

    private final List<Item> items = new ArrayList<Item>();

    private final Map<String, Boolean> state = new HashMap<>();

    public Area(final World containingWorld) {
        this.world = containingWorld;
    }

    public World getContainingWorld() {
        return this.world;
    }

    public void interact(final Command command, final Context context) {
        final Item noun = command.getNoun();
        Area.defaultInteract(command, context, noun);
    }

    public static void defaultInteract(final Command command, final Context context, final Item noun) {
        if (command.getNoun() != null) {
            noun.interact(command, context);
        }
        if (!context.getSkipGeneral()) {
            command.getVerb().run(command, context);
        }
    }

    public void enter(final Player player) {
        if (this.firstVisit && !this.dark) {
            System.out.println(this.initialDescription);
            this.firstVisit = false;
        } else if (this.firstVisit && player.getItem("Lantern") != null) {
            if (player.getItem("Lantern").active()) {
                System.out.println(player.getCurrentArea().initialDescription());
                this.firstVisit = false;
            } else {
                System.out.println("It's too dark to see!");
            }
        } else if (this.firstVisit) {
            System.out.println("It's too dark to see!");
        } else {
            System.out.println(this.description);
        }
    }

    public Portals portals() {
        return this.portals;
    }

    public World.Direction direction(final Portal portal) {
        return Arrays.stream(World.Direction.values())
                .filter(d -> portal == this.portals.getPortal(d)).findAny().orElse(null);
    }

    public String title() {
        return this.title;
    }

    public Area title(final String title) {
        this.title = title;
        return this;
    }

    public String initialDescription() {
        return this.initialDescription;
    }

    public Area initialDescription(final String description) {
        this.initialDescription = description;
        return this;
    }

    public String description() {
        return this.description;
    }

    public Area description(final String description) {
        this.description = description;
        return this;
    }

    public String taste() {
        return this.taste;
    }

    public Area taste(final String input) {
        this.taste = input;
        return this;
    }

    public String smell() {
        return this.smell;
    }

    public Area smell(final String input) {
        this.smell = input;
        return this;
    }

    public String sound() {
        return this.sound;
    }

    public Area sound(final String input) {
        this.sound = input;
        return this;
    }

    public Map<String, Boolean> state() {
        return this.state;
    }

    public boolean state(final String name) {
        return this.state.get(name);
    }

    public Area state(final String name, final boolean bool) {
        this.state.put(name, bool);
        return this;
    }

    public List<Item> items() {
        return this.items;
    }

    public Area item(final Item item) {
        this.items.add(item);
        return this;
    }

    public Area removeItem(final Item item) {
        this.items.remove(item);
        return this;
    }

    public boolean hasMatching(final Item item) {
        return this.items.stream().anyMatch(i -> i == item);
    }

    public Item getItem(final String title) {
        return this.items.stream().filter(i -> i.name().equals(title)).findFirst().orElse(null);
    }

    public boolean dark() {
        return this.dark;
    }

    public Area dark(final boolean dark) {
        this.dark = dark;
        return this;
    }

    public boolean firstVisit() {
        return this.firstVisit;
    }

    public Area firstVisit(final boolean firstVisit) {
        this.firstVisit = firstVisit;
        return this;
    }
}
