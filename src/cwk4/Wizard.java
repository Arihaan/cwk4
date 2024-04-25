package cwk4;

/**
 * class Wizard - extension of class Champion
 *
 * @author team21
 * @version 1
 */

public class Wizard extends Champion{
    private String spell;
    private boolean isNecromant;
    public Wizard(String name, String spell, boolean isNecromant, int skill){
        super(0, skill, true, true, true, name);
        this.setJoiningFee(isNecromant ? 400 : 300);
        this.spell = spell;
        this.isNecromant = isNecromant;
    }
    /** returns true if Wizard is a Necromant else false.
     * @return true if Wizard is a Necromant else false.
     */
    public boolean isNecromant() {
        return isNecromant;
    }

    @Override
    /**Returns a String representation of the Champion along with the following attributes:
     * the Spell speciality,
     * whether Wizard is a Necromant or not and
     * Champion type i.e Wizard.
     *
     * @return a String representation of the Champion along with the following attributes:
     * the Spell speciality,
     * whether Wizard is a Necromant or not and
     * Champion type i.e Wizard.
     **/
    public String toString() {
        return super.toString() +
                "Spell Speciality: " + spell + "\n" +
                "Is Necromant: " + isNecromant + "\n" +
                "Champion: Wizard"          +       "\n";
    }
}