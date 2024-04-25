package cwk4;
import java.util.*;
import java.io.*;
/**
 * This interface specifies the behaviour expected from CARE
 * as required for 5COM2007 Cwk 4
 * 
 * @author Team 21
 * @version 1.0
 */

public class Tournament implements CARE
{

    // name of the vizier
    private String vizier;

    // treasury, i.e. amount of gulden that the vizier has
    private int treasury = 1000;

    // collections for the challenges, waiting list for the champions and the vizier's team
    private ArrayList<Challenge> challengeList = new ArrayList<Challenge>();
    private HashMap<String, Champion> reserveHashMap = new HashMap<String, Champion>();
    private HashMap<String, Champion> disqualifiedHashMap = new HashMap<String, Champion>();
    private HashMap<String, Champion> teamHashMap = new HashMap<String, Champion>();

//**************** CARE ************************** 
    /** Constructor requires the name of the vizier
     * @param viz the name of the vizier
     */  
    public Tournament(String viz)
    {
        vizier = viz;
        setupChampions();
        setupChallenges();
    }
    
    /** Constructor requires the name of the vizier and the
     * name of the file storing challenges
     * @param viz the name of the vizier
     * @param filename name of file storing challenges
     */  
    public Tournament(String viz, String filename)  //Task 3.5
    {
        vizier = viz;
        setupChampions();
        readChallenges(filename);
    }
    
    
    /**Returns a String representation of the state of the game,
     * including the name of the vizier, state of the treasury,
     * whether defeated or not, and the champions currently in the 
     * team,(or, "No champions" if team is empty)
     * 
     * @return a String representation of the state of the game,
     * including the name of the vizier, state of the treasury,
     * whether defeated or not, and the champions currently in the 
     * team,(or, "No champions" if team is empty)
     **/
    public String toString()
    {
        String s = "\nVizier: " + vizier +
                    "\nTreasury: " + treasury +
                    "\n" + getReserve() +
                    "\n" + getTeam() +
                    "\n" + getDisqualified() +
                    "\n" + getAllChallenges() ;
        
        return s;
    }
    
    
    /** returns true if Treasury <=0 and the vizier's team has no 
     * champions which can be retired. 
     * @return true if Treasury <=0 and the vizier's team has no
     * champions which can be retired. 
     */
    public boolean isDefeated()
    {
        return treasury == 0 && teamHashMap.isEmpty();
    }
    
    /** returns the amount of money in the Treasury
     * @return the amount of money in the Treasury
     */
    public int getMoney()
    {
        return treasury;
    }
    
    
    /**Returns a String representation of all champions in the reserves
     * @return a String representation of all champions in the reserves
     **/
    public String getReserve()
    {   
        String s = "************ Champions available in reserves********";
        for (Champion chmp : reserveHashMap.values()) {
            s += "\n" + (chmp.toString());
        }
        return s;
    }
    
        
    /** Returns details of the champion with the given name. 
     * Champion names are unique.
     * @return details of the champion with the given name
     **/
    public String getChampionDetails(String nme)
    {
       Champion champ = reserveHashMap.get(nme.toLowerCase());
       if (champ != null) {
           return champ.toString();
       } else {
           return "\nNo such champion";
       }
    }
    
    /** returns whether champion is in reserve
    * @param nme champion's name
    * @return true if champion in reserve, false otherwise
    */
    public boolean isInReserve(String nme)
    {
        Champion champ = reserveHashMap.get(nme.toLowerCase());
        if (champ != null && !isInViziersTeam(nme)) {
            return true;
        }
        else {
            return false;
        }
    }
 
