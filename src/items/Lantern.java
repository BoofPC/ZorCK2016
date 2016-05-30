/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import core.Item;

/**
 *
 * @author pedro
 */
public class Lantern extends Item{
    
    public Lantern(){
        super();
        setUsageKey(1,1);
        setUsageKey(7,2);
        setName("Lantern");
        addSynonym("lantern");
        addSynonym("light");
        addSynonym("flashlight");
        
    }
}
