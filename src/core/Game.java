package core;
import java.util.ArrayList;
import verbs.*;
import areas.*;
import items.*;
import java.util.Scanner;

/**
 *
 * @author coons5457w & pedro
 */


public class Game {
    
    public ArrayList<Verb> verbList = new ArrayList<Verb>();
    
    private int NORTH = 0;
    private int EAST  = 1;
    private int SOUTH = 2;
    private int WEST  = 3;
    private int NORTH_EAST = 4;
    private int SOUTH_EAST = 5;
    private int SOUTH_WEST = 6;
    private int NORTH_WEST = 7;

    
	
    public static void main(String[] args){
        
        Game game = new Game();
        
        Player player = new Player(10,"Carlton");
        World world = new World();
        
        game.listVerbs();
        
        world.addArea("Test1",new Test1(world));
        world.addArea("Test2",new Test2(world));
        world.addArea("Test3",new Test3(world));
        world.addArea("Test4",new Test4(world));
        world.addArea("Test5",new Test5(world));
        world.addArea("Test6",new Test6(world));
        world.addArea("Test7",new Test7(world));
        world.addArea("Test8",new Test8(world));
        world.addArea("Test9",new Test9(world));
        
        player.setCurrentArea(world.getArea("Test5"));
        
        System.out.println("Welcome to\n\n" +
            "d8888888P                    a88888b. dP     dP\n" +
            "     .d8'                   d8'   `88 88   .d8'\n" +
            "   .d8'   .d8888b. 88d888b. 88        88aaa8P' \n" +
            " .d8'     88'  `88 88'  `88 88        88   `8b.\n" +
            "d8'       88.  .88 88       Y8.   .88 88     88\n" +
            "Y8888888P `88888P' dP        Y88888P' dP     dP\n\n");
        
        Scanner reader = new Scanner(System.in);
        String input = "";
        while(input != "q" && input != "quit"){
            System.out.println("You are in room " + player.getCurrentArea().getTitle());
            if(player.getCurrentArea().getState("First") == true){
                System.out.println(player.getCurrentArea().getInitialDescription());
                player.getCurrentArea().setState("First",false);
            }
            System.out.print("Enter a direction: ");
            input = reader.nextLine();
            if (input.equals("n") || input.equals("north")){
                game.move(0,player,world);
            }
            else if (input.equals("e") || input.equals("east")){
                game.move(1,player,world);
            }
            else if (input.equals("s") || input.equals("south")){
                game.move(2,player,world);
            }
            else if (input.equals("w") || input.equals("west")){
                game.move(3,player,world);
            }
            else if (input.equals("ne") || input.equals("northeast")){
                game.move(4,player,world);
            }
            else if (input.equals("se") || input.equals("southeast")){
                game.move(5,player,world);
            }
            else if (input.equals("sw") || input.equals("southwest")){
                game.move(6,player,world);
            }
            else if (input.equals("nw") || input.equals("northwest")){
                game.move(7,player,world);
            }
            else if (input.equals("u") || input.equals("up")){
                game.move(8,player,world);
            }
            else if (input.equals("d") || input.equals("down")){
                game.move(9,player,world);
            }
            else if(game.verbParser(input) != null){
                System.out.println(game.verbParser(input).getTitle());
                if(game.verbParser(input).getUsageKey(1)){
                    System.out.println(game.nounParser(input,player).getName());
                }
            }
            else if (!input.equals("q") || input.equals("quit")){
                System.out.println("That command has no verb?");
            }
        }
        System.out.println("Quiting.");
    }
    
    public void listVerbs(){
        
        this.verbList.add(new Examine());
        this.verbList.add(new Look());
        this.verbList.add(new Move());
        this.verbList.add(new Open());
        this.verbList.add(new Shout());
        this.verbList.add(new Take());
        this.verbList.add(new TurnOff());
        this.verbList.add(new TurnOn());
        //...
        
    }
    
    public Verb findVerb(String input){
        for(Verb item : this.verbList){
            if(item.hasMatching(input)) return item;
        }
        return null;
    }
    
