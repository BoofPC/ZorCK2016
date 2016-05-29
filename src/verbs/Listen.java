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
public class Listen extends Verb {
    
    public Listen(){
        super("listen",
                new String[]{"hear","pay attention"},
                new boolean[]{true, true, false});
    }
}
