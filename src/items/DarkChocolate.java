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
public class DarkChocolate extends Item{
    
    public DarkChocolate(){
        super();
        setUsageKey(1,1);
        setUsageKey(2,2);
        setName("Dark Chocolate");
        setDescription("Its looks dark and tasty");
        addSynonym("dark chocolate");
        addSynonym("chocolate");
        addSynonym("chocolate bar");
        setTaste("It tastes like heaven");
    }
}
