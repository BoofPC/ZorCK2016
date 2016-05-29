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
public class Hamburger extends Item{
    
    public Hamburger(){
        super();
        setUsageKey(1,1);
        setUsageKey(2,2);
        setName("Hamburger");
        setDescription("Its meat looks succulent and buns look fluffy");
        addSynonym("hamburger");
        addSynonym("burger");
        addSynonym("cheeseburger");
        setTaste("It is the best burger you've ever tasted");
    }
}
