
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro
 */
public class Verb {
    public String title;
    public ArrayList<String> synonyms;
    public boolean[] usage;    //Usage is a series of boolean statments
                                //determining which verbs can 'take' what other
                                //parts of speech. Right now commands can only
                                //be one verb and up to one other part, but
                                //eventually they could theoretically be more
                                //
                                //Currently the array is [none, noun, direction]
                                //e.g., the verb "look" would have the usage
                                //array [true, false, true] because you can
                                //write "look" or "look east" but not "look cat"
                                //The verb "take" would have the usage array
                                //[false, true, false] because you cannot
                                //simply "take" nor can you "take up," but you
                                //can "take cat"
    
    public Verb(String title, String[] synonyms, boolean[] usage){
        this.title = title;
        for(String item : synonyms){
            this.synonyms.add(item);
        }
        this.usage = new boolean[usage.length];
        for(int i = 0; i < usage.length; i++){
            this.usage[i] = usage[i];
        }
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public boolean findMatching(String input){
        if(this.title.equals(input)) return true;
        for(String item : this.synonyms){
            if(item.equals(input)) return true;
        }
        return false;
    }
    
    public boolean checkUsageKey(int key){
        if(this.usage.length > key) return this.usage[key];
        else return false;
    }
}
