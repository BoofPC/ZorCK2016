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
public class Run extends Verb{
    
    public Run(){
        super("run",
                new String[]{"sprint", "jog", "gallop"},
                new boolean[]{true, false, true});
    }
    
    public void run(Command command, PlayerConstruct construct){
        
    }
}
