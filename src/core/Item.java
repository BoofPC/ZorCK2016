package core;

import java.util.ArrayList;
import java.util.List;

import core.World.Direction;

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
     * {0      ,1   ,2  ,3    ,4   ,5   ,6   ,7     ,8   ,9   ,10   ,11  ,12   ,13   ,14     ,15
     * {[dummy],take,eat,drink,open,lock,read,turnOn,move,wear,close,stab,press,climb,receive,break}
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
    private List<Item> received;
    private List<String> keys;
    private Portal portal;
    private final List<String> synonyms;

    public Item() {
        this.synonyms = new ArrayList<String>();
    }

    public Usage usage() {
        return this.usage;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getTaste() {
        return this.taste;
    }

    public void setTaste(final String taste) {
        this.taste = taste;
    }

    public Item getInside() {
        return this.inside;
    }

    public void setInside(final Item inside) {
        this.inside = inside;
    }

    public String getText() {
        return this.text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public boolean getActive() {
        return this.usage().active() == Usage.Active.ON;
    }

    public void setActive(final boolean active) {
        if (active) {
            this.usage().active(Usage.Active.ON);
        } else {
            this.usage().active(Usage.Active.OFF);
        }
    }

    public String getSmell() {
        return this.smell;
    }

    public void setSmell(final String smell) {
        this.smell = smell;
    }

    public String getSound() {
        return this.sound;
    }

    public void setSound(final String sound) {
        this.sound = sound;
    }

    public List<String> getKeys() {
        return this.keys;
    }

    public void setKeys(final List<String> keys) {
        this.keys = keys;
    }

    public Portal getPortal() {
        return this.portal;
    }

    public void setPortal(final Portal portal) {
        this.portal = portal;
    }

    public void addSynonym(final String str) {
        this.synonyms.add(str);
    }

    public boolean hasMatching(final String str) {
        return this.name.equals(str) || this.synonyms.contains(str);
    }

    public void drop(final Area area) {
        if (this.getInside() != null) {
            area.addItem(this.getInside());
            this.setInside(null);
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
        portal = this.getPortal();
        Area target;
        target = world.getArea(portal.getTarget());
        final Direction direction = currentArea.getDirection(portal);
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

        final Portal oppPortal = target.getPortals().getPortal(oppDir);
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

    public abstract void interact(Command command, Context context);

    public static final class Usage {
        private Visible visible;
        private Take take;
        private Food food;
        private Drink drink;
        private Open open;
        private Lock lock;
        private Read read;
        private Active active;
        private Move move;
        private Wear wear;
        private Close close;
        private Stab stab;
        private Press press;
        private Climb climb;
        private Recieve recieve;
        private Breakable breakable;
        public Usage() {
            this.visible = Visible.VISIBLE;
            this.take = Take.UNTAKABLE;
            this.food = Food.UNEDIBLE;
            this.drink = Drink.UNDRINKABLE;
            this.open = Open.UNOPENABLE;
            this.lock = Lock.NO_LOCK;
            this.read = Read.UNREADABLE;
            this.active = Active.STATIC;
            this.move = Move.IMMOVABLE;
            this.wear = Wear.UNWEARABLE;
            this.close = Close.UNCLOSABLE;
            this.stab = Stab.UNSTABBABLE;
            this.press = Press.UNPRESSABLE;
            this.climb = Climb.UNCLIMBABLE;
            this.recieve = Recieve.NO_RECIEVE;
            this.breakable = Breakable.UNBREAKABLE;
        }
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
            UNDRINKABLE, DRINKABLE, CLOSED, EMPTY
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
        public static enum Close {
            UNCLOSABLE, OPEN, CLOSED
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
            UNBREAKABLE, UNBROKEN, BROKEN
        }
        public Visible visible() {
            return this.visible;
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
        public Close close() {
            return this.close;
        }
        public Usage close(final Close o) {
            this.close = o;
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
    }
}