    // ***************** Team champions ************************   
     /** Allows a champion to be entered for the vizier's team, if there 
     * is enough money in the Treasury for the entry fee.The champion's 
     * state is set to "active"
     * 0 if champion is entered in the vizier's team, 
     * 1 if champion is not in reserve, 
     * 2 if not enough money in the treasury, 
     * -1 if there is no such champion 
     * @param nme represents the name of the champion
     * @return as shown above
     **/        
    public int enterChampion(String nme)
    {
        Champion res = reserveHashMap.get(nme.toLowerCase());
        if (res == null) {
            return -1; // no such champion
        }

        if (!isInReserve(nme)) {
            return 1; // champion not in reserve
        }

        int entryFee = calculateEntryFee(res);

        if (entryFee > treasury) {
            return 2; // not enough money in the treasury
        }

        // Update treasury and champion's state
        treasury -= entryFee;


        // Add logic for adding champion to vizier's team
        teamHashMap.put(nme, res);

        return 0; // successfully entered champion
    }

    private int calculateEntryFee(Champion champ) {
        if (champ instanceof Wizard) {
            Wizard wizard = (Wizard) champ;
            int baseFee = 300;
            if (wizard.isNecromant()) {
                return baseFee + 100; // 400 gulden for necromancer wizards
            } else {
                return baseFee; // 300 gulden for regular wizards
            }
        } else if (champ instanceof Warrior) {
            Warrior warrior = (Warrior) champ;
            return warrior.getJoiningFee();
        } else if (champ instanceof Dragon) {
            return 500; // fixed entry fee for dragons
        }

        return 0;
    }


    /** Returns true if the champion with the name is in
     * the vizier's team, false otherwise.
     * @param nme is the name of the champion
     * @return returns true if the champion with the name
     * is in the vizier's team, false otherwise.
     **/
    public boolean isInViziersTeam(String nme)
    {
        return teamHashMap.containsKey(nme.toLowerCase());
    }
    
    /** Removes a champion from the team back to the reserves (if they are in the team)
     * Pre-condition: isChampion()
     * 0 - if champion is retired to reserves
     * 1 - if champion not retired because disqualified
     * 2 - if champion not retired because not in team
     * -1 - if no such champion
     * @param nme is the name of the champion
     * @return as shown above 
     **/
    public int retireChampion(String nme)
    {
        Champion champ = reserveHashMap.get(nme.toLowerCase());

        if (champ == null) {
            return -1; // no such champion
        }

        if (!isInViziersTeam(nme)) {
            return 2; // champion not in the vizier's team
        }

        // Logic to retire the champion from the vizier's team
        teamHashMap.remove(nme, champ);
        // For this example, we'll remove the champion from the vizier's team (reserveHashMap)
        reserveHashMap.put(nme.toLowerCase());

        return 0; // successfully retired champion
    }
    
    
        
    /**Returns a String representation of the champions in the vizier's team
     * or the message "No champions entered"
     * @return a String representation of the champions in the vizier's team
     **/
    public String getTeam()
    {
        String s = "************ Vizier's Team of champions********";
        if (teamHashMap.isEmpty()) {
            s += "\n"+"No champions entered";
        }
        else{
            for (Champion chmp : teamHashMap.values()) {
                s += chmp.toString() + "\n" ;
            }
        }
        return s;
    }
    
     /**Returns a String representation of the disqualified champions in the vizier's team
     * or the message "No disqualified champions "
     * @return a String representation of the disqualified champions in the vizier's team
     **/
    public String getDisqualified()
    {
        String s = "************ Vizier's Disqualified champions********";
        if (disqualifiedHashMap.isEmpty()) {
            s += "\n"+"No champions disqualified";
        }
        for (Champion chmp : disqualifiedHashMap.values()) {
            if(chmp.getState() == ChampionState.DISQUALIFIED) {
                s += chmp.toString() + "\n";
            }
        }
        return s;
    }
    
//**********************Challenges************************* 
    /** returns true if the number represents a challenge
     * @param num is the number of the challenge
     * @return true if the number represents a challenge
     **/
     public boolean isChallenge(int num)
     {
         return num > 0 && num < challengeList.size();
     }    
   
