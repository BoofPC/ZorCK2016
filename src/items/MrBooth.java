package items;
import core.*;

public class MrBooth extends Item{
    public MrBooth(){
        super();
        this.name("Mr.Booth");
        this.description("He is in a Robotics t-shirt and jean.");
        this.synonym("Mr.booth");
        this.synonym("mr.booth");
        this.synonym("mr.Booth");
        this.synonym("Mr Booth");
        this.synonym("Mr booth");
        this.synonym("mr Booth");
        this.synonym("mr booth");
        this.synonym("Booth");
        this.synonym("Boof");
        this.synonym("booth");
        this.synonym("boof");
        this.smell("He smells like he showered this morrning");
    }

    @Override
    public void interact(Command command, Context context) {
        if (command.getVerb().getTitle().equals("smell")) this.getSmell();
    }
}
