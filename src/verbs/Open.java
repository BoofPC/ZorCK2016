package verbs;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import core.Verb;
/**
 *
 * @author Cody
 */
public class Open extends Verb {
    public Open(){
        super("open", new String[]{"unseal", "unlock"}, new boolean[]{true,false,true});
    }
}
