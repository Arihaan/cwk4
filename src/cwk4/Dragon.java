package cwk4;

public class Dragon extends Champion{
    private boolean isTalking;
    public Dragon(String name, boolean isTalking){
        super(500, 7, false, true, isTalking, name);
        this.isTalking = isTalking;
    }

    public boolean isTalking() {
        return isTalking;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Is Talking: " + isTalking + "\n"+
                "Champion: Dragon"          +       "\n";
    }
}