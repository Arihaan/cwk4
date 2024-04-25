package cwk4;

import java.io.Serializable;

/**
 * Represents the Challenge object including the fields and methods of challenge within the game, including
 * challenge number, type of challenge, name of the enemy , skill level and reward.
 *
 * This class encapsulates the data and functionality related to challenges in the game.
 *
 * @author TEAM21
 * @version 1.0
 */

public class Challenge implements Serializable {
    private int challengeNo;
    private ChallengeType challengeType;
    private String enemy;
    private int skillLevel;
    private int reward;

    public Challenge(int challengeNo, ChallengeType challengeType, String enemy, int skillLevel, int reward)
    {
        this.challengeNo = challengeNo;
        this.challengeType = challengeType;
        this.enemy = enemy;
        this.skillLevel = skillLevel;
        this.reward = reward;
    }

    /**Returns the reward for completing the challenge
     * @return the reward for completing the challenge
     **/
    public int getReward() {
        return reward;
    }

    /**Returns the skill level for completing the challenge
     * @return the skill level required to undertake the challenge
     **/
    public int getSkillLevel() {
        return skillLevel;
    }

    /**Returns the type of challenge
     * @return The ChallengeType enum value representing the type of challenge
     **/
    public ChallengeType getChallengeType() {
        return challengeType;
    }


    /**Returns a String representation of all the Challenge object including the fields and methods
     * @return a String representation of all the Challenge object including the fields and methods
     **/
    public String toString()
    {
        String s;

        s = "\nChallenge No.: " + challengeNo + "\nChallenge Type: " + challengeType + "\nEnemy Name: " + enemy +
                "\nSkill Level: " + skillLevel + "\nReward: " + reward;

        return s;
    }
}
