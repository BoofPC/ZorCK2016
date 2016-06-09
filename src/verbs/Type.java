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
public class Type extends Verb{

    public Type() {
        super("type", Verb.usage().arbitrary());
    }

    @Override
    public void run(final Command command, final Context construct) {
        System.out.println("I'm not sure where you want to type that.");
    }
}
