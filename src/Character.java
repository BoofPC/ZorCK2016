
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
    
    //the following variables are base stats that are permanent and will be used
    //to determine the characters used stats as the level changes.
    public final int HP;
    public final int ATTACK;
    public final int DEFENSE;
    public final int SPEED;
    
    private ArrayList<Item> items;
    

    public Character(int hp, int speed, int attack, int defense, String name){

        this.name = name;
        this.ATTACK = attack;
        this.DEFENSE = defense;
        this.HP = hp;
        this.SPEED = speed;
        
        this.hp = ((HP+15)*2)/100+11;
        this.attack = ((ATTACK+15)*2)/100 + 5;
        this.defense = ((DEFENSE+15)*2)/100 + 5;
        this.speed = ((SPEED+15)*2)/100 + 5;
        
        this.items = new ArrayList<>();
    }
// this method has been moved and split to the Player and Enemy
// classes because they interpret level differently.
//    public void takeDamage(int attackStrength){
//       if(attackStrength > this.defense) this.hp -= (attackStrength - this.defense);
//        else this.hp -= 1;
//        if(this.hp < 0) this.hp = 0;
//   }
}
