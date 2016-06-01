/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package verbs;
import core.Command;
import core.Context;
import core.Verb;
/**
 *
 * @author johnson5951a
 */
public class Put extends Verb {
    public Put(){
        super("put",
                new String[]{"place", "set"},
                new boolean[]{false, true, false});
    }
    
    public void run(Command command, Context construct){
        
    }
}
