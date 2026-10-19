/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poepartone;





import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class LoginTest {

    private login login;

    @Before
    public void setUp() {
        login = new login();
    }

   
    @Test
    public void testUsernameCorrect() {
        boolean result = login.checkUsername("kyl_1");
        assertEquals(true, result);
    }

    
    @Test
    public void testUsernameIncorrect() {
        boolean result = login.checkUsername("kyle!!!!!!!");
        assertEquals(false, result);
    }

   
    @Test
    public void testPasswordCorrect() {
        boolean result = login.checkPasswordComplexity("Ch&sec@ke99!");
        assertEquals(true, result);
    }

    
    @Test
    public void testPasswordIncorrect() {
        boolean result = login.checkPasswordComplexity("password");
        assertEquals(false, result);
    }

    
    @Test
    public void testPhoneCorrect() {
        boolean result = login.checkCellPhoneNumber("+27838968976");
        assertEquals(true, result);
    }

    
    @Test
    public void testPhoneIncorrect() {
        boolean result = login.checkCellPhoneNumber("08966553");
        assertEquals(false, result);
    }

    
    @Test
    public void testLoginSuccessful() {
        login.registerUser("kyl_1", "Ch&sec@ke99!", "+27838968976", "Kyle", "Smith");
        boolean result = login.loginUser("kyl_1", "Ch&sec@ke99!");
        assertEquals(true, result);
    }

    
    @Test
    public void testLoginUnsuccessful() {
        login.registerUser("kyl_1", "Ch&sec@ke99!", "+27838968976", "Kyle", "Smith");
        boolean result = login.loginUser("kyl_1", "wrongpassword");
        assertEquals(false, result);
    }
}