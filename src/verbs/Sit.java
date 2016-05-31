/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package verbs;
import core.Verb;
/**
 *
 * @author johnson5951a
 */
public class Sit extends Verb{
    
    public Sit(){
        super("sit",
                new String[]{"lie down", "prone", "criss-cross applesauce"},
                new boolean[]{true, false, false});
    }
}
