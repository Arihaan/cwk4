package cwk4;

public class Dragon extends Champion{
    boolean isTalking;
    public Dragon(boolean isTalking, int fee, String state, int skill, boolean isMagic, boolean isFight, boolean isMystery){
        super(fee, state, skill, isMagic, isFight, isMystery);
        this.isTalking = isTalking;
    }
}
