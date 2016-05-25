
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author coons5457w & pedro
 */


public class Game {
    
    public ArrayList<Verb> verbList;
    
    public static void main(String[] args){
        
        World world = new World(3);
        
        for (int row = 0; row < 3; row++){ //creates World
            for (int col = 0; col < 3; col++){
                if ((col == 1 && row == 0)||(col == 0 && row == 1)||(col == 2 && row == 1)||(col == 1 && row == 2)){
                    world.setAccessibilityNorth(row, col, true);
                    world.setAccessibilitySouth(row, col, true);
                    world.setAccessibilityEast(row, col, true);
                    world.setAccessibilityWest(row, col, true);
                    
                }
                else{
                    world.setAccessibilityNorth(row, col, false);
                    world.setAccessibilitySouth(row, col, false);
                    world.setAccessibilityEast(row, col, false);
                    world.setAccessibilityWest(row, col, false);
                }
                world.addArea(row, col, world.getAreaAt(row, col));
            }
        }
        System.out.println("Welcome to ZorCK.");
        System.out.println("");
        int x = 1;
        int y = 1;
        Scanner reader = new Scanner(System.in);
        char letter = 'a';
        while(letter != 'q'){
            System.out.println("You are in room " + x + ", " + y + ".");
            world.getAreaAt(x, y);
            System.out.print("Enter a direction: ");
            letter = reader.next().charAt(0);
            if (letter == 'n'){
                if (y == 0){
                    System.out.println("You can't go that way.");
                }
                else {
                    y--;
                }
            }
            else if (letter == 'e'){
                if (x == 2){
                    System.out.println("You can't go that way.");
                }
                else {
                    x++;
                }
            }
            else if (letter == 's'){
                if (y == 2){
                    System.out.println("You can't go that way.");
                }
                else {
                    y++;
                }
            }
            else if (letter == 'w'){
                if (x == 0){
                    System.out.println("You can't go that way.");
                }
                else {
                    x--;
                }
            }
            else if (letter != 'q'){
                System.out.print("That is an invalid choice.");
            }
        }
        System.out.println("Quiting.");
    }
    
    public void listVerbs(){
        this.verbList.add(new Look());
        this.verbList.add(new Examine());
        //...
    }
    
    public Verb findVerb(String input){
        for(Verb item : this.verbList){
            if(item.findMatching(input)) return item;
        }
        return null;
    }
    
    public void parser(String input){
        String verb = "";
        int s = 1;
        for(int i = 0; i < input.length(); i++){
            if(input.substring(i,i+1).equals(" ")) s++;
        }
        String[] inputArray = new String[s];
        String[] inputArraySinVerbos = new String[0];
        int n = 0;
        for (String retval: input.split(" ")){
            inputArray[n] = retval;
            n++;
        }
        outerLoop:
        for(int i = inputArray.length; i > 0; i--){
            for(int j = 0; j <= inputArray.length - i; j++){
                String verbTest = "";
                if(!inputArray[0].equals(null)) verbTest += inputArray[0];
                for(int k = 1; k < i; k++){
                    verbTest += " ";
                    verbTest += inputArray[k];
                }
                if(findVerb(verbTest) != null){
                    verb = verbTest;
                    inputArraySinVerbos = new String[inputArray.length - i - j];
                    int q = 0;
                    for(int k = i+j; k < inputArray.length; k++){
                        inputArraySinVerbos[q] = inputArray[k];
                    }
                    break outerLoop;
                }
            }
            throw new IllegalArgumentException("NO VERB");
        }
        if(findVerb(verb).checkUsageKey(0) && inputArraySinVerbos.length == 0){
            
        }else{
            if(findVerb(verb).checkUsageKey(1) && inputArraySinVerbos.length > 0){
                
            }else if(findVerb(verb).checkUsageKey(2) && inputArraySinVerbos.length > 0){
                
            }
        }
        //still need to finish the part where it takes a noun or direction
        
    }
}
