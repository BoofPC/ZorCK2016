
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author coons5457w
 */


public class Game {
    public static void main(String[] args){
        World world = new World(3);
        for (int row = 0; row < 3; row++){ //creates World
            for (int col = 0; col < 3; col++){
                if ((col == 1 && row == 0)||(col == 0 && row == 1)||(col == 2 && row == 1)||(col == 1 && row == 2)){
                    world.setAccessibility(row, col, true);
                }
                else{world.setAccessibility(row, col, false);}
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
}
