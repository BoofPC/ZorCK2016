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
        super(20,10,10,10);
        this.xp = 0;
        this.level = 1;
    }
    
    public void gainXP(Enemy enemy){
        this.xp += (Math.pow(1.5,(enemy.LEVEL - this.level))*(this.hp - enemy.hp));
    }
}
