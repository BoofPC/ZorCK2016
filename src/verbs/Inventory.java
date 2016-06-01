package verbs;
import core.Command;
import core.PlayerConstruct;
import java.util.ArrayList;
import core.Verb;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro
 */
public class Inventory extends Verb{
    
    public Inventory(){
        super("inventory",
                new String[] {"i"},
                new boolean[]{true,false,false});
    }
    
    public void run(Command command, PlayerConstruct construct){
        
    }
}
