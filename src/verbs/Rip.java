/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verbs;

import core.*;
/**
 *
 * @author thomas0615d
 */
public class Rip extends Verb{
    public Rip(){
        super("rip",Verb.usage().noun(),"rip_on");
    }

    @Override
    public void run(final Command command, final Context construct) {
        switch (command.getNoun().usage().use()){
            case USABLE:
                System.out.println("You rip the fattest cloudz!!!!!");
                break;
            case NO_USE:
                System.out.println("No ripping for you hahahaha");
                break;
        }

    }
}


