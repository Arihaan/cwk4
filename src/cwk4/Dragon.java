package cwk4;

public class Dragon extends Champion{
    private boolean isTalking;
    public Dragon(String name, boolean isTalking, String state, boolean isMagic, boolean isFight, boolean isMystery){
        super(500, state, 7, isMagic, isFight, isMystery, name);
        this.isTalking = isTalking;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Is Talking: " + isTalking + "\n";
    }

    public static void main(String[] args)
    {
        Champion wiz = new Dragon("Mate", true, "Waiting", true, true, true);
        System.out.println(wiz);
    }
}