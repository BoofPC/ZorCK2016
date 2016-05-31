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
public class WhiteChocolate extends Item{
    
    public WhiteChocolate(){
        super();
        setUsageKey(1,1);
        setUsageKey(2,2);
        setName("White Chocolate");
        setDescription("Its looks light and disgusting");
        addSynonym("white chocolate");
        addSynonym("chocolate");
        addSynonym("chocolate bar");
        setTaste("It tastes like hell");
    }
}
