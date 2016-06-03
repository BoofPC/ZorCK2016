package items;
import core.*;

public class MrBooth extends Item{
    public MrBooth(){
        super();
        this.setName("Mr.Booth");
        this.setDescription("He is in a Robotics t-shirt and jean.");
        this.addSynonym("Mr.booth");
        this.addSynonym("mr.booth");
        this.addSynonym("mr.Booth");
        this.addSynonym("Mr Booth");
        this.addSynonym("Mr booth");
        this.addSynonym("mr Booth");
        this.addSynonym("mr booth");
        this.addSynonym("Booth");
        this.addSynonym("Boof");
        this.addSynonym("booth");
        this.addSynonym("boof");
        this.setSmell("He smells like he showered this morrning");
    }

    @Override
    public void interact(Command command, Context context) {
        if (command.getVerb().getTitle().equals("smell")) this.getSmell();
    }
}
