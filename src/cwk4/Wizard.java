package cwk4;

public class Wizard extends Champion{
    private String spell;
    private boolean isNecromant;
    public Wizard(String name, String spell, boolean isNecromant, String state, int skill, boolean isMagic, boolean isFight, boolean isMystery){
        super(0, state, skill, isMagic, isFight, isMystery, name);
        this.setJoiningFee(isNecromant ? 400 : 300);
        this.spell = spell;
        this.isNecromant = isNecromant;
    }
    @Override
    public String toString() {
        return super.toString() +
                "Spell Speciality: " + spell + "\n" +
                "Is Necromant: " + isNecromant + "\n";
    }


    public static void main(String[] args)
    {
        Wizard wiz = new Wizard("Aladin", "Abra", false, "Ready", 7, true, false, true);
        System.out.println(wiz);
    }

}