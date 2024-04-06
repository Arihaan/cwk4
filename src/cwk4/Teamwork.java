package cwk4; 


/**
 * Details of your team
 * 
 * @author Team 21
 * @version 1.0
 */
public class Teamwork
{
    private String[] details = new String[13];
    
    public Teamwork()
    {   // in each line replace the contents of the String 
        // with the details of your team member
        // Please list the member details alphabetically by surname 
        // i.e. the surname of member1 should come alphabetically 
        // before the surname of member 2...etc
        details[0] = "21";

        details[1] = "Affos";
        details[2] = "Ashton";
        details[3] = "21083290";

        details[4] = "Mathur";
        details[5] = "Hardik";
        details[6] = "22000375";

        details[7] = "Negi";
        details[8] = "Arihaan Singh";
        details[9] = "21088888";

        details[10] = "Yuldashev";
        details[11] = "Bekzod";
        details[12] = "21094146";

    }
    
    public String[] getTeamDetails()
    {
        return details;
    }
    
    public void displayDetails()
    {
        for(String temp:details)
        {
            System.out.println(temp.toString());
        }
    }
}
        
