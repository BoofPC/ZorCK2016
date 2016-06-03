package core;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public abstract class Verb {
    public String title;
    public List<String> synonyms;
    public boolean[] usage;
    /* Usage is a series of boolean statments
     * determining which verbs can 'take' what other
     * parts of speech. Right now commands can only
     * be one verb and up to one other part, but
     * eventually they could theoretically be more
     *
     * Currently the array is [none, noun, direction]
     * e.g., the verb "look" would have the usage
     * array [true, false, true] because you can
     * write "look" or "look east" but not "look cat"
     * The verb "take" would have the usage array
     * [false, true, false] because you cannot
     * simply "take" nor can you "take up," but you
     * can "take cat"
     */
    
    public Verb(String title, String[] synonyms, boolean[] usage){
        this.title = title;
        this.synonyms = Arrays.asList(synonyms);
        this.usage = new boolean[usage.length];
        System.arraycopy(usage, 0, this.usage, 0, usage.length);
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public boolean hasMatching(String input){
        if(this.title.equals(input)) return true;
        return this.synonyms.contains(input);
    }
    
    public boolean getUsageKey(int key){
        if(this.usage.length > key) return this.usage[key];
        else return false;
    }
    
    public abstract void run(Command command, Context construct);
    
    public static Verb fromLambda(String title, String[] synonyms, boolean[] usage, BiConsumer<Command, Context> f) {
        return new Verb(title, synonyms, usage) {
            public void run(Command command, Context construct) {
                f.accept(command, construct);
            }
        };
    }
}
