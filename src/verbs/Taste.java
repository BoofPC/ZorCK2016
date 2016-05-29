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
public class Taste extends Verb {
    
    public Taste(){
        super("taste",
                new String[]{"lick","eat","savor","sample","consume","devour"},
                new boolean[]{true, true, false});
    }
}
