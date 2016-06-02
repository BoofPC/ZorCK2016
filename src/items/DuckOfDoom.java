/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package items;
import core.*;

/**
 *
 * @author fischer5731c
 */
public class DuckOfDoom extends Item{
    public DuckOfDoom(){
        super();
        setUsageKey(Item.TAKE,1);
        setUsageKey(Item.EAT,1);
        setName("Duck");
        addSynonym("duck");
        addSynonym("duckofdoom");
        addSynonym("duck of doom");
        addSynonym("duckling");
        addSynonym("duckery");
        addSynonym("mallard");
        addSynonym("loon");
    }
    
    @Override
    public void interact(Command command, Context context){
        if(command.getVerb().getTitle().equals("take")) {
            System.out.println("You should know better than to pick up a duck in a dungeon!");
            context.getPlayer().addHp(-5);
        }
    }
    
}
