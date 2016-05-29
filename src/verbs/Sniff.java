/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verbs;
import core.Verb;
/**
 *
 * @author Alex Johnson
 */
public class Sniff extends Verb  {
    
    public Sniff() {
        super("sniff",
                new String[]{"smell"},
                new boolean[]{true, true, false});
        
    }
}
