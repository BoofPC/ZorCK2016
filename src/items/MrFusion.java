/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;
import core.Item;
/**
 *
 * @author Alex Johnson
 */
public class MrFusion extends Item {
    public MrFusion(){
        super();
        setUsageKey(1, 1);
        //not drinkable because you need it for the time machine
        setName("Mr.Fusion");
        setDescription("This is one of the parts of the time"
                + " machine!");
        addSynonym("Mr Fusion");
        addSynonym("mr fusion");
        addSynonym("mr. fusion");
    }
}
