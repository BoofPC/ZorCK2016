package core;

import java.util.ArrayList;
import java.util.List;

import core.World.Direction;
//
public abstract class Item {
    private String name;
    private String description;

    private final Usage usage = new Usage();
    // TODO Update description
    /*
     * update this number as needed
     * usage is an array of ints which determines many
     * characteristics of an item. Each item in the
     * array corresponds with an attribute of the item
     * for example the first item in the array represents
     * whether the item is takable, with different numbers
     * as different statuses. 0 is always "unset." 1 is "takable," the user can
     * "take" the item to get it into their inventory. 2 means the item is too
     * heavy to take, and will return an appropriate message if "take (item)"
     * is invoked. 3 means the item is bolted down, etc.
     *
     * The meanings of each item is as follows:
     * {0      ,1   ,2  ,3    ,4   ,5   ,6   ,7     ,8   ,9   ,10   ,11  ,12   ,13   ,14     ,15   ,16
     * {[dummy],take,eat,drink,open,lock,read,turnOn,move,wear,close,stab,press,climb,receive,break,use}
     * feel free to add more
     * the possible statuses of each are as follows:
     * take (n = 1) -    0: unset (default, returns "not takable")
     *                   1: takable
     *                   2: too heavy
     *                   3: bolted down
     * eat (n = 2) -     0: unset (default, returns "not eatable")
     *                   1: not eatable
     *                   2: eatable
     * drink (n = 3) -   0: unset (default, returns "not drinkable")
     *                   1: not drinkable
     *                   2: drinkable
     *                   3: "You need to open it first!"
     *                   4: drinkable, already drank
     * open (n = 4) -    0: unset (default, returns "not openable")
     *                   1: not openable
     *                   2: openable, closed
     *                   3: openable, open
     * lock (n = 5) -    0: unset {default, returns "not lockable")
     *                   1: not lockable
     *                   2: lockable, unlocked
     *                   3: lockable, locked
     * read (n = 6) -    0: unset (default, returns "not readable")
     *                   1: not readable
     *                   2: readable
     *                   3: illegible
     * turnOn (n = 7) - 0: unset (default, returns "not turnOnable")
     *                   1: not turnOnable
     *                   2: turnOnable, off
     *                   3: turnOnable, on
     * move (n = 8) -    0: unset (default, returns "not movable")
     *                   1: unmovable
     *                   2: movable
     * wear (n = 9) -    0: unset (default, returns "not wearable")
     *                   1: unwearable
     *                   2: wearable
     * close (n = 10) -   0: unset (default, returns "not closeable")
     *                   1: not closable
     *                   2: closable, open
     *                   3: closable, closed
     * stab (n = 11) -   0: unset (default, returns "not stabable")
     *                   1: not stabable
     *                   2: stabable
     * press (n = 12) -  0: unset (default, returns "not pressable")
     *                   1: not pressable
     *                   2: pressable, unpressed
     *                   3: pressable, pressed
     * climb (n = 13) -  0: unset (default, returns "not climbable")
     *                   1: not climbable
     *                   2: climbable
     * receive (n = 14) -0: unset (default, returns "cannot receive")
     *                   1: cannot receive items
     *                   2: can recieve items
     * break (n = 15) -  0: unset (default, returns "cannot break")
     *                   1: cannot break item
     *                   2: breakable, not broken
     *                   3: breakable, broken
     * use (n = 16) -    0: unset (default, returns "no use")
     *                   1: item has no use
     *                   2: item has a use (invoked by Use verb)
     *
     *
     *
     * the first item, represented here as [duumy], refers to
     * whether the item is a real, tangible, and distinct
     * object which should be described when "look" is called
     * (e.g. a screwdriver) or an item which should be hidden
     * unless interacted with (e.g. a pocket on a gown
     * [dummy] -     0: unset (default, returns "real")
     *               1: real
     *               2: not real
     */

    private String taste;
    private Item inside;
    // if item is read
    private String text;
    private String smell;
    private String sound;
    private final List<Item> received = new ArrayList<>();
    private final List<Class<? extends Item>> keys = new ArrayList<>();
    private Portal portal;
    private final List<String> synonyms = new ArrayList<>();

    public Item() {}

    public Usage usage() {
        return this.usage;
    }

