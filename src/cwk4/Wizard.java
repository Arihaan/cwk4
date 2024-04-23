package cwk4;

public class Wizard extends Champion{
    private String spell;
    private boolean isNecromant;
    public Wizard(String name, String spell, boolean isNecromant, int skill){
        super(0, skill, true, true, true, name);
        this.setJoiningFee(isNecromant ? 400 : 300);
        this.spell = spell;
        this.isNecromant = isNecromant;
    }

    public String getSpell() {
        return spell;
    }

    public boolean isNecromant() {
        return isNecromant;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Spell Speciality: " + spell + "\n" +
                "Is Necromant: " + isNecromant + "\n";
    }
}