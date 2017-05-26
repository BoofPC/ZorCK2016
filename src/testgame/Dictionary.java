package testgame;

import core.Interpretable;
import core.Interpreter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex on 5/25/17.
 */
public class Dictionary implements Interpretable {
    private List<String> intransitiveVerbs;
    private List<String> directVerbs;
    private List<String> indirectVerbs;
    private List<String> movementVerbs;
    private List<String> movementDirections;
    private Map<String,String> synonyms;

    public Dictionary(){
        intransitiveVerbs = Arrays.asList(
                "think",
                "smell",
                "run",
                "inventory"
        );

        directVerbs = Arrays.asList(
                "take",
                "eat",
                "examine",
                "look",
                "hit",
                "put",
                "use",
                "fix",
                "open",
                "get",
                "switch",
                "turn"
        );

        indirectVerbs = Arrays.asList(
                "give",
                "unlock"
        );

        movementVerbs = Arrays.asList(
                "move",
                "go"
        );

        movementDirections = Arrays.asList(
                "n", "north",
                "ne","northeast",
                "e","east",
                "se","southeast",
                "s","south",
                "sw","southwest",
                "w","west",
                "nw","northwest",
                "u", "up",
                "d", "down"
        );

        synonyms = new HashMap<>();
        synonyms.put("examine","look");
        synonyms.put("go","move");
        synonyms.put("n", "north");
        synonyms.put("ne","northeast");
        synonyms.put("e","east");
        synonyms.put("se","southeast");
        synonyms.put("s","south");
        synonyms.put("sw","southwest");
        synonyms.put("w","west");
        synonyms.put("nw","northwest");
        synonyms.put("u", "up");
        synonyms.put("d", "down");
    }

    @Override
    public List<String> getIntransitiveVerbs() {
        return intransitiveVerbs;
    }

    @Override
    public List<String> getDirectVerbs() {
        return directVerbs;
    }

    @Override
    public List<String> getIndirectVerbs() {
        return indirectVerbs;
    }

    @Override
    public List<String> getMovementVerbs() {
        return movementVerbs;
    }

    @Override
    public List<String> getMovementDirections() {
        return movementDirections;
    }

    public String mapsTo(String word) {
        if(synonyms.get(word)!= null){
            return synonyms.get(word);
        } else {
            return word;
        }
    }
}
