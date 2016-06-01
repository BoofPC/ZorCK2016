package verbs;
import core.*;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro
 */
public class Credits extends Verb{
    
    public Credits(){
        super("credits",
                new String[] {"c"},
                new boolean[]{true,false,false});
    }
    
    public void run(Command command, PlayerConstruct construct){
        int direction = command.getDirection();
        Item noun = command.getNoun();
        
        Player player = construct.getPlayer();
        World world = construct.getWorld();
        
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
        System.out.println("         `-:+osyyo++-         ");
        pause(750);
        System.out.println("       :sddddmNNNNNNNdo       ");
        pause(750);
        System.out.println("      .yddyhdmmmmmmmmhmm:     ");
        pause(750);
        System.out.println("     `sdyo++o+yyyhsss++hd`    ");
        pause(750);
        System.out.println("     .hmo//:::-::/:/:::/h:    ");
        pause(750);
        System.out.println("     .sho//:::------::::s`    ");
        pause(750);
        System.out.println("     .ho/+oosso/:-:/+ooo/     ");
        pause(750);
        System.out.println("     :s:+ssssosso/osyyso+     ");
        pause(750);
        System.out.println("     ./-/++++++++:+o+++//     ");
        pause(750);
        System.out.println("     `:///:--:///::/::::-     ");
        pause(750);
        System.out.println("      `-++/++/+++//++++/:     ");
        pause(750);
        System.out.println("       `o+/+oo//////o++/:     ");
        pause(750);
        System.out.println("        +yso++++/:///+s+      ");
        pause(750);
        System.out.println("      :dysdhso+++++++o:       ");
        pause(750);
        System.out.println("    `:hNy+oshhyo++++sdNh`     ");
        pause(750);
        System.out.println(" `/ymNNNm+///+ssssssshMNmy+-  ");
        pause(750);
        System.out.println("hmNNNNNNNNo:-::////+oyMNNNNNNy");
        pause(750);
        System.out.println("mNNNNMMMNNNy:--::::/:dNNNNNNMm");
        pause(750);
        System.out.println("dNNNNNNNNNNmmy-.````sNNNNNNNNm");
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
