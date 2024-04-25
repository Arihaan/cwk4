/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import cwk4.*;

import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class T7PersistenceTest {
    CARE game;

    public T7PersistenceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        game = new Tournament("Snow", "challengesAM.txt");
    }

    @After
    public void tearDown() {
    }
    private boolean containsText(String text, String[] s) {
        boolean check = true;
        for(int i=0; i < s.length; i++)
            check = check && text.contains(s[i]);
        return check;
    }

    @Test
    public void gameCorrectlySetsUpChallengesFromFile() {
        String result = game.getAllChallenges();
        String[] xx = {"Borg","Huns", "Ferengi", "Vandal", "Goth", "Frank", "Sith", "Cardashian", "Jute", "Celt"};
        boolean actual = containsText(result,xx );
        assertTrue(actual);
    }

    @Test
    public void loadNonExistingSave() {
        CARE actual = game.loadGame("nonExistingFile");
        assertNull(actual);
    }

    @Test
    public void saveAndLoadTest() {
        String filename = "testSave";
        game.enterChampion("Argon");
        game.saveGame(filename);
        String expected = game.toString();

        game.retireChampion("Argon");
        game.enterChampion("Flimsi");
        String actual = game.loadGame(filename).toString();

        assertEquals(expected, actual);
    }
}
