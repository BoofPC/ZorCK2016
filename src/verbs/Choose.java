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
public class Choose extends Verb{
    
    public Choose(){
        super("choose",
                new String[]{"select"},
                new boolean[]{false, true, true});
    }
    
    public void run(Command command, Context construct){
        
    }
}