    public String name() {
        return this.name;
    }

    public Item name(final String name) {
        this.name = name;
        return this;
    }

    public String description() {
        return this.description;
    }

    public Item description(final String description) {
        this.description = description;
        return this;
    }

    public String taste() {
        return this.taste;
    }

    public Item taste(final String taste) {
        this.taste = taste;
        return this;
    }

    public Item inside() {
        return this.inside;
    }

    public Item inside(final Item inside) {
        this.inside = inside;
        return this;
    }

    public String text() {
        return this.text;
    }

    public Item text(final String text) {
        this.text = text;
        return this;
    }

    public boolean active() {
        return this.usage().active() == Usage.Active.ON;
    }

    public Item active(final boolean active) {
        if (active) {
            this.usage().active(Usage.Active.ON);
        } else {
            this.usage().active(Usage.Active.OFF);
        }
        return this;
    }

    public String smell() {
        return this.smell;
    }

    public Item smell(final String smell) {
        this.smell = smell;
        return this;
    }

    public String sound() {
        return this.sound;
    }

    public Item sound(final String sound) {
        this.sound = sound;
        return this;
    }

    public List<Class<? extends Item>> keys() {
        return this.keys;
    }

    public Item key(final Class<? extends Item> key) {
        this.keys.add(key);
        return this;
    }

    public Portal portal() {
        return this.portal;
    }

    public Item portal(final Portal portal) {
        this.portal = portal;
        return this;
    }

    public List<String> synonyms() {
        return this.synonyms;
    }

    public Item synonym(final String... strs) {
        for (final String str : strs) {
            this.synonyms.add(str);
        }
        return this;
    }

    public boolean hasMatching(final String str) {
        return this.name.equals(str) || this.synonyms.contains(str);
    }

    public void drop(final Area area) {
        if (this.inside() != null) {
            area.item(this.inside());
            this.inside(null);
        }
    }

    public void receive(final Item item) {
        this.received.add(item);
    }


    public boolean hasReceived(final String name) {
        return this.received.contains(name);
    }

    public void synchronizeDoor(final World world, final Area currentArea) {
        Portal portal;
        portal = this.portal();
        Area target;
        target = world.getArea(portal.getTarget());
        final Direction direction = currentArea.direction(portal);
        final Direction oppDir;
        switch (direction) {
            case NORTH:
                oppDir = Direction.SOUTH;
                break;
            case EAST:
                oppDir = Direction.WEST;
                break;
            case SOUTH:
                oppDir = Direction.NORTH;
                break;
            case WEST:
                oppDir = Direction.EAST;
                break;
            case NORTHEAST:
                oppDir = Direction.SOUTHWEST;
                break;
            case SOUTHEAST:
                oppDir = Direction.NORTHWEST;
                break;
            case SOUTHWEST:
                oppDir = Direction.NORTHEAST;
                break;
            case NORTHWEST:
                oppDir = Direction.SOUTHEAST;
                break;
            case UP:
                oppDir = Direction.DOWN;
                break;
            case DOWN:
                oppDir = Direction.UP;
                break;
            default:
                oppDir = null;
        }

        final Portal oppPortal = target.portals().getPortal(oppDir);
        final Item oppDoor = oppPortal.getDoor(target);

        if (this.usage().lock() == Usage.Lock.LOCKED) {
            oppPortal.lock();
            if (oppDoor != null) {
                oppDoor.usage().lock(Usage.Lock.LOCKED);
            }
        } else {
            oppPortal.unlock();
            if (oppDoor != null) {
                oppDoor.usage().lock(Usage.Lock.UNLOCKED);
            }
        }
    }

    public boolean interact(Command command, Context context) {
        return false;
    };

    public static final class Usage {
        private Visible visible = Visible.VISIBLE;
        private Take take = Take.UNTAKABLE;
        private Food food = Food.UNEDIBLE;
        private Drink drink = Drink.UNDRINKABLE;
        private Open open = Open.UNOPENABLE;
        private Lock lock = Lock.NO_LOCK;
        private Read read = Read.UNREADABLE;
        private Active active = Active.STATIC;
        private Move move = Move.IMMOVABLE;
        private Wear wear = Wear.UNWEARABLE;
        private Stab stab = Stab.UNSTABBABLE;
        private Press press = Press.UNPRESSABLE;
        private Climb climb = Climb.UNCLIMBABLE;
        private Recieve recieve = Recieve.NO_RECIEVE;
        private Breakable breakable = Breakable.UNBREAKABLE;
        private Talk talk = Talk.NO_TALK;
        private Use use = Use.NO_USE;
        private Puttable puttable = Puttable.PUTTABLE;

