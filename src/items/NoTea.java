package items;

import core.*;

public class NoTea extends Item{
    
    public NoTea(){
        super();
        setName("No Tea");
        setDescription("What? That makes no sense. Pull yourself together!");
        addSynonym("no tea");
    }
    
    public void interact(Command command, Context context){
        
    }
}
