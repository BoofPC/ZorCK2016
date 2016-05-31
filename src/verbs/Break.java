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
public class Break extends Verb{
    
    public Break(){
        super("break",
                new String[]{"shatter", "destroy"},
                new boolean[]{false, true, false});
    }
}