        public Usage() {}

        public static enum Visible {
            VISIBLE, HIDDEN
        }
        public static enum Take {
            UNTAKABLE, TAKABLE, TOO_HEAVY, BOLTED_DOWN
        }
        public static enum Food {
            UNEDIBLE, EDIBLE
        }
        public static enum Drink {
            UNDRINKABLE, DRINKABLE, CLOSED_DRINK, EMPTY
        }
        public static enum Open {
            UNOPENABLE, CLOSED, OPEN
        }
        public static enum Lock {
            NO_LOCK, UNLOCKED, LOCKED
        }
        public static enum Read {
            UNREADABLE, READABLE, ILLEGIBLE
        }
        public static enum Active {
            STATIC, OFF, ON
        }
        public static enum Move {
            IMMOVABLE, MOVABLE
        }
        public static enum Wear {
            UNWEARABLE, WEARABLE
        }
        public static enum Stab {
            UNSTABBABLE, STABABBLE
        }
        public static enum Press {
            UNPRESSABLE, UNPRESSED, PRESSED
        }
        public static enum Climb {
            UNCLIMBABLE, CLIMABLE
        }
        public static enum Recieve {
            NO_RECIEVE, RECIEVE
        }
        public static enum Breakable {
            BREAKABLE, UNBREAKABLE, UNBROKEN, BROKEN
        }
        public static enum Talk {
            NO_TALK, TALK
        }

        public static enum Use {
            NO_USE, USABLE
        }

        public Visible visible() {
            return this.visible;
        }

        public static enum Puttable{
            PUTTABLE,UNPUTTABLE
        }

        public Usage visible(final Visible o) {
            this.visible = Visible.VISIBLE;
            return this;
        }

        public Take take() {
            return this.take;
        }

        public Usage take(final Take o) {
            this.take = o;
            return this;
        }

        public Food food() {
            return this.food;
        }

        public Usage food(final Food o) {
            this.food = o;
            return this;
        }

        public Drink drink() {
            return this.drink;
        }

        public Usage drink(final Drink o) {
            this.drink = o;
            return this;
        }

        public Open open() {
            return this.open;
        }

        public Usage open(final Open o) {
            this.open = o;
            return this;
        }

        public Lock lock() {
            return this.lock;
        }

        public Usage lock(final Lock o) {
            this.lock = o;
            return this;
        }

        public Read read() {
            return this.read;
        }

        public Usage read(final Read o) {
            this.read = o;
            return this;
        }

        public Active active() {
            return this.active;
        }

        public Usage active(final Active o) {
            this.active = o;
            return this;
        }

        public Move move() {
            return this.move;
        }

        public Usage move(final Move o) {
            this.move = o;
            return this;
        }

        public Wear wear() {
            return this.wear;
        }

        public Usage wear(final Wear o) {
            this.wear = o;
            return this;
        }

        public Stab stab() {
            return this.stab;
        }

        public Usage stab(final Stab o) {
            this.stab = o;
            return this;
        }

        public Press press() {
            return this.press;
        }

        public Usage press(final Press o) {
            this.press = o;
            return this;
        }

        public Climb climb() {
            return this.climb;
        }

        public Usage climb(final Climb o) {
            this.climb = o;
            return this;
        }

        public Recieve recieve() {
            return this.recieve;
        }

        public Usage recieve(final Recieve o) {
            this.recieve = o;
            return this;
        }

        public Breakable breakable() {
            return this.breakable;
        }

        public Usage breakable(final Breakable o) {
            this.breakable = o;
            return this;
        }

        public Talk talk() {
            return this.talk;
        }

        public Usage talk(final Talk o) {
            this.talk = o;
            return this;
        }

        public Use use() {
            return this.use;
        }

        public Usage use(final Use o) {
            this.use = o;
            return this;
        }

        public Puttable puttable(){
            return this.puttable;
        }

