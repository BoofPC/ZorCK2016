package items;

import core.*;

public class NoTea extends Item{

    public NoTea(){
        super();
        this.setName("No Tea");
        this.setDescription("What? That makes no sense. Pull yourself together!");
        this.addSynonym("no tea");
    }

    @Override
    public void interact(final Command command, final Context context){

    }
}
