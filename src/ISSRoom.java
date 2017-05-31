
import tbge.Area;
import tbge.Door;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rodrigu3163b
 */
public class ISSRoom extends Area{
    private String laterDescription = 
    public ISSRoom(){
        super("ISS Room");
        this.getDoors().put(Direction.NORTH,new Door("Hallway"));
        this.getInventory().add("Sword");
    }
    
}