        public Usage puttable(final Puttable o){
            this.puttable = o;
            return this;
        }
    }

    // java: i cry everytim
    public static final Usage.Visible VISIBLE = Usage.Visible.VISIBLE;
    public static final Usage.Visible HIDDEN = Usage.Visible.HIDDEN;
    public static final Usage.Take UNTAKABLE = Usage.Take.UNTAKABLE;
    public static final Usage.Take TAKABLE = Usage.Take.TAKABLE;
    public static final Usage.Take TOO_HEAVY = Usage.Take.TOO_HEAVY;
    public static final Usage.Take BOLTED_DOWN = Usage.Take.BOLTED_DOWN;
    public static final Usage.Food UNEDIBLE = Usage.Food.UNEDIBLE;
    public static final Usage.Food EDIBLE = Usage.Food.EDIBLE;
    public static final Usage.Drink UNDRINKABLE = Usage.Drink.UNDRINKABLE;
    public static final Usage.Drink DRINKABLE = Usage.Drink.DRINKABLE;
    public static final Usage.Drink CLOSED_DRINK = Usage.Drink.CLOSED_DRINK;
    public static final Usage.Drink EMPTY = Usage.Drink.EMPTY;
    public static final Usage.Open UNOPENABLE = Usage.Open.UNOPENABLE;
    public static final Usage.Open CLOSED = Usage.Open.CLOSED;
    public static final Usage.Open OPEN = Usage.Open.OPEN;
    public static final Usage.Lock NO_LOCK = Usage.Lock.NO_LOCK;
    public static final Usage.Lock UNLOCKED = Usage.Lock.UNLOCKED;
    public static final Usage.Lock LOCKED = Usage.Lock.LOCKED;
    public static final Usage.Read UNREADABLE = Usage.Read.UNREADABLE;
    public static final Usage.Read READABLE = Usage.Read.READABLE;
    public static final Usage.Read ILLEGIBLE = Usage.Read.ILLEGIBLE;
    public static final Usage.Active STATIC = Usage.Active.STATIC;
    public static final Usage.Active OFF = Usage.Active.OFF;
    public static final Usage.Active ON = Usage.Active.ON;
    public static final Usage.Move IMMOVABLE = Usage.Move.IMMOVABLE;
    public static final Usage.Move MOVABLE = Usage.Move.MOVABLE;
    public static final Usage.Wear UNWEARABLE = Usage.Wear.UNWEARABLE;
    public static final Usage.Wear WEARABLE = Usage.Wear.WEARABLE;
    public static final Usage.Stab UNSTABBABLE = Usage.Stab.UNSTABBABLE;
    public static final Usage.Stab STABABBLE = Usage.Stab.STABABBLE;
    public static final Usage.Press UNPRESSABLE = Usage.Press.UNPRESSABLE;
    public static final Usage.Press UNPRESSED = Usage.Press.UNPRESSED;
    public static final Usage.Press PRESSED = Usage.Press.PRESSED;
    public static final Usage.Climb UNCLIMBABLE = Usage.Climb.UNCLIMBABLE;
    public static final Usage.Climb CLIMABLE = Usage.Climb.CLIMABLE;
    public static final Usage.Recieve NO_RECIEVE = Usage.Recieve.NO_RECIEVE;
    public static final Usage.Recieve RECIEVE = Usage.Recieve.RECIEVE;
    public static final Usage.Breakable BREAKABLE = Usage.Breakable.BREAKABLE;
    public static final Usage.Breakable UNBREAKABLE = Usage.Breakable.UNBREAKABLE;
    public static final Usage.Breakable UNBROKEN = Usage.Breakable.UNBROKEN;
    public static final Usage.Breakable BROKEN = Usage.Breakable.BROKEN;
    public static final Usage.Talk NO_TALK = Usage.Talk.NO_TALK;
    public static final Usage.Talk TALK = Usage.Talk.TALK;
    public static final Usage.Use USABLE = Usage.Use.USABLE;
    public static final Usage.Use NO_USE = Usage.Use.NO_USE;
    public static final Usage.Puttable PUTTABLE = Usage.Puttable.PUTTABLE;
    public static final Usage.Puttable UNPUTTABLE = Usage.Puttable.UNPUTTABLE;
}
