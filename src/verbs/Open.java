package verbs;

import core.Verb;
/**
 *
 * @author Cody
 */
public class Open extends Verb {
    public Open(){
        super("open", 
                new String[]{"unseal", "unlock"}, 
                new boolean[]{false,true,false});
    }
}