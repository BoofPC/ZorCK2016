package core;

import java.util.ArrayList;
import verbs.*;
import areas.*;
import core.World.Direction;
import items.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    public static enum Status {
        KEEP_PLAYING, SELF_QUIT, WIN, DIE, SUICIDE
    }
    
    public List<Verb> verbList = new ArrayList<Verb>();
    
    public static void main(String[] args){
        //self explanatory initialization
        Game game = new Game();
        Player player = new Player(10,"Carlton");
        World world = new World();
        
        
        //Register all verbs in the verbList
        game.verbList.add(new Break());
        game.verbList.add(new Buy());
        game.verbList.add(new Choose());
        game.verbList.add(new Climb());             
        game.verbList.add(new Close());
        game.verbList.add(new Credits());
        game.verbList.add(new Curse());
        game.verbList.add(new Diagnostic());
        game.verbList.add(new Drink());
        game.verbList.add(new Drop());
        game.verbList.add(new Eat());
        game.verbList.add(new Examine());
        game.verbList.add(new Give());
        game.verbList.add(new Hello());
        game.verbList.add(new Hit());
        game.verbList.add(new Inventory());
        game.verbList.add(new Light());
        game.verbList.add(new Listen());
        game.verbList.add(new Lock());
        game.verbList.add(new Look());
        game.verbList.add(new Make());
        game.verbList.add(new Move());
        game.verbList.add(new Open());
        game.verbList.add(new Poke());
        game.verbList.add(new Pray());
        game.verbList.add(new Put());
        game.verbList.add(new Quit());
        game.verbList.add(new Read());
        game.verbList.add(new Run());
        game.verbList.add(new Score());
        game.verbList.add(new Sell());
        game.verbList.add(new Shout());
        game.verbList.add(new Sit());
        game.verbList.add(new Smell());
        game.verbList.add(new Stab());
        game.verbList.add(new Stand());
        game.verbList.add(new Suicide());
        game.verbList.add(new Take());
        game.verbList.add(new Talk());
        game.verbList.add(new Taste());
        game.verbList.add(new TurnOff());
        game.verbList.add(new TurnOn());
        game.verbList.add(new Unlock());
        game.verbList.add(new Write());
        
        //Add all Areas to the new world
        world.addArea("Test1",new Test1(world));
        world.addArea("Test2",new Test2(world));
        world.addArea("Test3",new Test3(world));
        world.addArea("Test4",new Test4(world));
        world.addArea("Test5",new Test5(world));
        world.addArea("Test6",new Test6(world));
        world.addArea("Test7",new Test7(world));
        world.addArea("Test8",new Test8(world));
        world.addArea("Test9",new Test9(world));
        world.addArea("Test10",new Test10(world));
        
        //Setting initial area for player
        player.setCurrentArea(world.getArea("Test5"));
        player.addItem(new NoTea());
        Context constr = new Context(player, world);
        Command com;
        
        //Fun printed start stuff
        System.out.println("Welcome to\n" +
            "d8888888P                    a88888b. dP     dP\n" +
            "     .d8'                   d8'   `88 88   .d8'\n" +
            "   .d8'   .d8888b. 88d888b. 88        88aaa8P' \n" +
            " .d8'     88'  `88 88'  `88 88        88   `8b.\n" +
            "d8'       88.  .88 88       Y8.   .88 88     88\n" +
            "Y8888888P `88888P' dP        Y88888P' dP     dP\n\n");
        
        //'enter' first room to get things started
        player.getCurrentArea().enter(player);
        
        //Initial prompt setup
        try (Scanner reader = new Scanner(System.in)) {
            String input = "";
            
            //Main Game Loop
            Status status = Status.KEEP_PLAYING;
            while(status == Status.KEEP_PLAYING){
                System.out.println("You are in room " 
                        + player.getCurrentArea().getTitle());
                
                System.out.print(">");
                input = reader.nextLine();
                System.out.println("");
                if(game.findDirection(input) != null)
                    player.getCurrentArea().interact(new Command(new Move(), null,
                            game.findDirection(input)),constr);
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
                            System.out.println("Where do you expect to find one of those?");
                        }
                    }
                }*/
                else if(game.verbParser(input) != null){
                    //String verb = game.verbParser(input).getTitle();
                    Verb verb = game.verbParser(input);
                    boolean conflict = false;
                    Item noun = null;
                    Item[] nounArray = game.nounParser(input,player);
                    if(nounArray != null){
                        if(nounArray.length == 1) noun = nounArray[0];
                        else conflict = true;
                    }
                    if(!conflict){
                        Direction direction = game.directionParser(input);
                        com = new Command(verb, noun, direction);
                        player.getCurrentArea().interact(com,constr);
                        
                        
                        
                        
                        
                        
                        /*
                        }else if(verb.equals("quit")){
                            status = game.quit();
                        
                        }else if(verb.equals("suicide")){ status = game.suicide(player); }
                       */
                    }else{
                        if(nounArray.length > 3){
                            System.out.print("Did you mean the ");
                            for(int i = 0; i < nounArray.length - 1; i++){
                                System.out.print(nounArray[i].getName() + ", the ");
                            }
                            System.out.println(", or the " 
                                    + nounArray[nounArray.length - 1].getName() + "?");
                        }else{
                            System.out.print("Did you mean the " + nounArray[0].getName() +
                                    " or the " + nounArray[1].getName() + "?");
                        }
                    }
                    status = player.getDeath();
                }
                System.out.println("");
            }
            player.getCurrentArea().interact(new Command(new Score(),null,null),constr);
            System.out.println("");
        }
    }
   
    
    public Verb findVerb(String input){
        for(Verb item : this.verbList){
            if(item.hasMatching(input)) return item;
        }
        return null;
    }
    
    public Item[] findNoun(String input, Player player){
        List<Item> itemList = new ArrayList<Item>();
        for(int i = 0; i < player.listInventory().length; i++){
            itemList.add(player.listInventory()[i]);
        }
        for(int i = 0; i < player.getCurrentArea().listItems().length; i++){
            itemList.add(player.getCurrentArea().listItems()[i]);
        }
        List<Item> returns = new ArrayList<Item>();
        for(int i = 0; i < player.listInventory().length + 
                player.getCurrentArea().listItems().length; i++){
            if(i<player.listInventory().length){
                if(player.listInventory()[i].hasMatching(input))
                    returns.add(player.listInventory()[i]);
            }
            else{
                if(player.getCurrentArea().listItems()
                        [i-player.listInventory().length].hasMatching(input)) 
                    returns.add(player.getCurrentArea().listItems()
                            [i - player.listInventory().length]);
            }
        }
        Item[] itemArray = new Item[returns.size()];
        if(returns.size() > 0) return returns.toArray(itemArray);
        return null;
    }
    
    public Direction findDirection(String input){
        switch (input) {
            case "north":
            case "n":
                return Direction.NORTH;
            case "east":
            case "e":
                return Direction.EAST;
            case "south":
            case "s":
                return Direction.SOUTH;
            case "west":
            case "w":
                return Direction.WEST;
            case "northeast":
            case "ne":
                return Direction.NORTHEAST;
            case "southeast":
            case "se":
                return Direction.SOUTHEAST;
            case "southwest":
            case "sw":
                return Direction.SOUTHWEST;
            case "northwest":
            case "nw":
                return Direction.NORTHWEST;
            case "up":
            case "u":
                return Direction.UP;
            case "down":
            case "d":
                return Direction.DOWN;
            default:
                return null;
        }
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
        return findVerb(verb);
    }
    
    public Item[] nounParser(String input, Player player){
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
            return new Item[]{new NoItem()};
        }
        for(int i = 0; i < inputArraySinVerbos.length; i++){
            inputArraySinVerbos[i] = inputArray[i + t];
        }
        for(int i = inputArraySinVerbos.length; i > 0; i--){
            String nounTest = "";
            if(!inputArraySinVerbos[0].equals(null)) nounTest 
                    += inputArraySinVerbos[0];
            for(int j = 1; j < i; j++){
                nounTest += " ";
                nounTest += inputArraySinVerbos[j];
            }
            if(findNoun(nounTest, player) != null){
                noun = nounTest;
                break;
            }
        }
        Item[] nounArray = new Item[0];
        if(findNoun(noun, player) != null){
            nounArray = new Item[findNoun(noun, player).length];
            for(int i = 0; i < findNoun(noun, player).length; i++){
                nounArray[i] = findNoun(noun, player)[i];
            }
        }
        if(nounArray.length > 0) return nounArray;
        else return null;
    }
    
    public Direction directionParser(String input){
        input = input.toLowerCase();
        
        //convert String input to List, then filter out nulls and verbs
        List<String> inputList = new ArrayList<>(Arrays.asList(input.split("\\s")));
        inputList.removeIf(i -> (i == null || findVerb(i) != null));
        
        if (inputList.isEmpty() || inputList.size() > 1) return null;
        
        return findDirection(inputList.get(0)); 
    }
    
    public int quit(){
        System.out.println("Goodbye!");
        return 1;
    }

}