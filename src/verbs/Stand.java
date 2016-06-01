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
public class Stand extends Verb{
    
    public Stand(){
        super("stand",
                new String[]{"rise"},
                new boolean[]{true, false, false});
    }
    
    public void run(Command command, Context construct){
        
    }
}
