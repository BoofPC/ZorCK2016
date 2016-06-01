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
 * @author pedro
 */
public class Hello extends Verb  {
    
    public Hello() {
        super("hello",
                new String[]{"hi","good day","good morning","good afternoon","good evening"},
                new boolean[]{true, true, false});
        
    }
    
    public void run(Command command, PlayerConstruct construct){
        
    }
}
