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
public class Piano extends Item{
    
    public Piano(){
        super();
        setUsageKey(1,2);                   //The object cannot be taken
        setName("Piano");
        addSynonym("piano");
        addSynonym("keyboard");
        addSynonym("Keyboard");
        setDescription("A very sad piano. It looks like its waiting for its Mozart");
    }
}
