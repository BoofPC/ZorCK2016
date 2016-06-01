/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verbs;
import core.Command;
import core.PlayerConstruct;
import core.Verb;
/**
 *
 * @author Alex Johnson
 */
public class Smell extends Verb  {
    
    public Smell() {
        super("smell",
                new String[]{"sniff"},
                new boolean[]{true, true, false});
        
    }
    
    public void run(Command command, PlayerConstruct construct){
        
    }
}
