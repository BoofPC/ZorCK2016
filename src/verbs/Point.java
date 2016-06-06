/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package verbs;

import core.*;
import java.util.Arrays;

/**
 *
 * @author fischer5731c
 */
public class Point extends Verb{
    public Point() {
        super("point",
                Arrays.asList("aim"),
                Verb.usage().noun());
    }

    @Override
    public void run(Command command, Context construct) {
        //will make it work with laser pointer
        System.out.println("It is rude to point!");
    }
}
