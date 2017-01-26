/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import mastermind.Mastermind;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author lionel
 */
public class MastermindTest {
    
    public MastermindTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testResult(){
        
        
        int[] computerPlay ={1,2,3,4};
        
        Assert.assertEquals("VVVV", Mastermind.playRound(computerPlay, "1234"));
        Assert.assertEquals("VXXX", Mastermind.playRound(computerPlay, "1567"));
        Assert.assertEquals("OOOO", Mastermind.playRound(computerPlay, "4321"));
        Assert.assertEquals("VVXX", Mastermind.playRound(computerPlay, "1256"));
    }
}
