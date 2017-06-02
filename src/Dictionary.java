import tbge.Interpretable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lynds on 5/31/2017.
 */
//TODO make edits
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
                "inventory",
                "description",
                "help",
                "look",
                "quit"
        );

        directVerbs = Arrays.asList(
                "take",
                "eat",
                "look",
                "hit",
                "put",
                "use",
                "fix",
                "open",
                "get",
                "switch",
                "kill",
                "fight",
                "unlock",
                "use",
                "read",
                "talk"
        );

        indirectVerbs = Arrays.asList(
                "give",
                "unlock",
                "use"
        );

        movementVerbs = Arrays.asList(
                "move",
                "go"
        );

        movementDirections = Arrays.asList(
                "north",
                "northeast",
                "east",
                "southeast",
                "south",
                "southwest",
                "west",
                "northwest",
                "up",
                "down"
        );

        synonyms = new HashMap<>();
        synonyms.put("turn","switch");
        synonyms.put("examine","description");
        synonyms.put("survey","description");
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
