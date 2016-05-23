
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexb
 */
public class Character {
    public int hp;
    public int speed;
    public int attack;
    public int defense;
    public final String name;
    
    private ArrayList<Item> items;
    

    public Character(int hp, int speed, int attack, int defense, String name){

        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.hp = hp;
        this.speed = speed;
        this.items = new ArrayList<>();
    }
        
    public void takeDamage(int attackStrength){
        if(attackStrength > this.defense) this.hp -= (attackStrength - this.defense);
        else this.hp -= 1;
        if(this.hp < 0) this.hp = 0;
    }
}
