/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import core.*;
import verbs.*;

/**
 *
 * @author Peter
 */
public class PostIt extends Item{

    public PostIt(){
        super();
        this.usage().take(Item.TAKABLE).read(Item.READABLE).food(Item.EDIBLE);
        this.name("Post-it Note")
                .examine("It's a note written by Booth!")
                .synonym("post-it note", "postit note", "note", "postit","sticky note")
                .read("PASSWORD: compsci_is_fun!")
                .taste("Why did you eat a post-it note?!?");
    }
    
    @Override
    public boolean interact(Command command, Context context){
        Verb verb = command.getVerb();
        if(verb.getTitle().equals("read")){
            System.out.println("PASSWORD: " + context.getPassword());
            context.setSkipGeneral(true);
            return true;
        }
        return false;
    }
}
