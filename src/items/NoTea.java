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
public class NoTea extends Item{
    
    public NoTea(){
        super();
        setUsageKey(1,1);
        setName("No Tea");
        setDescription("What? That makes no sense. Pull yourself together!");
        addSynonym("no tea");
    }
}
