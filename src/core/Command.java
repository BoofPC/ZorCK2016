package core;

import core.World.Direction;

public final class Command {

    private final Verb verb;
    private final Item noun;
    private final Direction direction;

    public Command(final Verb verb, final Item noun, final Direction direction){
        this.verb = verb;
        this.noun = noun;
        this.direction = direction;
    }

    public Verb getVerb() {
        return this.verb;
    }

    public Item getNoun() {
        return this.noun;
    }

    public Direction getDirection() {
        return this.direction;
    }
}
