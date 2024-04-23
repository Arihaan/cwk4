package cwk4;

public class Warrior extends Champion{
    private String weapon;
    public Warrior(String name, String weapon, int fee){
        super(fee, 0, false, true, false, name);
        this.setSkillLevel(fee / 100);
        this.weapon = weapon;
    }

    public String getWeapon() {
        return weapon;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Preferred Weapon: " + weapon + "\n";
    }
}