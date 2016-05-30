package core;
import java.util.ArrayList;
import verbs.*;
import areas.*;
import items.*;
import java.util.Random;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author coons5457w & pedro & Samantha
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
    private int UP = 8;
    private int DOWN = 9;
    
	
    public static void main(String[] args){
        
        Game game = new Game();
        
        Player player = new Player(10,"Carlton");
        World world = new World();
        
        game.listVerbs();
        
        int quit = 0;       //Possible quit statuses:
                            //      0: not quit
                            //      1: self-quit (typed command "quit")
                            //      2: won game
                            //      3: died
                            //      4: suicide!
        
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
        
        System.out.println("Welcome to\n" +
            "d8888888P                    a88888b. dP     dP\n" +
            "     .d8'                   d8'   `88 88   .d8'\n" +
            "   .d8'   .d8888b. 88d888b. 88        88aaa8P' \n" +
            " .d8'     88'  `88 88'  `88 88        88   `8b.\n" +
            "d8'       88.  .88 88       Y8.   .88 88     88\n" +
            "Y8888888P `88888P' dP        Y88888P' dP     dP\n\n");
        
        Scanner reader = new Scanner(System.in);
        String input = "";
        while(quit == 0){
            System.out.println("You are in room " 
                    + player.getCurrentArea().getTitle());
            if(player.getCurrentArea().getState("First") == true){
                System.out.println(
                        player.getCurrentArea().getInitialDescription());
                player.getCurrentArea().setState("First",false);
            }
            System.out.print("Enter a command: ");
            input = reader.nextLine();
            System.out.println("");
            if(game.findDirection(input) != -1)
                game.move(game.findDirection(input),player,world);
            System.out.println(""); 
            if(game.directionParser(input) != -1) {
                game.move(game.directionParser(input), player, world);
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
                        System.out.println("Where do you expect to find one of those?");
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
                        System.out.println("Where do you expect to find one of those?");
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
                        System.out.println("Where do you expect to find one of those?");
                    }
                }else if(verb.equals("climb")){
                    if(noun != null){
                        if(!noun.getName().equals("noItem")){
                            game.climb(noun,player,world);
                        }
                        else game.climb(null,player,world);
                    }else{
                        System.out.println("Where do you expect to find one of those?");
                    }
                }else if(verb.equals("quit")){
                    quit = game.quit();
                }else if(verb.equals("score")){ game.score(player); }
                else if(verb.equals("diagnostic")){ game.diagnostic(player); }
                else if(verb.equals("eat")){
                    if(noun != null){
                        if(!noun.getName().equals("noItem")){
                            game.eat(noun,player);
                        }
                        else System.out.println("Ya need a noun, ya dingus");
                    }else{
                        System.out.println("Where do you expect to find one of those?");
                    }
                }else if(verb.equals("taste")){
                    if(noun != null){
                        if(!noun.getName().equals("noItem")){
                            game.taste(noun);
                        }
                        else game.taste(player.getCurrentArea());
                    }else{
                        System.out.println("Where do you expect to find one of those?");
                    }
                }else if(verb.equals("smell")){
                    if(noun != null){
                        if(!noun.getName().equals("noItem")){
                            game.smell(noun);
                        }
                        else game.smell(player.getCurrentArea());
                    }else{
                        System.out.println("Where do you expect to find one of those?");
                    }
                }else if(verb.equals("shout")){ game.shout(); }
                else if(verb.equals("hello")){ game.hello(); }
                else if(verb.equals("credits")){ game.credits(); }
                
                
            }
            System.out.println("");
        }
        game.score(player);
        System.out.println("Goodbye!");
        System.out.println("");
    }
    
    public void listVerbs(){
        
        this.verbList.add(new Climb());
        this.verbList.add(new Close());
        this.verbList.add(new Credits());
        this.verbList.add(new Diagnostic());
        this.verbList.add(new Drink());
        this.verbList.add(new Drop());
        this.verbList.add(new Eat());
        this.verbList.add(new Examine());
        this.verbList.add(new Hello());
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
        this.verbList.add(new Smell());
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
        for(int i = 0; i < player.listInventory().length + 
                player.getCurrentArea().listItems().length; i++){
            if(i<player.listInventory().length){
                if(player.listInventory()[i].hasMatching(input))
                    return player.listInventory()[i];
            }
            else{
                if(player.getCurrentArea().listItems()
                        [i-player.listInventory().length].hasMatching(input)) 
                    return player.getCurrentArea().listItems()
                            [i - player.listInventory().length];
            }
        }
        
        return null;
    }
    
    public int findDirection(String input){
        switch (input) {
            case "north":
            case "n":
                return NORTH;
            case "east":
            case "e":
                return EAST;
            case "south":
            case "s":
                return SOUTH;
            case "west":
            case "w":
                return WEST;
            case "northeast":
            case "ne":
                return NORTH_EAST;
            case "southeast":
            case "se":
                return SOUTH_EAST;
            case "southwest":
            case "sw":
                return SOUTH_WEST;
            case "northwest":
            case "nw":
                return NORTH_WEST;
            case "up":
            case "u":
                return UP;
            case "down":
            case "d":
                return DOWN;
            default:
                return -1;
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
        if(noun != null) return findNoun(noun, player);
        else return null;
    }
    
    public int directionParser(String input){
        input = input.toLowerCase();
        
        //convert String input to List, then filter out nulls and verbs
        List<String> inputList = new ArrayList<>(Arrays.asList(input.split("\\s")));
        inputList.removeIf(i -> (i == null || findVerb(i) != null));
        
        if (inputList.isEmpty() || inputList.size() > 1) return -1;
        
        return findDirection(inputList.get(0)); 
    }
	
    public void move(int direction, Player player, World world){
        if(player.getCurrentArea().getPortal(direction).isLocked()){
            System.out.println("You can't go that way!");
        }else{
            player.setCurrentArea(world.getArea(player.getCurrentArea()
                    .getPortal(direction).getTarget()));
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
        if(player.getCurrentArea().hasMatching(item)){
            if(item.getUsageKey(1) == 1){
                player.getCurrentArea().removeItem(item);
                player.addItem(item);
                System.out.println(player.getName() + " took the " 
                        + item.getName());
            }else if(item.getUsageKey(1) == 2){
                System.out.println("The " + item.getName() 
                        + " is too heavy for that");
            }else if(item.getUsageKey(1) == 3){
                System.out.println("The " + item.getName() + " is bolted down");
            }else{
                System.out.println("You can't take the " + item.getName());
            }
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
        for (Item listInventory : player.listInventory()) {
            System.out.println("\t" + listInventory.getName());
        }
    }
    
    public void examine(Item item){
        if(item.getDescription() != null)
            System.out.println(item.getDescription());
        else System.out.println("It looks like every other " + item.getName() + 
                " you've ever seen");
    }
    
    public void climb(Item item,Player player,World world){
        if(item == null){
            move(8,player,world);
        }else{
            if(item.getUsageKey(15) == 2 && player.getCurrentArea().getPortal(8) 
                    != null){
                if(!player.getCurrentArea().getPortal(8).isLocked())
                    move(8,player,world);
                else System.out.println("You can't climb that!");
            }else{
                System.out.println("You can't climb that!");
            }
        }
    }
    
    public int quit(){
        return 1;
    }
    
    public void score(Player player){
        System.out.println("Your score is: " + player.getScore());
    }
    
    public void diagnostic(Player player){
        System.out.println("Your hp is: " + player.getHp() + "/" + 
                player.getMaxHp());
    }
    
    public void eat(Item item, Player player){
        if(item.getUsageKey(2) == 2){
            if(player.getCurrentArea().hasMatching(item)) 
                player.getCurrentArea().removeItem(item);
            else if(player.hasMatching(item)) player.removeItem(item);
            System.out.println(player.getName() + " ate the " + item.getName());
            if(item.getTaste() != null) System.out.println(item.getTaste());
            else System.out.println("It tastes like every other " + 
                    item.getName() + " you've ever eaten");
        }else{
            System.out.println("I don't see how you expect to do that!");
        }
    }
    
    public void taste(Item item){
        if(item.getTaste() != null) System.out.println(item.getTaste());
        else System.out.println("It tastes like every other " + 
                item.getName() + " you've ever tried");
    }
    
    public void taste(Area area){
        if(area.getTaste() != null) System.out.println(area.getTaste());
        else System.out.println("It doesn't taste like anything");
    }
    
    public void smell(Item item){
        if(item.getSmell() != null) System.out.println(item.getSmell());
        else System.out.println("It smells like every other " + 
                item.getName());
    }
    
    public void smell(Area area){
        if(area.getSmell() != null) System.out.println(area.getSmell());
        else System.out.println("It doesn't smell like anything");
    }
    
    public void shout(){
        System.out.println("Aaaarrrrrrrrgggggggggggggghhhhhhhhhhhhhh!");
    }
    
    public void hello(){
        Random rand = new Random();
        int n = rand.nextInt(3);
        if(n == 0) System.out.println("Good day");
        else if(n == 1) System.out.println("Hello");
        else System.out.println("Nice weather we've been having lately");
    }
    
    public void credits(){
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        pause(750);
        System.out.println("d8888888P                    a88888b. dP     dP");
        pause(750);
        System.out.println("     .d8'                   d8'   `88 88   .d8'");
        pause(750);
        System.out.println("   .d8'   .d8888b. 88d888b. 88        88aaa8P' ");
        pause(750);
        System.out.println(" .d8'     88'  `88 88'  `88 88        88   `8b.");
        pause(750);
        System.out.println("d8'       88.  .88 88       Y8.   .88 88     88");
        pause(750);
        System.out.println("Y8888888P `88888P' dP        Y88888P' dP     dP");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("Created By Mr Booth's CompSci Classes");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("Core Programming:");
        pause(750);
        System.out.println("\tSamantha Miller");
        pause(750);
        System.out.println("\tHelen Keith");
        pause(750);
        System.out.println("\tPeter Mattsen");
        pause(750);
        System.out.println("\tCole Van Pelt");
        pause(750);
        System.out.println("\tAidan Anderson");
        pause(750);
        System.out.println("\tCody McCay");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("Story Writers:");
        pause(750);
        System.out.println("\tChaz McCarty");
        pause(750);
        System.out.println("\tJoy Clark");
        pause(750);
        System.out.println("\tBecca Dotson");
        pause(750);
        System.out.println("\tBrett Dayley");
        pause(750);
        System.out.println("\tKalo Antonio");
        pause(750);
        System.out.println("\tJacob Nelson");
        pause(750);
        System.out.println("\tCameron Kluge");
        pause(750);
        System.out.println("\tJason Gordon");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("Map and Item Designers:");
        pause(750);
        System.out.println("\tKevin White");
        pause(750);
        System.out.println("\tBailee Barrick");
        pause(750);
        System.out.println("\tCalvin Fischer");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("Content Programmers:");
        pause(750);
        System.out.println("\tAlex Johnson");
        pause(750);
        System.out.println("\tCurtis Holden");
        pause(750);
        System.out.println("\tWarren Coons");
        pause(750);
        System.out.println("\tMae Pontius");
        pause(750);
        System.out.println("\tGrace Smith");
        pause(750);
        System.out.println("\tEric Ma");
        pause(750);
        System.out.println("\tJosh Weston");
        pause(750);
        System.out.println("\tDavid Thomas");
        pause(750);
        System.out.println("\tBrayden Howard");
        pause(750);
        System.out.println("\tNick Slatton");
        pause(750);
        System.out.println("\tRyan Allen");
        pause(750);
        System.out.println("\tMadison Largey");
        pause(750);
        System.out.println("\tTrishana Place");
        pause(750);
        System.out.println("\tStone Van Beynum");
        pause(750);
        System.out.println("\tRachel Flowers");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("© 2016 - ");
        pause(750);
        System.out.println("\thttps://github.com/BoofPC/ZorCK2016");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("                   `..://+/+/.````               `");
        pause(750);
        System.out.println("              .:+ysdmdmmmNNNmNNNmmo-`             ");
        pause(750);
        System.out.println("            :+yddmdddmmmNNNNNNNNNNNNms`           ");
        pause(750);
        System.out.println("           :shdddhhhdmmNNNNNNNNNNNmmmmh/`         ");
        pause(750);
        System.out.println("           +ydddyyyhddmmmmmmmmdmmddhhdmNs`        ");
        pause(750);
        System.out.println("          :hddhso++ossohhhhhhhhyyhyo+odmmo        ");
        pause(750);
        System.out.println("         -hmmho+//////:/+ooosyo/os+/:/+hdh.       ");
        pause(750);
        System.out.println("         :smmy+///:::::--:-://::/:::/:/+hh:       ");
        pause(750);
        System.out.println("         :sddy+///:::::---------::::::::yy`       ");
        pause(750);
        System.out.println("         -syhs++//::::------------::::::+s        ");
        pause(750);
        System.out.println("         .hhs:+///++++++:-..-----:::::/::+        ");
        pause(750);
        System.out.println("         :yho:/+syssyhhhyoo/:-:+syhhhhyy/:        ");
        pause(750);
        System.out.println("        `+ss-:+osyhyyyssyys+//ossshhyyyo+/        ");
        pause(750);
        System.out.println("         :/+.:+syooooo+oo+yo::+ho+osoo++/:        ");
        pause(750);
        System.out.println("         -//-://+++++++++++/:-/ooo+o++///-        ");
        pause(750);
        System.out.println("         .///:///::----::///::://::::::::.        ");
        pause(750);
        System.out.println("          .//:///:---::/+///:--:://::::::.        ");
        pause(750);
        System.out.println("           .-+++///+////+o+++://++++++///.        ");
        pause(750);
        System.out.println("            .+o+//+o+++++o+++++oo+++o++//-        ");
        pause(750);
        System.out.println("             +oo+:/+oso+/////////oso/+///`        ");
        pause(750);
        System.out.println("             .sss+++++oo++/::://++//+soo`         ");
        pause(750);
        System.out.println("            `/+yyyso+++////:////////oss.          ");
        pause(750);
        System.out.println("          `+dN+shdhysoo+/+/+oo+++++oo:            ");
        pause(750);
        System.out.println("          +mNm+oshdmdhso+++//://++osso/           ");
        pause(750);
        System.out.println("        `/yNNmo++ooshddhyo++++o++osyMNNy          ");
        pause(750);
        System.out.println("     .+hmmmNNNy///+++osyhhysyyysyysyNMNNh/.       ");
        pause(750);
        System.out.println(" `.odNNNNNNNNNNy:::://++oooo+ooossssNMMNNNNmyo:`  ");
        pause(750);
        System.out.println("smmNNNNNNNNNNNNNh::-::::///+++/+ooooNMMNNNNNNNNNm+");
        pause(750);
        System.out.println("dNNNNNNNNMMMNNNNNd/-----::::///+++/+NMMNNNNNNNMMNd");
        pause(750);
        System.out.println("dNNNNNNNNMMMMNNNNNNs------::::::/:-hNNNNNNNMNNMMMd");
        pause(750);
        System.out.println("dNNNNNNNNNNMMMMNNNNNms-...-------.sNNNNMMMNNMMNMMd");
        pause(750);
        System.out.println("hmmmmmmmmmmmNNNNmmmmmmms-````````/mmmmmmNmmmmmmmmh");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("");
        pause(750);
        System.out.println("");
        pause(750);
    }
    
    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    
}
