package core;

import java.util.ArrayList;
import java.util.List;

import items.Lantern;

public class Player {
    private int hp;
    private int maxHp;
    private String name;
    private Area currentArea;
    private int score;
    private boolean prayer;
    private Game.Status death;
    private boolean sit;

    private final List<Item> inventory;


    public Player(final int hp, final String name) {
        this.hp = hp;
        this.maxHp = hp;
        this.name = name;
        this.prayer = false;
        this.death = Game.Status.KEEP_PLAYING;
        this.sit = false;

        this.inventory = new ArrayList<>();
    }

    public String currentDescription() {
        final StringBuilder desc = new StringBuilder();
        final Area currentArea = this.getCurrentArea();
        desc.append(currentArea.description());
        final List<Item> items = currentArea.items();
        for (final Item item : items) {
            final String look = currentArea.lookItem(item);
            if (look == null)
                continue;
            desc.append(' ');
            desc.append(look);
        }
        desc.append('\n');
        // TODO Fix items' looks so this is unnecessary.
        if (items.size() > 0) {
            desc.append("This Area contains: ");
            for (final Item item : items) {
                desc.append('\n');
                desc.append(item.name());
            }
        }
        if (currentArea.dark() == true) {
            final Item lantern = this.getItem(Lantern.class);
            if (lantern != null && lantern.active()) {
                System.out.println(desc.toString());
            } else {
                System.out.println("It's too dark to see!");
            }
        }
        return desc.toString();
    }

    public String currentShortDescription() {
        final StringBuilder desc = new StringBuilder();
        final Area currentArea = this.getCurrentArea();
        desc.append(currentArea.shortDescription());
        final List<Item> items = currentArea.items();
        for (final Item item : items) {
            final String look = currentArea.lookItem(item);
            if (look == null)
                continue;
            desc.append(' ');
            desc.append(look);
        }
        desc.append('\n');
        // TODO Fix items' looks so this is unnecessary.
        if (items.size() > 0) {
            desc.append("This Area contains: ");
            for (final Item item : items) {
                desc.append('\n');
                desc.append(item.name());
            }
        }
        if (currentArea.dark() == true) {
            final Item lantern = this.getItem(Lantern.class);
            if (lantern != null && lantern.active()) {
                System.out.println(desc.toString());
            } else {
                System.out.println("It's too dark to see!");
            }
        }
        return desc.toString();
    }

    public String getName() {
        return this.name;
    }

    public void rename(final String name) {
        this.name = name;
    }

    public void addItem(final Item item) {
        this.inventory.add(item);
    }

    public void removeItem(final Item item) {
        this.inventory.remove(item);
    }

    public boolean hasMatching(final Item item) {
        return this.inventory.stream().anyMatch(i -> i == item);
    }

    public boolean hasItem(final Class<? extends Item> clazz) {
        for (final Item item : this.getInventory()) {
            if (item.getClass().equals(clazz))
                return true;
        }
        return false;
    }

    public boolean hasItem(final String name) {
        for (final Item item : this.getInventory()) {
            if (item.name().equals(name))
                return true;
        }
        return false;
    }

    public List<Item> getInventory() {
        return this.inventory;
    }

    public Item getItem(final Class<? extends Item> item) {
        return this.inventory.stream().filter(i -> i.getClass().equals(item)).findAny()
                .orElse(null);
    }

    public Area getCurrentArea() {
        return this.currentArea;
    }

    public void setCurrentArea(final Area area) {
        this.currentArea = area;
    }

    public void setScore(final int n) {
        this.score = n;
    }

    public int getScore() {
        return this.score;
    }

    public void addScore(final int n) {
        this.score += n;
    }

    public void setHp(final int n) {
        this.hp = n;
    }

    public int getHp() {
        return this.hp;
    }

    public void addHp(final int n) {
        this.hp += n;
    }

    public void setMaxHp(final int n) {
        this.maxHp = n;
    }

    public int getMaxHp() {
        return this.maxHp;
    }

    public void setPrayer(final boolean bool) {
        this.prayer = bool;
    }


    public boolean getPrayer() {
        return this.prayer;
    }

    public void setSit(final boolean bool) {
        this.sit = bool;
    }

    public boolean getSit() {
        return this.sit;
    }

    public void setDeath(final Game.Status death) {
        this.death = death;
    }

    public Game.Status getDeath() {
        return this.death;
    }
}
