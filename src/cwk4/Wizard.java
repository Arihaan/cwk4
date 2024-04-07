package cwk4;

public class Wizard extends Champion{
    String spell;
    boolean isNecromant;
    public Wizard(String spell, boolean isNecromant, int fee, String state, int skill, boolean isMagic, boolean isFight, boolean isMystery){
        super(fee, state, skill, isMagic, isFight, isMystery);
        this.spell = spell;
        this.isNecromant = isNecromant;
    }
}