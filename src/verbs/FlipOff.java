/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verbs;

import core.*;

/**
 *
 * @author Peter
 */
public class FlipOff extends Verb {

    public FlipOff() {
        super("flip off", Verb.usage().bare().noun(), "flick off", "give the finger",
                "flip the bird", "give a middle fingered salute");
    }
    
    @Override
    public void run(Command command, Context context){
        System.out.println("The Horror! The Horror!");
    }
}
