package core;

import core.World.Direction;

public final class Command {
    
    private final Verb verb;
    private final Item noun;
    private final Direction direction;
    
    public Command(Verb verb, Item noun, Direction direction){
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

    public Direction getDirection() {
        return direction;
    }
}
