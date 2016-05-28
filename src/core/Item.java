package core;

/**
 *
 * @author alexb
 */
public class Item {
    private String name;
	public String description;
    public int[] usage = new int[11]; 		//update this number as needed
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
			//{take,eat,drink,open,read,turnOn,move,close,stab,smell,press}
			//feel free to add more
			//the possible statuses of each are as follows:
			//take -	0: unset (default, returns "not takable")
			//			1: takable
			//			2: too heavy
			//			3: bolted down
			//eat -		0: unset (default, returns "not eatable")
			//			1: not eatable
			//			2: eatable
			//drink -	0: unset (default, returns "not drinkable")
			//			1: not drinkable
			//			2: drinkable
			//			3: "You need to open it first!"
			//open -	0: unset (default, returns "not openable")
			//			1: not openable
			//			2: not openable
			//
			//someone should write the rest
			
	public String taste;
	public Item inside;
	public String text; 	//if item is read
	public boolean active;	//if item can be turned on or pressed
	public String smell;
	
    public Item(String name, String description, int[] usage){
        this.name = name;
		for(int i = 0; i < this.usage.length; i++){
			if(i < usage.length) this.usage[i] = usage[i];
			else this.usage[i] = 0;
		}
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
	
	
}
