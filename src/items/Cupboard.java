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
public class Cupboard extends Item{
    
    public Cupboard(){
        super();
        setUsageKey(4,2);                   //The object cannot be taken
        setUsageKey(10,3);
        setUsageKey(1,3);
        setName("Cupboard");
        addSynonym("cupboard");
        addSynonym("cabinet");
        addSynonym("Cabinet");
        if(getUsageKey(4) == 3 || getUsageKey(10) == 2){
            setDescription("A creepy frog face stares back at you. You realize "
                    + "it's made out of tape. It seems vaugely familiar,"
                    + " almost like a meme or something.");
        }else{
            setDescription("A cupboard with potentially possible potential.");
        }
        setInside(new MagicOrb());
    }
}
