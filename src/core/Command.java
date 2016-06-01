/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author pedro
 */
public class Command {
    
    private Verb verb;
    private Item noun;
    private int direction;
    
    public Command(Verb verb, Item noun, int direction){
        this.verb = verb;
        this.noun = noun;
        this.direction = direction;
    }
    
    public Verb getVerb(){
        return this.verb;
    }
    
    public Item getNoun(){
        return this.noun;
    }
    
    public int getDirection(){
        return this.direction;
    }
    
}
