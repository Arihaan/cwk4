package cwk4;

import java.io.*;
/**
 * Enumeration class ChampionState 
 * Specifies all possible states of a champion
 * 
 * @author A.Marczyk
 * @version 01/01/2024
 */
public enum ChampionState implements Serializable
{
    WAITING(" Waiting in reserve"), ENTERED(" Entered"),  DISQUALIFIED (" Disqualified");
    private String state;
    
    private ChampionState(String st)
    {
        state = st;
    }
    
    public String toString()
    {
        return state;
    }

    public static void main(String[]args){
        ChampionState Champion1= ChampionState.ENTERED;
        ChampionState Champion2= ChampionState.DISQUALIFIED;
        ChampionState Champion3= ChampionState.WAITING;

        System.out.println("Champion State 1:" + Champion1);
        System.out.println("Champion State 2:" + Champion2);
        System.out.println("Champion State 3:" + Champion3);

    }
}


