package core;

import core.World.Direction;

public final class Command {

    private final Verb verb;
    private final Item noun;
    private final Direction direction;
    private final String leftovers;

    private Command(final Verb verb, final Item noun, final Direction direction, final String leftovers){
        this.verb = verb;
        this.noun = noun;
        this.direction = direction;
        this.leftovers = leftovers != null ? leftovers : "";
    }

    public static Command bare(final Verb verb, final String leftovers) {
        if (verb == null)
            throw new NullPointerException();
        return new Command(verb, null, null, leftovers);
    }

    public static Command applied(final Verb verb, final Item noun, final String leftovers) {
        if (verb == null || noun == null)
            throw new NullPointerException();
        return new Command(verb, noun, null, leftovers);
    }

    public static Command directedBare(final Verb verb, final Direction direction, final String leftovers) {
        if (verb == null || direction == null)
            throw new NullPointerException();
        return new Command(verb, null, direction, leftovers);
    }

    public static Command directed(final Verb verb, final Item noun, final Direction direction, final String leftovers) {
        if (verb == null || noun == null || direction == null)
            throw new NullPointerException();
        return new Command(verb, noun, direction, leftovers);
    }

    public static Command direction(final Direction direction, final String leftovers) {
        if (direction == null)
            throw new NullPointerException();
        return new Command(null, null, direction, leftovers);
    }

    public static Command badParse(final String leftovers) {
        return new Command(null, null, null, leftovers);
    }

    public boolean isVerb() {
        return this.verb != null;
    }

    public boolean isBare() {
        return this.isVerb() && (this.noun == null);
    }

    public boolean isDirected() {
        return this.direction != null;
    }

    public boolean isDirection() {
        return !this.isVerb() && this.isDirected();
    }

    public boolean isBadParse() {
        return this.verb == null && this.noun == null && this.direction == null;
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

    public String getLeftovers() {
        return this.leftovers;
    }
}
