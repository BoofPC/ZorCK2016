package core;

import java.util.ArrayList;
import java.util.List;

import core.World.Direction;

public abstract class Item {
    private String name;
    public String description;
    public static final int TAKE = 1;
    public static final int EAT = 2;
    public static final int DRINK = 3;
    public static final int OPEN = 4;
    public static final int LOCK = 5;
    public static final int READ = 6;
    public static final int TURN_ON = 7;
    public static final int MOVE = 8;
    public static final int WEAR = 9;
    public static final int CLOSE = 10;
    public static final int STAB = 11;
    public static final int PRESS = 12;
    public static final int CLIMB = 13;
    public static final int RECEIVE = 14;
    public static final int BREAK = 15;

    public int[] usage = new int[16];
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

    public String taste;
    public Item inside;
    // if item is read
    public String text;
    // if item can be turned on or pressed
    public boolean active;
    public String smell;
    public String sound;
    public List<Item> received;
    public List<String> keys;
    public Portal portal;
    public List<String> synonyms;

    public Item() {
        for (int i = 0; i < this.usage.length; i++) {
            this.usage[i] = 0;
        }
        this.synonyms = new ArrayList<String>();
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

    public int getUsageKey(final int n) {
        if (n < this.usage.length)
            return this.usage[n];
        else
            return -1;
    }

    public void setUsageKey(final int n, final int state) {
        if (n < this.usage.length) {
            this.usage[n] = state;
        }
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
        return this.getUsageKey(7) == 3;
    }

    public void setActive(final boolean active) {
        if (active) {
            this.setUsageKey(7, 3);
        } else {
            this.setUsageKey(7, 2);
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

        if (this.getUsageKey(5) == 3) {
            oppPortal.lock();
            if (oppDoor != null) {
                oppDoor.setUsageKey(5, 3);
            }
        } else {
            oppPortal.unlock();
            if (oppDoor != null) {
                oppDoor.setUsageKey(5, 2);
            }
        }
    }

    public abstract void interact(Command command, Context context);
}
