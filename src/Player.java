/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alexb
 */
public class Player extends Character{
    private int xp;
    private int level;
    
    public Player(){
        super(20,10,10,10,"Red");
        this.xp = 0;
        this.level = 1;
    }
    
    public void gainXP(Enemy enemy){
        if(this.level>enemy.LEVEL){
            this.xp += (enemy.LEVEL * enemy.EXP)/5 * Math.pow(2*enemy.LEVEL+10,2.5)/Math.pow(enemy.LEVEL*2+10,2.5)+1;
        }
        this.xp += (enemy.LEVEL * enemy.EXP)/5 * Math.pow(2*enemy.LEVEL+10,2.5)/Math.pow(enemy.LEVEL+this.level+10,2.5)+1;
    }
}
