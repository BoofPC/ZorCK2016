package core;

import testgame.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public final class Context {

    private final Player player;
    private final World world;
    private final List<String> state;
    private final Game game;
    private final Map<VerbPhrase,Function<Context,Boolean>> globalActions;

    public Context(final Player player, final World world, final Game game) {
        this.player = player;
        this.world = world;
        this.state = new ArrayList<>();
        this.game =  game;
        this.globalActions = new HashMap<>();
    }

    public Player getPlayer() {
        return this.player;
    }

    public World getWorld() {
        return this.world;
    }

    public List<String> getState() {
        return this.state;
    }

    public Game getGame(){ return this.game; }

    public Map<VerbPhrase,Function<Context,Boolean>> getGlobalActions(){
        return this.globalActions;
    }

}
