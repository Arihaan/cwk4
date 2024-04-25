package cwk4;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 * Provide a GUI interface for the game
 * 
 * @author A.A.Marczyk
 * @version 20/01/24
 */
public class GameGUI 
{
    private CARE gp = new Tournament("Fred");
    private JFrame myFrame = new JFrame("Game GUI");
    private JTextArea listing = new JTextArea();
    private JLabel codeLabel = new JLabel ();
    private JButton meetBtn = new JButton("Meet Challenge");
    private JButton viewBtn = new JButton("View State");
    private JButton clearBtn = new JButton("Clear");
    private JButton quitBtn = new JButton("Quit");
    private JPanel eastPanel = new JPanel();

    public static void main(String[] args)
    {
        new GameGUI();
    }
    
    public GameGUI()
    {
        makeFrame();
        makeMenuBar(myFrame);
    }
    

    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {    
        myFrame.setLayout(new BorderLayout());
        myFrame.add(listing,BorderLayout.CENTER);
        listing.setVisible(false);
        myFrame.add(eastPanel, BorderLayout.EAST);
        // set panel layout and add components
        eastPanel.setLayout(new GridLayout(4,1));
        eastPanel.add(viewBtn);
        eastPanel.add(meetBtn);
        eastPanel.add(clearBtn);
        eastPanel.add(quitBtn);

        clearBtn.addActionListener(new ClearBtnHandler());
        meetBtn.addActionListener(new MeetBtnHandler());
        quitBtn.addActionListener(new QuitBtnHandler());
        viewBtn.addActionListener(new ViewStateHandler());

        meetBtn.setVisible(true);
        clearBtn.setVisible(true);
        quitBtn.setVisible(true);
        viewBtn.setVisible(true);

        // Create a JScrollPane and add the JTextArea to it
        JScrollPane scrollPane = new JScrollPane(listing);
        // Add the JScrollPane to the frame
        myFrame.getContentPane().add(scrollPane);

        // building is done - arrange the components and show        
        myFrame.pack();
        myFrame.setVisible(true);
    }
    
    /**
     * Create the main frame's menu bar.
     */
    private void makeMenuBar(JFrame frame)
    {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        // create the File menu
        JMenu championMenu = new JMenu("Champions");
        JMenu challengeMenu = new JMenu("Challenges");
        menubar.add(championMenu);
        menubar.add(challengeMenu);

        JMenuItem listChampionItem = new JMenuItem("List Champions in reserve");
        JMenuItem listTeamItem = new JMenuItem("List Team");
        JMenuItem viewChampionItem = new JMenuItem("View Champion");
        JMenuItem enterChampionItem = new JMenuItem("Enter Champion");

        JMenuItem listChallengesItem = new JMenuItem("List All Challenges");

        enterChampionItem.addActionListener(new EnterChampionHandler());
        viewChampionItem.addActionListener(new ViewChampionHandler());
        listTeamItem.addActionListener(new ListTeamHandler());
        listChampionItem.addActionListener(new ListReserveHandler());
        
        listChallengesItem.addActionListener(new ListAllChallengesHandler());

        championMenu.add(enterChampionItem);
        championMenu.add(viewChampionItem);
        championMenu.add(listTeamItem);
        championMenu.add(listChampionItem);

        challengeMenu.add(listChallengesItem);

    }
    
    private class ListReserveHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            listing.setVisible(true);
            String xx = gp.getReserve();
            listing.setText(xx);
        }
    }
    private class ListAllChallengesHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            listing.setVisible(true);
            String xx = gp.getAllChallenges();
            listing.setText(xx);
        }
    }
    private class ViewStateHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            listing.setVisible(true);
            String xx = gp.toString();
            listing.setText(xx);
        }
    }
    private class ListTeamHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            listing.setVisible(true);
            String xx = gp.getTeam();
            listing.setText(xx);
        }
    }
    private class ClearBtnHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            listing.setText(" ");
        }
    }
    private class ViewChampionHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String championName = JOptionPane.showInputDialog("Champion name: ");
            String result = gp.getChampionDetails(championName);

            JOptionPane.showMessageDialog(myFrame,result);
        }
    }
    private class MeetBtnHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            int result = -1;
            String answer = "no such challenge";
            String inputValue = JOptionPane.showInputDialog("Challenge number ?: ");
            int num = Integer.parseInt(inputValue);
            result = gp.meetChallenge(num);
            switch (result)
            {
                case 0:answer = "challenge won by champion"; break;
                case 1:answer = "challenge lost on skills, champion disqualified";break;
                case 2:answer = "challenge lost as no suitable champion is available";break;
                case 3:answer = "challenge lost and vizier completely defeated";break;
            }
            
            JOptionPane.showMessageDialog(myFrame,answer);    
        }
    }
    private class EnterChampionHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String answer = "no such champion";
            String inputValue = JOptionPane.showInputDialog("Champion name ?: ");
            int result = gp.enterChampion(inputValue);
            answer = switch (result) {
                case 0 -> "champion successfully entered team";
                case 1 -> "champion is not in reserve";
                case 2 -> "not enough money in the treasury";
                default -> answer;
            };

            JOptionPane.showMessageDialog(myFrame,answer);
        }
    }
    private class QuitBtnHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            int answer = JOptionPane.showConfirmDialog(myFrame,
                "Are you sure you want to quit?","Finish",
                JOptionPane.YES_NO_OPTION);
            // closes the application
            if (answer == JOptionPane.YES_OPTION)
            {
                System.exit(0); //closes the application
            }              
        }
    }
    
}
   
