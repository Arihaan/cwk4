package cwk4;

import java.io.Serializable;

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

    public String getName() {
        return name;
    }

    public int getJoiningFee() {
        return joiningFee;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public boolean isCanMagic() {
        return canMagic;
    }

    public boolean isCanFight() {
        return canFight;
    }

    public boolean isCanMystery() {
        return canMystery;
    }

    public ChampionState getState() {
        return state;
    }

    public void setSkillLevel(int skillLevel){
        this.skillLevel = skillLevel;
    }

    public void setJoiningFee(int fee){
        this.joiningFee = fee;
    }

    public void setState(ChampionState state) {
        this.state = state;
    }

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