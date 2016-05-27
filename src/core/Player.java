package core;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexb & pedro
 */
public class Player extends Character{
    private int xp;
    private int level;
    
    public Player(){
        super(435,235,235,235,"Zelda"); //That's the green guy, right?
        this.xp = 0;
        this.level = 1;
    }
    
    public void gainXP(Enemy enemy){
        if(this.level>enemy.LEVEL){
            this.xp += (enemy.LEVEL * enemy.EXP)/5 * Math.pow(2*enemy.LEVEL+10,2.5)/Math.pow(enemy.LEVEL*2+10,2.5)+1;
        }
        this.xp += (enemy.LEVEL * enemy.EXP)/5 * Math.pow(2*enemy.LEVEL+10,2.5)/Math.pow(enemy.LEVEL+this.level+10,2.5)+1;
        
        //determines if level needs to increase and then increases it.
        boolean levelChanged = false;
        while(this.xp >= Math.pow(this.level + 1,3)){
            this.level++;
            levelChanged = true;
        }
        // recalculates stats based on new level and new EVs
            this.hp = (int) ((((this.HP+15)*2)*this.level)/100 + this.level +10);
            this.attack = (int) ((((this.ATTACK+15)*2)*this.level)/100 + 5);
            this.defense = (int) ((((this.DEFENSE+15)*2)*this.level)/100 + 5);
            this.speed = (int) ((((this.SPEED+15)*2)*this.level)/100 + 5);
    }
    
    public void takeDamage(Enemy enemy){
        // the 40 in this equation will be replaced by the strength of the weapon used to attack.
        this.hp -= (2 * enemy.LEVEL +10)/250 * enemy.attack / this.defense * 40 + 1;
        if(this.hp<0) this.hp = 0;
    }
    
    //I made all damage dealing the responibility of the player class.
    public void dealDamage(Enemy enemy){
        enemy.hp -= (2 * this.level +10)/250 * this.attack / enemy.defense * 40 + 1;
        if(enemy.hp<0) enemy.hp = 0;
    }
    
    public int getLevel(){
        return this.level;
    }
}
