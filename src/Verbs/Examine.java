package verbs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import core.Verb;
/**
 *
 * @author Pedro
 */
public class Examine extends Verb{
    
    public Examine(){
        super("examine",new String[]{"look at","scan","study","observe"},new boolean[]{false,true,false});
    }
    
}
