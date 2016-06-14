/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;
import core.*;
/**
 *
 * @author slatton1528n
 */
public class MrBirkenfeld extends Item{

    public MrBirkenfeld(){
        super();
        this.usage()
                .talk(Item.TALK)
                .recieve(Item.RECIEVE);
        this.name("mr.birkenfeld")
            .synonym("mr birkenfeld", "birkenfeld")
            .sound("I am Barkbackman");     
    }    
    
    @Override
    public boolean interact(final Command command, final Context context){
        if (command.getVerb().getTitle().equals("talk") && (command.getNoun().name().equals("mr.birkenfeld"))) {
            System.out.println("Hey, do your packets!!!");
            System.out.println("Sorry, can you get me the chemical ?");
            System.out.println("I'll open the Chemical Storage Room for you");
            return true;
        }
        if (command.getVerb().getTitle().equals("give") && (command.getNoun().name().equals("chemical"))) {
            System.out.println("Thanks for the chemical!!!");
            return true;
        }
        return false;
    }    
}
