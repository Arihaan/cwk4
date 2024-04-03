package cwk4;

public class Champion {
    int joiningFee;
    String state;
    int skillLevel;
    boolean canMagic;
    boolean canFight;
    boolean canMystery;
    public Champion(int fee, String state, int skill, boolean isMagic, boolean isFight, boolean isMystery){
        joiningFee = fee;
        this.state = state;
        skillLevel = skill;
        canMagic = isMagic;
        canFight = isFight;
        canMystery = isMystery;
    }
}
