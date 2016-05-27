package core;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
			//			2: not takable
			//
			//someone should write the rest
			
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
	
	public String getDescription(){
		return this.description;
	}
	
	public int getUsageKey(int n){
		if(n < this.usage.length) return this.usage[n];
		else return -1;
	}
}
