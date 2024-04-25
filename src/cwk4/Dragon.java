package cwk4;
/**
 * class Dragon - extension of class Champion
 *
 * @author TEAM21
 * @version 1
 */
public class Dragon extends Champion{
    private boolean isTalking;
    public Dragon(String name, boolean isTalking){
        super(500, 7, false, true, isTalking, name);
        this.isTalking = isTalking;
    }

    /** Returns true if the dragon can talk else false.
     * @return true if the dragon can talk else false.
     **/
    public boolean isTalking() {
        return isTalking;
    }

    @Override
    /**Returns a String representation of the Champion along with the following attributes:
     * if the dragon talks or not
     * Champion type i.e Dragon.
     *
     * @return a String representation of the Champion along with the following attributes:
     * if the dragon talks or not
     * Champion type i.e Dragon.
     **/
    public String toString() {
        return super.toString() +
                "Is Talking: " + isTalking + "\n"+
                "Champion: Dragon"          +       "\n";
    }
}