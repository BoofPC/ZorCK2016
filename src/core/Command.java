package core;

import core.World.Direction;

public final class Command {

    private final Verb verb;
    private final String verbStr;
    private final Item noun;
    private final NounOrigin nounOrigin;
    private final String nounStr;
    private final Direction direction;
    private final String directionStr;
    private final String leftovers;

    private Command(final Verb verb, final String verbStr, final Item noun,
            final NounOrigin nounOrigin, final String nounStr, final Direction direction,
            final String directionStr, final String leftovers) {
        this.verb = verb;
        this.verbStr = verbStr;
        this.noun = noun;
        this.nounOrigin = nounOrigin;
        this.nounStr = nounStr;
        this.direction = direction;
        this.directionStr = directionStr;
        this.leftovers = leftovers != null ? leftovers : "";
    }

    public static Command bare(final Verb verb, final String verbStr, final String leftovers) {
        if (verb == null)
            throw new NullPointerException();
        return new Command(verb, verbStr, null, null, null, null, null, leftovers);
    }


    public static Command applied(final Verb verb, final String verbStr, final Item noun,
            final String nounStr, final NounOrigin nounOrigin, final String leftovers) {
        if (verb == null || noun == null)
            throw new NullPointerException();
        return new Command(verb, verbStr, noun, nounOrigin, nounStr, null, null, leftovers);
    }

    public static Command directedBare(final Verb verb, final String verbStr,
            final Direction direction, final String directionStr, final String leftovers) {
        if (verb == null || direction == null)
            throw new NullPointerException();
        return new Command(verb, verbStr, null, null, null, direction, directionStr, leftovers);
    }

    public static Command directed(final Verb verb, final String verbStr, final Item noun,
            final String nounStr, final NounOrigin nounOrigin, final Direction direction,
            final String directionStr, final String leftovers) {
        if (verb == null || noun == null || direction == null)
            throw new NullPointerException();
        return new Command(verb, verbStr, noun, nounOrigin, nounStr, direction, directionStr,
                leftovers);
    }

    public static Command direction(final Direction direction, final String directionStr,
            final String leftovers) {
        if (direction == null)
            throw new NullPointerException();
        return new Command(null, null, null, null, null, direction, directionStr, leftovers);
    }

    public static Command badParse(final String leftovers) {
        return new Command(null, null, null, null, null, null, null, leftovers);
    }

    public boolean hasVerb() {
        return this.verb != null;
    }

    public boolean hasNoun() {
        return this.noun != null;
    }

    public boolean hasDirection() {
        return this.direction != null;
    }

    public boolean isBare() {
        return this.hasVerb() && !this.hasNoun();
    }

    public boolean isApplied() {
        return this.hasVerb() && this.hasNoun();
    }

    public boolean isDirection() {
        return this.hasDirection() && !this.hasVerb();
    }

    public boolean isDirected() {
        return this.hasVerb() && this.hasDirection();
    }

    public boolean isBadParse() {
        return this.verb == null && this.noun == null && this.direction == null;
    }

    public Verb getVerb() {
        return this.verb;
    }

    public String getVerbStr() {
        return this.verbStr;
    }

    public Item getNoun() {
        return this.noun;
    }

    public String getNounStr() {
        return this.nounStr;
    }

    public NounOrigin getNounOrigin() {
        return nounOrigin;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public String getDirectionStr() {
        return this.directionStr;
    }

    public String getLeftovers() {
        return this.leftovers;
    }

    public static enum NounOrigin {
        PLAYER, AREA
    }
}
