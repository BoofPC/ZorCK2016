/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package items;
import core.*;

/**
 *
 * @author coons5457w
 */
public class Coffee extends Item{
    
    private boolean drank;
    
    public Coffee (){
        super();
        this.usage().take(Item.TAKABLE).drink(Item.DRINKABLE);
        this.name("coffee")
            .taste("It's bitter.")
            .smell("It exudes a very thick aroma.")
            .sound("There is no particular sound.")
            .synonym("Coffee", "cup of coffee")
            .examine("A cup of coffee. It looks very bitter.");
        drank = false;
    }
    
    @Override
    public boolean interact(final Command command, final Context context){
        if(command.getVerb().getTitle().equals("Drink") && 
            command.getNoun().name().equals("coffee") && !drank){
            context.getPlayer().setMaxHp(context.getPlayer().getMaxHp() + 1);
            context.getPlayer().setHp(context.getPlayer().getHp() + 1);
            context.getPlayer().getCurrentArea().removeItem(command.getNoun());
            System.out.println("You drank the coffee. It tastes very bitter.");
            System.out.println("Your max HP just went up by 1!");
            drank = true;
            return true; 
        }
        return false;
    }
}
