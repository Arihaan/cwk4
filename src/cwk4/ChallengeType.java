package cwk4;

import java.io.*;
/**
 * Enumeration class ChallengeType - list possible types of challenges
 * 
 * @author A.Marczyk
 * @version 01/03/2024
 */
public enum ChallengeType implements Serializable
{
    MAGIC(" Magic"), FIGHT("Fight"), MYSTERY ("Mystery");
    private String type;
    
    private ChallengeType(String ty)
    {
        type = ty;
    }
    
    public String toString()
    {
        return type;
    }

    public static void main(String[]args){
        ChallengeType Challenge1= ChallengeType.MAGIC;
        ChallengeType Challenge2= ChallengeType.FIGHT;
        ChallengeType Challenge3= ChallengeType.MYSTERY;

        System.out.println("Challenge Type 1:" + Challenge1);
        System.out.println("Challenge Type 2:" + Challenge2);
        System.out.println("Challenge Type 3:" + Challenge3);
    }
}



