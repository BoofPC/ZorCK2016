package core;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexb
 */
public class Enemy extends Character{
    public final int EXP;
    public final int LEVEL;
    
    public Enemy(int hp, int speed, int attack, int defense, int exp, int level,String name){
        super(hp,speed,attack,defense,name);
        this.EXP = exp;
        this.LEVEL = level;
        
        //when a basic character is created stats are set for level one the following 
        //maths properly adjusts the stats to the proper level.
        this.hp = (this.hp-11)*LEVEL+this.LEVEL + 10;
        this.attack = (this.attack-5)*LEVEL+5;
        this.defense = (this.defense-5)*LEVEL+5;
        this.speed = (this.speed-5)*LEVEL+5;
    }
    
}
