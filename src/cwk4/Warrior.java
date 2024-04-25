package cwk4;

/**
 * class Warrior - extension of class Champion
 * @author team21
 * @version 1
 */

public class Warrior extends Champion{
    private String weapon;
    public Warrior(String name, String weapon, int fee){
        super(fee, 0, false, true, false, name);
        this.setSkillLevel(fee / 100);
        this.weapon = weapon;
    }

    /** Returns details of the warrior weapon.
     * @return details of the warrior weapon.
     **/
    public String getWeapon() {
        return weapon;
    }

    /**Returns a String representation of the Champion along with the following attributes:
     * the warrior's preferred weapon
     * Champion type i.e Warrior.
     *
     * @return a String representation of the Champion along with the following attributes:
     * the warrior's preferred weapon
     * Champion type i.e Warrior.
     **/
    @Override
    public String toString() {
        return super.toString() +
                "Preferred Weapon: " + weapon + "\n"+
                "Champion: Warrior"          +       "\n";
    }
}