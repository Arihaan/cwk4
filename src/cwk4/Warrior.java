package cwk4;

public class Warrior extends Champion{
    String weapon;
    public Warrior(String weapon, int fee, String state, int skill, boolean isMagic, boolean isFight, boolean isMystery){
        super(fee, state, skill, isMagic, isFight, isMystery);
        this.weapon = weapon;
    }
}
