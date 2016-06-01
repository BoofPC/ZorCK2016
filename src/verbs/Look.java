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
public class Look extends Verb{
    
    public Look(){
        super("look",
                new String[] {"l"},
                new boolean[]{true,false,true});
    }
    
    public void run(Command command, PlayerConstruct construct){
        int direction = command.getDirection();
        Item noun = command.getNoun();
        
        Player player = construct.getPlayer();
        World world = construct.getWorld();
        
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
        if(player.getCurrentArea().getDark() != true){
            for(String item: desc){
                System.out.println(item);
            }
        }else if(player.getItem("Lantern") != null){
            if(player.getItem("Lantern").getActive()){
                for(String item: desc){
                    System.out.println(item);
                }
            }else{
                System.out.println("It's too dark to see!");
            }
        }else{
            System.out.println("It's too dark to see!");
        }
    }
}
