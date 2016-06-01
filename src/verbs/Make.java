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
public class Make extends Verb {
    
    public Make(){
        super("make", 
                new String[]{"create","build","construct"},
                new boolean[]{false, true, false});
    }
    
    public void run(Command command, Context construct){
        
    }
}