    /** Provides a String representation of an challenge given by 
     * the challenge number
     * @param num the number of the challenge
     * @return returns a String representation of a challenge given by 
     * the challenge number
     **/
    public String getChallenge(int num)
    {
        if (isChallenge(num)) {
            return challengeList.get(num - 1).toString();
        } else {
            return "\nNo such challenge";
        }
    }
    
    /** Provides a String representation of all challenges 
     * @return returns a String representation of all challenges
     **/
    public String getAllChallenges()
    {
        String s = "\n************ All Challenges ************\n";
        if (challengeList.isEmpty()) {
            s += "No challenges available" + "\n";
        }
        else{
            for (Challenge challenge : challengeList) {
                s += challenge.toString()+ "\n";
            }
        }

        return s;
    }
    
    
       /** Retrieves the challenge represented by the challenge 
     * number.Finds a champion from the team who can meet the 
     * challenge. The results of meeting a challenge will be 
     * one of the following:  
     * 0 - challenge won by champion, add reward to the treasury, 
     * 1 - challenge lost on skills  - deduct reward from
     * treasury and record champion as "disqualified"
     * 2 - challenge lost as no suitable champion is  available, deduct
     * the reward from treasury 
     * 3 - If a challenge is lost and vizier completely defeated (no money and 
     * no champions to withdraw) 
     * -1 - no such challenge 
     * @param chalNo is the number of the challenge
     * @return an int showing the result(as above) of fighting the challenge
     */ 
    public int meetChallenge(int chalNo)
    {
        //Nothing said about accepting challenges when bust
        int outcome = -1 ;
        Challenge chlg = challengeList.get(chalNo);
        ChallengeType Ctype = chlg.getChallengeType();
        int level = chlg.getSkillLevel();
        for (Champion Camp : teamHashMap.values()){
            String st = Camp.getName();
            int skill = Camp.getSkillLevel();
            if (Camp.compareTypes(Ctype)){
                if(skill >= level ){
                    outcome = 0;
                    treasury += chlg.getReward();
                }
                else {
                    outcome = 1;
                    ChampionState championState = ChampionState.DISQUALIFIED;
                    teamHashMap.remove(Camp);
                    disqualifiedHashMap.put(st ,Camp);
                    treasury -= chlg.getReward();
                }
            }
            else{
                if (treasury == 0 && reserveHashMap.isEmpty()){
                    outcome = 2;
                }
                else {
                    treasury -= chlg.getReward();
                    outcome = 3;
                }
            }
        }
        return outcome;
    }
 

    //****************** private methods for Task 3 functionality*******************
    //*******************************************************************************
    private void setupChampions()
    {
        Champion ganfrank = new Wizard("Ganfrank", "transmutation", true, 7);
        Champion rudolf = new Wizard("Rudolf", "invisibility", true, 6);
        Champion elblond = new Warrior("Elblond", "sword", 150);
        Champion flimsi = new Warrior("Flimsi", "bow", 200);
        Champion drabina = new Dragon("Drabina", false);
        Champion golum = new Dragon("Golum", true);
        Champion argon = new Warrior("Argon", "mace", 900);
        Champion neon = new Wizard("Neon", "translocation", false, 2);
        Champion xenon = new Dragon("Xenon", true);
        Champion atlanta = new Warrior("Atlanta", "bow", 500);
        Champion krypton = new Wizard("Krypton", "fireballs", false, 8);
        Champion hedwig = new Wizard("Hedwig", "flying", true, 1);

        reserveHashMap.put("ganfrank", ganfrank);
        reserveHashMap.put("rudolf", rudolf);
        reserveHashMap.put("elblond", elblond);
        reserveHashMap.put("flimsi", flimsi);
        reserveHashMap.put("drabina", drabina);
        reserveHashMap.put("golum", golum);
        reserveHashMap.put("argon", argon);
        reserveHashMap.put("neon", neon);
        reserveHashMap.put("xenon", xenon);
        reserveHashMap.put("atlanta", atlanta);
        reserveHashMap.put("krypton", krypton);
        reserveHashMap.put("hedwig", hedwig);
    }
     
