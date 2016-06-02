package core;

public final class Command {
    
    private final Verb verb;
    private final Item noun;
    private final int direction;
    
    public Command(Verb verb, Item noun, int direction){
        this.verb = verb;
        this.noun = noun;
        this.direction = direction;
    }

    public Verb getVerb() {
        return verb;
    }

    public Item getNoun() {
        return noun;
    }

    public int getDirection() {
        return direction;
    }
}
