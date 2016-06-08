/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package items;

import core.Command;
import core.Context;
import core.Item;

/**
 *
 * @author flowers9695r
 */
public class Vibraphone extends Item{
    
    public Vibraphone(){
        super();
        this.usage().take(Item.TOO_HEAVY);
        this.name("Vibraphone")
        .synonym("vibraphone")
        .synonym("not a marimba")
        .synonym("not a xylophone")
        .synonym("not a glockenspiel")
        .synonym("not a rachel")
        .synonym("not a cat")
        .synonym("not a dog")
        .synonym("not a tree")
        .synonym("not a timpani")
        .synonym("not a snare")
        .synonym("not a drum")
        .synonym("not a bass drum")
        .synonym("not a piano")
        .description("A very strange looking piano. It has brassy looking bars"
                + " across the top with tube underneath. There appears to be a"
                + " motor attached to a flippy thing between the bars and tubes.")
        .inside(new Motor());
    }
    
    @Override
    public void interact(final Command command, final Context context){

    }
}
