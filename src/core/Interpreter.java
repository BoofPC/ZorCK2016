package core;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Alex on 5/17/17.
 */
public class Interpreter {
    private Interpretable dictionary;

    public Interpreter(Interpretable dictionary){
        this.dictionary = dictionary;
    }

    private String[] tokenize(String input){
        return input.split("\\s");
    }

    private VerbPhrase parse(String[] tokens){
        switch(tokens.length){
            case 0:
                return null;

            case 1:
                if(dictionary.getMovementDirections().contains(tokens[0])){
                    return getMove(tokens[0]);
                }else if(dictionary.getIntransitiveVerbs().contains(tokens[0])){
                    return new VerbPhrase(dictionary.mapsTo(tokens[0]));
                }else{
                    return VerbPhrase.wat();
                }

            case 2:
                if(dictionary.getMovementDirections().contains(tokens[1])) {
                    return getMove(tokens[1]);
                }else if(dictionary.getDirectVerbs().contains(tokens[0])){
                    return new VerbPhrase(dictionary.mapsTo(tokens[0]),dictionary.mapsTo(tokens[1]));
                }else{
                    return VerbPhrase.wat();
                }

            default:
                if(dictionary.getIndirectVerbs().contains(tokens[0]) ){
                    if(tokens.length == 3){
                        if(Arrays.asList("a", "an", "the", "to", "with", "on", "around", "at").contains(tokens[1].toLowerCase())){
                            return new VerbPhrase(dictionary.mapsTo(tokens[0]), dictionary.mapsTo(tokens[2]));
                        }else {
                            return new VerbPhrase(dictionary.mapsTo(tokens[0]), dictionary.mapsTo(tokens[1]), dictionary.mapsTo(tokens[2]));
                        }
                    } else if(tokens.length == 4){
                        return new VerbPhrase(dictionary.mapsTo(tokens[0]),dictionary.mapsTo(tokens[1]),dictionary.mapsTo(tokens[3]));
                    } else if(tokens.length == 5){
                        if(Arrays.asList("a","an","the").contains(tokens[1].toLowerCase()) && Arrays.asList("to","with","on","around","at").contains(tokens[4].toLowerCase())){
                            return new VerbPhrase(dictionary.mapsTo(tokens[0]), dictionary.mapsTo(tokens[2]), dictionary.mapsTo(tokens[4]));
                        }
                    }
                    else if(tokens.length == 6) {
                        return new VerbPhrase(dictionary.mapsTo(tokens[0]), dictionary.mapsTo(tokens[2]), dictionary.mapsTo(tokens[5]));
                    }
                }
                return VerbPhrase.wat();
        }
    }

    private VerbPhrase getMove(String direction){
        for(Area.Direction dir: Area.Direction.values()){
            if(dictionary.mapsTo(direction).equals(dir.name().toLowerCase())){
                return new VerbPhrase(dir);
            }
        }
        return VerbPhrase.wat();
    }


    public VerbPhrase interpret(String input){
        return parse(tokenize(input));
    }

}
