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
        String[] filteredTokens = new String[tokens.length];
        for(int i = 0; i < filteredTokens.length; i++){
            filteredTokens[i] = dictionary.mapsTo(tokens[i].toLowerCase());
        }
        switch(tokens.length){
            case 0:
                return null;

            case 1:
                if(dictionary.getMovementDirections().contains(filteredTokens[0])){
                    return getMove(filteredTokens[0]);
                }else if(dictionary.getIntransitiveVerbs().contains(filteredTokens[0])){
                    return new VerbPhrase(filteredTokens[0]);
                }else{
                    return VerbPhrase.wat();
                }

            case 2:
                if(dictionary.getMovementDirections().contains(filteredTokens[1])) {
                    return getMove(filteredTokens[1]);
                }else if(dictionary.getDirectVerbs().contains(filteredTokens[0])){
                    return new VerbPhrase(filteredTokens[0],tokens[1]);
                }else{
                    return VerbPhrase.wat();
                }

            default:
                if(tokens.length == 3
                        && Arrays.asList("a", "an", "the", "to", "with", "on", "around", "at").contains(filteredTokens[1])){
                    return new VerbPhrase(filteredTokens[0], tokens[2]);
                }
                if(dictionary.getIndirectVerbs().contains(filteredTokens[0]) ){
                    if(tokens.length == 3){
                        return new VerbPhrase(filteredTokens[0], tokens[1], tokens[2]);
                    } else if(tokens.length == 4){
                        return new VerbPhrase(filteredTokens[0],tokens[1],tokens[3]);
                    } else if(tokens.length == 5){
                        if(Arrays.asList("a","an","the").contains(filteredTokens[1])
                                && Arrays.asList("to","with","on","around","at").contains(filteredTokens[4])){
                            return new VerbPhrase(filteredTokens[0], tokens[2], tokens[4]);
                        }
                    }
                    else if(tokens.length == 6) {
                        return new VerbPhrase(filteredTokens[0], tokens[2], tokens[5]);
                    }
                }
                return VerbPhrase.wat();
        }
    }

    private VerbPhrase getMove(String direction){
        for(Area.Direction dir: Area.Direction.values()){
            if(direction.equalsIgnoreCase(dir.name().toLowerCase())){
                return new VerbPhrase(dir);
            }
        }
        return VerbPhrase.wat();
    }


    public VerbPhrase interpret(String input){
        return parse(tokenize(input));
    }

}
