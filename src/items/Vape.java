/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import core.*;
/**
 *
 * @author thomas0615d
 */
public class Vape extends Item{
    
    public Vape(){
        super();
        this.usage()
                .take(Item.TAKABLE)
                .use(Item.USABLE);
        this.name("Vape")
                .synonym("vape")
                .examine("It's a Vape")
                .taste("It tastes organic...Like Mountain Dew");
                
    }

    @Override
    public boolean interact(final Command command, final Context context){
        if (command.getVerb().getTitle().equals("drop")) {
            System.out.println("You feel compelled to keep the vape for some unknown reason");
            return true;
        }
        return false;
    }
}