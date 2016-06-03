package core;

import java.util.ArrayList;
import java.util.List;

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

    public List<Item> getInventory() {
        return this.inventory;
    }

    public Item getItem(final String name) {
        return this.inventory.stream().filter(i -> i.name().equals(name)).findAny().orElse(null);
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