    public Item findNoun(String input, Player player){
        ArrayList<Item> itemList = new ArrayList<Item>();
        for(int i = 0; i < player.listInventory().length; i++){
            itemList.add(player.listInventory()[i]);
        }
        for(int i = 0; i < player.getCurrentArea().listItems().length; i++){
            itemList.add(player.getCurrentArea().listItems()[i]);
        }
        for(Item item: itemList){
            if(item.hasMatching(input)) return item;
        }
        return null;
    }
    
    public Verb verbParser(String input){
        input = input.toLowerCase();
        int s = 1;
        String verb = "";
        for(int i = 0; i < input.length(); i++){
            if(input.substring(i,i+1).equals(" ")) s++;
        }
        String[] inputArray = new String[s];
        int n = 0;
        for (String retval: input.split(" ")){
            inputArray[n] = retval;
            n++;
        }
        for(int i = inputArray.length; i > 0; i--){
            String verbTest = "";
            if(!inputArray[0].equals(null)) verbTest += inputArray[0];
            for(int j = 1; j < i; j++){
                verbTest += " ";
                verbTest += inputArray[j];
            }
            if(findVerb(verbTest) != null){
                verb = verbTest;
                break;
            }
        }
        if(verb != null) return findVerb(verb);
        else return null;
    }
    
    public Item nounParser(String input, Player player){
        input = input.toLowerCase();
        int s = 1;
        int t;
        String verb = "";
        String noun = "";
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
        for(int i = inputArray.length; i > 0; i--){
            String verbTest = "";
            if(!inputArray[0].equals(null)) verbTest += inputArray[0];
            for(int j = 1; j < i; j++){
                verbTest += " ";
                verbTest += inputArray[j];
            }
            if(findVerb(verbTest) != null){
                verb = verbTest;
                t = i;
                inputArraySinVerbos = new String[inputArray.length - t];
                break;
            }
        }
        if(inputArraySinVerbos.length == 0){
            return new NoItem();
        }
        for(int i = inputArraySinVerbos.length; i > 0; i--){
            String nounTest = "";
            if(!inputArray[0].equals(null)) nounTest += inputArray[0];
            for(int j = 1; j < i; j++){
                nounTest += " ";
                nounTest += inputArray[j];
            }
            if(findNoun(nounTest, player) != null){
                noun = nounTest;
                break;
            }
        }
        if(noun != null) return findNoun(noun, player);
        else return null;
    }
	
    public void move(int direction, Player player, World world){
        if(player.getCurrentArea().getPortal(direction).isLocked()){
            System.out.println("You can't go that way!");
        }else{
            player.setCurrentArea(world.getArea(player.getCurrentArea().getPortal(direction).getTarget()));
            System.out.print(player.getName() + " moved ");
            if(direction == 0){
                System.out.println("north");
            }else if(direction == 1){
                System.out.println("east");
            }else if(direction == 2){
                System.out.println("south");
            }else if(direction == 3){
                System.out.println("west");
            }else if(direction == 4){
                System.out.println("northeast");
            }else if(direction == 5){
                System.out.println("southeast");
            }else if(direction == 6){
                System.out.println("southwest");
            }else if(direction == 7){
                System.out.println("northwest");
            }else if(direction == 8){
                System.out.println("up");
            }else if(direction == 9){
                System.out.println("down");
            }
        }
    }
        
    public void take(Item item, Area currentArea, Player player){
        if(currentArea.ifItem(item)){
            currentArea.removeItem(item);
            player.addItem(item);
        }
    }

    public String[] look(Area currentArea){
        String[] desc;
        if(currentArea.listItems().length == 0){
            desc = new String[1];
            desc[0] = currentArea.getDescription();
        }else{
            desc = new String[currentArea.listItems().length +3];
            desc[0] = currentArea.getDescription();
            desc[2] = "This Area contains:";
            for(int i = 0; i < currentArea.listItems().length; i++){
                desc[3+i] = currentArea.listItems()[i].getName();
            }
        }
        return desc;
    }
}
