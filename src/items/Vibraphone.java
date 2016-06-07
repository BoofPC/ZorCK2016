/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package items;

import core.Item;

/**
 *
 * @author flowers9695r
 */
public class Vibraphone extends Item{
    
    public Vibraphone(){
        super();
        setUsageKey(1,2);
        setName("Vibraphone");
        addSynonym("vibraphone");
        addSynonym("not a marimba");
        addSynonym("not a xylophone");
        addSynonym("not a glockenspiel");
        addSynonym("not a rachel");
        addSynonym("not a cat");
        addSynonym("not a dog");
        addSynonym("not a tree");
        addSynonym("not a timpani");
        addSynonym("not a snare");
        addSynonym("not a drum");
        addSynonym("not a bass drum");
        addSynonym("not a piano");
        setDescription("A very strange looking piano. It has brassy looking bars"
                + " across the top with tube underneath. There appears to be a"
                + " motor attached to a flippy thing between the bars and tubes.");
        setInside(new Motor());
    }
}
