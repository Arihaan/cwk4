package cwk4;

import java.io.Serializable;

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

    public String toString()
    {
        String s;

        s = "\nChallenge No.: " + challengeNo + "\nChallenge Type: " + challengeType + "\nEnemy Name: " + enemy +
                "\nSkill Level: " + skillLevel + "\nReward: " + reward;

        return s;
    }
}
