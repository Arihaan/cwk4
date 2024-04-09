package cwk4;

public class Champion {
    private String name;
    private int joiningFee;
    private String state;
    private int skillLevel;
    private boolean canMagic;
    private boolean canFight;
    private boolean canMystery;
    public Champion(int fee, int skill, boolean isMagic, boolean isFight, boolean isMystery, String name){
        joiningFee = fee;
        state = "Waiting";
        skillLevel = skill;
        canMagic = isMagic;
        canFight = isFight;
        canMystery = isMystery;
        this.name = name;
    }

    public void setSkillLevel(int skillLevel){
        this.skillLevel = skillLevel;
    }

    public void setJoiningFee(int fee){
        this.joiningFee = fee;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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