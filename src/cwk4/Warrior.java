package cwk4;

public class Warrior extends Champion{
    private String weapon;
    public Warrior(String name, String weapon, int fee, String state, boolean isMagic, boolean isFight, boolean isMystery){
        super(fee, state, 0, isMagic, isFight, isMystery, name);
        this.setSkillLevel(fee / 100);
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Preferred Weapon: " + weapon + "\n";
    }

    public static void main(String[] args)
    {
        Champion war = new Warrior("Warrir", "gun", 123, "Waiting", false, true, false);
        System.out.println(war);
    }
}