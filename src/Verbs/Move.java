package verbs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import core.Verb;
/**
 *
 * @author keith5387h
 */
public class Move extends Verb{
    public Move(){
        super("move", new String[] {"go","travel","walk"}, new boolean[]{false, false, true});
    }
}