    private void setupChallenges()
    {
        Challenge challenge1 = new Challenge(1, ChallengeType.MAGIC, "Borg", 3, 100);
        Challenge challenge2 = new Challenge(2, ChallengeType.FIGHT, "Huns", 3, 120);
        Challenge challenge3 = new Challenge(3, ChallengeType.MYSTERY, "Ferengi", 3, 150);
        Challenge challenge4 = new Challenge(4, ChallengeType.MAGIC, "Vandal", 9, 200);
        Challenge challenge5 = new Challenge(5, ChallengeType.MYSTERY, "Borg", 7, 90);
        Challenge challenge6 = new Challenge(6, ChallengeType.FIGHT, "Goth", 8, 45);
        Challenge challenge7 = new Challenge(7, ChallengeType.MAGIC, "Frank", 10, 200);
        Challenge challenge8 = new Challenge(8, ChallengeType.FIGHT, "Sith", 10, 170);
        Challenge challenge9 = new Challenge(9, ChallengeType.MYSTERY, "Cardashian", 9, 300);
        Challenge challenge10 = new Challenge(10, ChallengeType.FIGHT, "Jute", 2, 300);
        Challenge challenge11 = new Challenge(11, ChallengeType.MAGIC, "Celt", 2, 250);
        Challenge challenge12 = new Challenge(12, ChallengeType.MYSTERY, "Celt", 1, 250);

        challengeList.add(challenge1);
        challengeList.add(challenge2);
        challengeList.add(challenge3);
        challengeList.add(challenge4);
        challengeList.add(challenge5);
        challengeList.add(challenge6);
        challengeList.add(challenge7);
        challengeList.add(challenge8);
        challengeList.add(challenge9);
        challengeList.add(challenge10);
        challengeList.add(challenge11);
        challengeList.add(challenge12);
    }
        
    // Possible useful private methods
//     private Challenge getAChallenge(int no)
//     {
//         
//         return null;
//     }
//    
//     private Champion getChampionForChallenge(Challenge chal)
//     {
//         
//         return null;
//     }

    //*******************************************************************************
    //*******************************************************************************
  
    /************************ Task 3.5 ************************************************/  
    
    // ***************   file write/read  *********************
    /**
     * reads challenges from a comma-separated textfile and stores in the game
     * @param filename of the comma-separated textfile storing information about challenges
     */
    public void readChallenges(String filename)
    { 
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                readChallenge(line);
                line = reader.readLine();
            }
        }
        catch (Exception e) {e.printStackTrace();}
    }

    private void readChallenge(String line) {
        StringTokenizer st = new StringTokenizer (line, ","); // comma-separated data
        int chNo = Integer.parseInt(st.nextToken());
        ChallengeType chType = ChallengeType.valueOf(st.nextToken());
        String chName = st.nextToken();
        int chLevel = Integer.parseInt(st.nextToken());
        int chReward = Integer.parseInt(st.nextToken());
        challengeList.add(new Challenge(chNo, chType, chName, chLevel, chReward));
    }
    
     /** reads all information about the game from the specified file 
     * and returns a CARE reference to a Tournament object, or null
     * @param fname name of file storing the game
     * @return the game (as a Tournament object)
     */
     public Tournament loadGame(String fname)
    {   // uses object serialisation
        Tournament tournament = null;
        try {
            FileInputStream fis = new FileInputStream(fname);
            ObjectInputStream ois = new ObjectInputStream(fis);
            tournament = (Tournament) ois.readObject();
        }
        catch (Exception e) {e.printStackTrace();}

        return tournament;
    }
   
   /** Writes whole game to the specified file
     * @param fname name of file storing requests
     */
   public void saveGame(String fname)
   {
        // uses object serialisation
       try {
           FileOutputStream fos = new FileOutputStream(fname);
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(this);
       }
       catch (Exception e) {e.printStackTrace();}
   }
 

}



