package verbs;

import core.Verb;
/**
 *
 * @author keith5387h
 */
public class Move extends Verb{
    public Move(){
        super("move", 
                new String[] {"go","travel","walk"}, 
                new boolean[]{false, false, true});
    }
}
