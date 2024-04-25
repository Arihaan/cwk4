package cwk4;

import java.io.Serializable;

/**
 * Represents the Champion object including the fields and methods for the  champion within the game, including
 * Champion name, entry fee for each champion, state of the champion and skill level.
 *
 * This class encapsulates the data and functionality related to champions in the game.
 *
 * @author TEAM21
 * @version 1.0
 */

public class Champion implements Serializable {
    private String name;
    private int joiningFee;
    private ChampionState state;
    private int skillLevel;
    private boolean canMagic;
    private boolean canFight;
    private boolean canMystery;
    public Champion(int fee, int skill, boolean isMagic, boolean isFight, boolean isMystery, String name){
        joiningFee = fee;
        state = ChampionState.WAITING;
        skillLevel = skill;
        canMagic = isMagic;
        canFight = isFight;
        canMystery = isMystery;
        this.name = name;
    }

    /**Returns the name of the champion
     * @return the name of the champion
     **/
    public String getName() {
        return name;
    }

    /**Returns the entry fee for each and every champion in order to enter the challenge
     * @return the entry fee for the champion
     **/
    public int getJoiningFee() {
        return joiningFee;
    }

    /**Returns the skill level of the champion
     * @return the skill level of the champion
     **/
    public int getSkillLevel() {
        return skillLevel;
    }

    /**Returns whether champion can do Magic
     * @return true if champion can do magic
     **/
    public boolean isCanMagic() {
        return canMagic;
    }

    /**Returns whether champion can fight
     * @return true if champion can fight
     **/
    public boolean isCanFight() {
        return canFight;
    }

    /**Returns whether champion can do mystery
     * @return true if champion can do mystery
     **/
    public boolean isCanMystery() {
        return canMystery;
    }

    /**Returns the state of the Champion
     * @return The ChampionState enum value representing the state of the champion
     **/
    public ChampionState getState() {
        return state;
    }

    /**Returns the skill level of the champion
     * @return sets skill level of the champion
     **/
    public void setSkillLevel(int skillLevel){
        this.skillLevel = skillLevel;
    }

    /**Returns the entry fee for each and every champion in order to enter the challenge
     * @return sets entry fee for the champion
     **/
    public void setJoiningFee(int fee){
        this.joiningFee = fee;
    }

    /**Returns the state of the Champion
     * @return sets ChampionState enum value representing the state of the champion
     **/
    public void setState(ChampionState state) {
        this.state = state;
    }

    /** Returns true if the champion has the ability to
     * the specified challenge type, false otherwise.
     * @param type is the ability of the champion
     * @return true if the champion has the ability to handle
     * the type of challenge, false otherwise.
     **/
    public boolean compareTypes(ChallengeType type) {
        if (type == ChallengeType.FIGHT) {
            return isCanFight();
        }
        if (type == ChallengeType.MAGIC) {
            return isCanMagic();
        }
        if (type == ChallengeType.MYSTERY) {
            return isCanMystery();
        }

        return false;
    }



    /**Returns a String representation of the Champion's objects including the fields and methods
     * @return a String representation of the Champion's objects including the fields and methods
     **/
    public String toString(){
        return "Champion: " + name + "\n" +
                "Status: " + state + "\n" +
                "Skill Level: " + skillLevel + "\n" +
                "Can Do Magic: " + canMagic + "\n" +
                "Can Fight: " + canFight + "\n" +
                "Can Do Mystery: " + canMystery + "\n" +
                "Joining Fee: " + joiningFee + "\n";

    }
}