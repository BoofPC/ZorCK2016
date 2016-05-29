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
public class Door extends Item{
    
    public Door(boolean locked,String name){
        super();
        setUsageKey(1,3);
        setUsageKey(4,2);
        if(locked){
            setUsageKey(5,3);
            setName("Locked Door");
            setDescription("You gotta find some way to unlock it!");
            addSynonym("locked door");
        }else{
            setUsageKey(5,2);
            setName("Door");
            setDescription("Whelp, that's a door alright!");
        }
        if(name != null){
            setName(name);
            addSynonym(name.toLowerCase());
        }
        addSynonym("door");
    }
}
