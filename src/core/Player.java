package core;

import java.util.ArrayList;
import java.util.List;


public class Player {
    private String name;
    private int score;
    private final List<String> inventory;


    public Player(final String name) {
        this.name = name;
        this.score = 0;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<String> getInventory() {
        return this.inventory;
    }

    public void setScore(final int n) {
        this.score = n;
    }

    public int getScore() {
        return this.score;
    }

}
