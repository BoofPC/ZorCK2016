package core;

import static core.VerbPhrase.VerbType.*;

/**
 * Created by Alex on 5/22/17.
 */
public class VerbPhrase {
    private final String verb;
    private final String directObject;
    private final String indirectObject;
    private final Area.Direction direction;
    private final VerbType type;

    public VerbPhrase(String verb, String directObject, String indirectObject) {
        this.verb = verb;
        this.directObject = directObject;
        this.indirectObject = indirectObject;
        this.direction = Area.Direction.NODIRECTION;
        this.type = INDIRECT;
    }

    public VerbPhrase(String verb, String directObject){
        this.verb = verb;
        this.directObject = directObject;
        this.indirectObject = "";
        this.direction = Area.Direction.NODIRECTION;
        this.type = DIRECT;
    }

    public VerbPhrase(String verb){
        this.verb = verb;
        this.directObject = "";
        this.indirectObject = "";
        this.direction = Area.Direction.NODIRECTION;
        this.type = INTRANSITIVE;
    }

    public VerbPhrase(Area.Direction direction){
        this.direction = direction;
        this.verb = "move";
        this.directObject = "";
        this.indirectObject = "";
        this.type = MOVE;
    }

    public VerbType getType(){
        return this.type;
    }

    public static VerbPhrase wat(){
        return new VerbPhrase("WAT");
    }

    public String getIndirectObject() {
        return indirectObject;
    }

    public Area.Direction getDirection() {
        return direction;
    }

    public String getVerb() {
        return verb;

    }

    public int hashCode(){
        return 0;
    }

    public boolean equals(Object other){
        VerbPhrase v = (VerbPhrase) other;
        return this.direction == v.direction
                && this.type == v.type
                && this.verb.equals(v.verb)
                && this.directObject.equals(v.directObject)
                && this.indirectObject.equals(v.indirectObject);
    }

    public String getDirectObject() {
        return directObject;
    }

    public static enum VerbType{
        INTRANSITIVE, DIRECT, INDIRECT, MOVE
    }
}
