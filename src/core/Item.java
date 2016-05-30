package core;

import java.util.ArrayList;


/**
 *
 * @author pedro
 */
public class Item {
    private String name;
    public String description;
    public int[] usage = new int[14]; 		//update this number as needed
			//usage is an array of ints which determines many
			//characteristics of an item. Each item in the 
			//array corresponds with an attribute of the item
			//for example the first item in the array represents
			//whether the item is takable, with different numbers
			//as different statuses. 0 is always "unset." 1 is "takable," the user can 
			//"take" the item to get it into their inventory. 2 means the item is too 
			//heavy to take, and will return an appropriate message if "take (item)" 
			//is invoked. 3 means the item is bolted down, etc.
			//
			//The meanings of each item is as follows:
                        //{0      ,1   ,2  ,3    ,4   ,5   ,6   ,7     ,8   ,9   ,10   ,11  ,12   ,13    
			//{[dummy],take,eat,drink,open,lock,read,turnOn,move,wear,close,stab,press,climb}
			//feel free to add more
			//the possible statuses of each are as follows:
			//take (n = 1) -    0: unset (default, returns "not takable")
			//                  1: takable
			//                  2: too heavy
			//                  3: bolted down
			//eat (n = 2) -     0: unset (default, returns "not eatable")
			//                  1: not eatable
			//                  2: eatable
			//drink (n = 3) -   0: unset (default, returns "not drinkable")
			//                  1: not drinkable
			//                  2: drinkable
			//                  3: "You need to open it first!"
			//open (n = 4) -    0: unset (default, returns "not openable")
			//                  1: not openable
			//                  2: openable, closed
                        //                  3: openable, open
                        //lock (n = 5) -    0: unset {default, returns "not lockable")
                        //                  1: not lockable
                        //                  2: lockable, unlocked
                        //                  3: lockable, locked
			//read (n = 6) -    0: unset (default, returns "not readable")
                        //                  1: not readable
                        //                  2: readable
                        //                  3: illegible
                        //move (n = 7) -    0: unset (default, returns "not movable")
                        //                  1: unmovable
                        //                  2: movable
                        //wear (n = 8) -    0: unset (default, returns "not wearable")
                        //                  1: unwearable
                        //                  2: wearable
                        //close (n = 9) -   0: unset (default, returns "not closeable")
                        //                  1: not closable
                        //                  2: closable, open
                        //                  3: closable, closed
                        //stab (n = 10) -   0: unset (default, returns "not stabable")
                        //                  1: not stabable
                        //                  2: stabable
                        //turnOn (n = 11) - 0: unset (default, returns "not turnOnable")
			//                  1: not turnOnable
			//                  2: turnOnable, off
                        //                  3: turnOnable, on
                        //press (n = 12) -  0: unset (default, returns "not pressable")
                        //                  1: not pressable
                        //                  2: pressable, unpressed
                        //                  3: pressable, pressed
                        //climb (n = 13) -  0: unset (default, returns "not climbable")
                        //                  1: not climbable
                        //                  2: climbable
                        //someone should write the rest
                        //
                        //
			//the first item, represented here as [duumy], refers to
                        //whether the item is a real, tangible, and distinct
                        //object which should be described when "look" is called
                        //(e.g. a screwdriver) or an item which should be hidden
                        //unless interacted with (e.g. a pocket on a gown
                        //[dummy] -     0: unset (default, returns "real")
                        //              1: real
                        //              2: not real
			
    public String taste;
    public Item inside;
    public String text; 	//if item is read
    public boolean active;	//if item can be turned on or pressed
    public String smell;
    public String sound;
    public Item key;
    public Portal portal;
    public ArrayList<String> synonyms;
	
    public Item(){
        for(int i = 0; i < this.usage.length; i++){
            this.usage[i] = 0;
        }
        this.synonyms = new ArrayList<String>();
    }
    
    public String getName(){
        return this.name;
    }
	
    public void setName(String name){
	this.name = name;
    }
	
    public String getDescription(){
        return this.description;
    }
	
    public void setDescription(String description){
        this.description = description;
    }
	
    public int getUsageKey(int n){
        if(n < this.usage.length) return this.usage[n];
        else return -1;
    }
	
    public void setUsageKey(int n, int state){
        if(n < this.usage.length) usage[n] = state;
    }
	
    public String getTaste(){
        return this.taste;
    }
	
    public void setTaste(String taste){
        this.taste = taste;
    }
	
    public Item getInside(){
        return this.inside;
    }
	
    public void setInside(Item inside){
        this.inside = inside;
    }
	
    public String getText(){
        return this.text;
    }
	
    public void setText(String text){
        this.text = text;
    }
	
    public boolean getActive(){
        return this.active;
    }
	
    public void setActive(boolean active){
        this.active = active;
    }
	
    public String getSmell(){
        return this.smell;
    }
	
    public void setSmell(String smell){
        this.smell = smell;
    }
    
    public String getSound(){
        return this.sound;
    }
	
    public void setSound(String sound){
        this.sound = sound;
    }
    
    public Item getKey(){
        return this.key;
    }
	
    public void setKey(Item key){
        this.key = key;
    }

    public Portal getPortal(){
        return this.portal;
    }
    
    public void setPortal(Portal portal){
        this.portal = portal;
    }
    
    public void addSynonym(String str){
        this.synonyms.add(str);
    }
    
    public boolean hasMatching(String str){
        for(String item: this.synonyms){
            if(item.equals(str)) return true;
        }
        return false;
    }
    
    public void drop(Area area){
        if(getInside() !=  null){
            area.addItem(getInside());
            setInside(null);
        }
    }
    
    
    public void synchronizeDoor(World world, Area currentArea){
        Portal portal;
        portal = getPortal();
        Area target;
        target = world.getArea(portal.getTarget());
        int oppDir;
        if(currentArea.getDirection(portal) < 4){
            oppDir = currentArea.getDirection(portal) - 2;
            if(oppDir < 0) oppDir += 4;
        }else if(currentArea.getDirection(portal) < 8){
            oppDir = currentArea.getDirection(portal) - 2;
            if(oppDir < 4) oppDir += 4;
        }else{
            if(currentArea.getDirection(portal) == 8) oppDir = 9;
            else oppDir = 8;
        }
        
        Item oppDoor;
        oppDoor = target.getPortal(oppDir).getDoor(target);
        
        if(getUsageKey(5) == 3){
            target.getPortal(oppDir).lock();
            if(oppDoor != null)
                oppDoor.setUsageKey(5,3);
        }else{
            target.getPortal(oppDir).unlock();
            if(oppDoor != null)
                oppDoor.setUsageKey(5,2);
        }
    }
}
