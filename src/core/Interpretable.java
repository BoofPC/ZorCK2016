package core;

import java.util.List;

/**
 * Created by Alex on 5/25/17.
 */
public interface Interpretable {
        List<String> getIntransitiveVerbs();
        List<String> getDirectVerbs();
        List<String> getIndirectVerbs();
        List<String> getMovementVerbs();
        List<String> getMovementDirections();
        String mapsTo(String word);
}

