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
        
        int quit = 0;
        
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
        player.addItem(new NoTea());
        
        System.out.println("Welcome to\n\n" +
            "d8888888P                    a88888b. dP     dP\n" +
            "     .d8'                   d8'   `88 88   .d8'\n" +
            "   .d8'   .d8888b. 88d888b. 88        88aaa8P' \n" +
            " .d8'     88'  `88 88'  `88 88        88   `8b.\n" +
            "d8'       88.  .88 88       Y8.   .88 88     88\n" +
            "Y8888888P `88888P' dP        Y88888P' dP     dP\n\n");
        
        Scanner reader = new Scanner(System.in);
        String input = "";
        while(quit == 0){
            System.out.println("You are in room " + player.getCurrentArea().getTitle());
            if(player.getCurrentArea().getState("First") == true){
                System.out.println(player.getCurrentArea().getInitialDescription());
                player.getCurrentArea().setState("First",false);
            }
            System.out.print("Enter a command: ");
            input = reader.nextLine();
            System.out.println("");
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
            //code to test parsers
            /*else if(game.verbParser(input) != null){
                System.out.println(game.verbParser(input).getTitle());
                if(game.verbParser(input).getUsageKey(1)){
                    if(game.nounParser(input,player) != null){
                        if(!game.nounParser(input,player).getName().equals("noItem"))
                            System.out.println(game.nounParser(input,player).getName());
                        else if(!game.verbParser(input).getUsageKey(0))
                            System.out.println("Ya need a noun, ya dingus");
                    }else{
                        System.out.println("That's no noun I know!");
                    }
                }
            }*/
            else if(game.verbParser(input) != null){
                String verb = game.verbParser(input).getTitle();
                Item noun = game.nounParser(input,player);
                int direction = game.directionParser(input);

                if(verb.equals("take")){
                    if(noun != null){
                        if(!noun.getName().equals("noItem")){
                            game.take(noun,player);
                        }
                        else System.out.println("Ya need a noun, ya dingus");
                    }else{
                        System.out.println("That's no noun I know!");
                    }
                }else if(verb.equals("look")){ game.look(player); }
                else if(verb.equals("move")){
                    if(direction != -1) game.move(direction,player,world);
                    else System.out.println("Ya need a direction, ya dingus");
                }else if(verb.equals("inventory")){ game.inventory(player); }
                else if(verb.equals("examine")){
                    if(noun != null){
                        if(!noun.getName().equals("noItem")){
                            game.examine(noun);
                        }
                        else System.out.println("Ya need a noun, ya dingus");
                    }else{
                        System.out.println("That's no noun I know!");
                    }
                }
                
            }
            System.out.println("");
        }
        System.out.println("Quiting.");
    }
    
    public void listVerbs(){
        
        this.verbList.add(new Climb());
        this.verbList.add(new Close());
        this.verbList.add(new Diagnostic());
        this.verbList.add(new Drink());
        this.verbList.add(new Drop());
        this.verbList.add(new Eat());
        this.verbList.add(new Examine());
        this.verbList.add(new Hit());
        this.verbList.add(new Inventory());
        this.verbList.add(new Listen());
        this.verbList.add(new Look());
        this.verbList.add(new Move());
        this.verbList.add(new Open());
        this.verbList.add(new Poke());
        this.verbList.add(new Pray());
        this.verbList.add(new Quit());
        this.verbList.add(new Read());
        this.verbList.add(new Restart());
        this.verbList.add(new Score());
        this.verbList.add(new Shout());
        this.verbList.add(new Sniff());
        this.verbList.add(new Suicide());
        this.verbList.add(new Take());
        this.verbList.add(new Taste());
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
        for(int i = 0; i < player.listInventory().length + player.getCurrentArea().listItems().length; i++){
            if(i<player.listInventory().length){
                if(player.listInventory()[i].hasMatching(input))return player.listInventory()[i];
            }
            else{
                if(player.getCurrentArea().listItems()[i-player.listInventory().length].hasMatching(input)) return player.getCurrentArea().listItems()[i - player.listInventory().length];
            }
        }
        
        return null;
    }
    
    public int findDirection(String input){
        if(input.equals("north") || input.equals("n")) return 0;
        else if(input.equals("east") || input.equals("e")) return 1;
        else if(input.equals("south") || input.equals("s")) return 2;
        else if(input.equals("west") || input.equals("w")) return 3;
        else if(input.equals("northeast") || input.equals("ne")) return 4;
        else if(input.equals("southeast") || input.equals("se")) return 5;
        else if(input.equals("southwest") || input.equals("sw")) return 6;
        else if(input.equals("northwest") || input.equals("nw")) return 7;
        else if(input.equals("up") || input.equals("u")) return 8;
        else if(input.equals("down") || input.equals("d")) return 9;
        else return -1;
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
        int t = 0;
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
                t = i;
                inputArraySinVerbos = new String[inputArray.length - t];
                break;
            }
        }
        if(inputArraySinVerbos.length == 0){
            return new NoItem();
        }
        for(int i = 0; i < inputArraySinVerbos.length; i++){
            inputArraySinVerbos[i] = inputArray[i + t];
        }
        for(int i = inputArraySinVerbos.length; i > 0; i--){
            String nounTest = "";
            if(!inputArraySinVerbos[0].equals(null)) nounTest += inputArraySinVerbos[0];
            for(int j = 1; j < i; j++){
                nounTest += " ";
                nounTest += inputArraySinVerbos[j];
            }
            if(findNoun(nounTest, player) != null){
                noun = nounTest;
                break;
            }
        }
        if(noun != null) return findNoun(noun, player);
        else return null;
    }
    
    public int directionParser(String input){
        input = input.toLowerCase();
        int s = 1;
        int t = 0;
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
                t = i;
                inputArraySinVerbos = new String[inputArray.length - t];
                break;
            }
        }
        if(inputArraySinVerbos.length == 0 || inputArraySinVerbos.length > 1){
            return -1;
        }
        for(int i = 0; i < inputArraySinVerbos.length; i++){
            inputArraySinVerbos[i] = inputArray[i + t];
        }
        return findDirection(inputArraySinVerbos[0]);
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
        
    public void take(Item item, Player player){
        if(player.getCurrentArea().ifItem(item)){
            player.getCurrentArea().removeItem(item);
            player.addItem(item);
            System.out.println(player.getName() + " took the " + item.getName());
        }
        else System.out.println("Where do you expect to find one of those?");
    }

    public void look(Player player){
        String[] desc;
        if(player.getCurrentArea().listItems().length == 0){
            desc = new String[1];
            desc[0] = player.getCurrentArea().getDescription();
        }else{
            desc = new String[player.getCurrentArea().listItems().length +3];
            desc[0] = player.getCurrentArea().getDescription();
            desc[1] = "";
            desc[2] = "This Area contains:";
            for(int i = 0; i < player.getCurrentArea().listItems().length; i++){
                desc[3+i] = player.getCurrentArea().listItems()[i].getName();
            }
        }
        for(String item: desc){
            System.out.println(item);
        }
    }
    
    public void inventory(Player player){
        System.out.println(player.getName() + " has:");
        if(player.listInventory().length == 0) System.out.println("\tNothing!");
        for(int i = 0; i < player.listInventory().length; i++){
            System.out.println("\t" + player.listInventory()[i].getName());
        }
    }
    
    public void examine(Item item){
        System.out.println(item.getDescription());
    }
    
    
    
}
