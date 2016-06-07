package items;

import core.*;

public class Toolbox extends Item {

    public Toolbox() {
        super();
        this.usage()
            .take(Item.TAKABLE)
            .open(Item.CLOSED)
            .lock(Item.LOCKED);
        this.name("Toolbox")
            .synonym("toolbox")
            .description("It's a small red toolbox. You can use the Toolbox Key "
            + "to lock and unlock this.");
        this.key("Toolbox Key");
    }
    
    @Override
    public void interact(final Command command, final Context context) {
        if (command.getVerb().getTitle().equals("open")) {
            if (this.usage().lock() == Usage.Lock.UNLOCKED) {
                command.getVerb().run(command, context);
                System.out.println("The toolbox opens, revealing a shiny new "
                    + "screwdriver!");
                context.getPlayer().getCurrentArea().item(new Screwdriver());
            }
        }
        
    }
    
}