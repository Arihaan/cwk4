package cwk4;

public class Challenge {
    private int challengeNo;
    private String challengeType;
    private String enemy;
    private int skillLevel;
    private int reward;

    public Challenge(int challengeNo, String challengeType, String enemy, int skillLevel, int reward)
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
