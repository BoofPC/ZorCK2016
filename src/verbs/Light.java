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
 * @author johnson5951a
 */
public class Light extends Verb {
    
    public Light(){
        super("light",
                new String[]{"ignite","illuminate"},
                new boolean[]{false, true, false});
    }
    
    public void run(Command command, PlayerConstruct construct){
        
    }
}
