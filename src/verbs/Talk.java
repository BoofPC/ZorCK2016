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
public class Talk extends Verb {
    public Talk(){
        super("talk", 
                new String[]{"talk to","converse",""},
                new boolean[]{true, true, false});
    }
}
