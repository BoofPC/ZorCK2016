
import tbge.Area;
import tbge.Context;
import tbge.Door;
import tbge.Game;
import tbge.VerbPhrase;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rodrigu3163b
 */
//TODO edit change to later description so that it happens on look and look around->only works on description now,
// which might be confusing to players.
public class BroadCastingRoom extends Area{
    private String laterDescription = "There are some tables in this room, in front of large green walls, with cameras staring at them.";
    private String penDescription = "\nThere seems to be a red pen on one of the tables. ";
    
    public BroadCastingRoom(){
        super("Broadcasting Room");
        this.getDoors().put(Area.Direction.EAST,new Door("Adamson's Room"));
        this.getInventory().add("pen");
        
        this.description = "The walls are a lime green that are plastered with light by bright stage lights."
                + "\nTwo desks face three large cameras meant for recording the broadcast for Fridays. On the "
                + "\nother side of the room, there are stairs that lead up to a small balcony, overlooking the "
                + "\nroom. There seems to be a red pen on one of the tables.";
        
        this.getLocalActions().put(new VerbPhrase("description"), (c)->{
            System.out.println(description);
            description = laterDescription;
            if(this.getInventory().contains("pen")){
                description += penDescription;
            }
            return !Game.GO_TO_NEXT;
        });

        this.getLocalActions().put(new VerbPhrase("look"), (c)->{
            System.out.println(description);
            description = laterDescription;
            if(this.getInventory().contains("pen")){
                description += penDescription;
            }
            return !Game.GO_TO_NEXT;
        });
        
        this.getLocalActions().put(new VerbPhrase("take", "pen"), (c)->{
            if(this.getInventory().contains("pen")){
                ((ZorCK)(c.getGame())).addPoints(10);
                System.out.println("You got a red pen. Mr.Booth needed this, you should give it to him.");
                c.getPlayer().getInventory().add("pen");
                this.getInventory().remove("pen");
            }
            return !Game.GO_TO_NEXT;
            });
        
        
    }
        public boolean captureInput(VerbPhrase v, Context c){
        return Game.GO_TO_NEXT;
    }
}
