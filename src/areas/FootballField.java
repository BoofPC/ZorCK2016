/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package areas;
import core.Area;
import core.Player;
import core.World;
/**
 *
 * @author allen3368r
 */
public class FootballField extends Area {
    public FootballField(World containingWorld){
        super(containingWorld);
    }
    
    @Override
    public void enter(Player player) {
        
    }
    
    @Override
    public void exit(Player player) {
        
    }
    
    @Override
    public void interact(String command, Player player) {
        switch(command){
            case "talk with guy":
                    System.out.println("You're going down BUDDY! Tou picked the"
                            +"wrong GUY to tango with pal!");
                    
        }
        System.out.println("");
    }
}
