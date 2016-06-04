package items;
import core.*;

public class MrBooth extends Item{
    public MrBooth(){
        super();
        this.name("Mr.Booth")
            .description("He is in a Robotics t-shirt and jean.")
            .synonym("mr.booth", "mr booth", "booth", "boof", "booth")
            .smell("He smells like he showered this morrning");
    }

    @Override
    public void interact(final Command command, final Context context) {
        if (command.getVerb().getTitle().equals("smell")) {
            this.smell();
        }
    }
}
