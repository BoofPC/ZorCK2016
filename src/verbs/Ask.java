/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package verbs;
import core.*;
/**
 *
 * @author johnson5951a
 */
public class Ask extends Verb{
    
    public Ask(){
        super("ask",
                new String[]{"inquire", "question", "interrogate"},
                new boolean[]{false, true, false});
    }
    
    public void run(Command command, Context construct){
        
    }
    
}
