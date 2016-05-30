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
public class Sword extends Item{
    
    public Sword(){
        super();
        setUsageKey(1,1);
        setName("Elvish Sword");
        addSynonym("elvish sword");
        addSynonym("sword");
    }
}
