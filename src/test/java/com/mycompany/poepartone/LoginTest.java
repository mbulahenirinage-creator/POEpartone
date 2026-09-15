/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.poepartone;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */

public class LoginTest {

    private Login login;

    

    // Test 1: Username is correct (kyl_1)
    @Test
    public void testValidUsername() {
        boolean expResult = true;
        boolean result = login.checkUsername("kyl_1");
        assertEquals(expResult, result);
    }

    // Test 2: Username is invalid (kyle!!!!!!!)
    @Test
    public void testInValidUsername() {
        boolean expResult = false;
        boolean result = login.checkUsername("kyle!!!!!!!");
        assertEquals(expResult, result);
    }

    // Test 3: Password is correct
    @Test
    public void testValidPassword() {
        boolean expResult = true;
        boolean result = login.checkPasswordComplexity("Ch&sec@ke99!");
        assertEquals(expResult, result);
    }

    // Test 4: Password is invalid
    @Test
    public void testInValidPassword() {
        boolean expResult = false;
        boolean result = login.checkPasswordComplexity("password");
        assertEquals(expResult, result);
    }

    // Test 5: Phone number is correct
    @Test
    public void testValidPhone() {
        boolean expResult = true;
        boolean result = login.checkCellPhoneNumber("+27838968976");
        assertEquals(expResult, result);
    }

    // Test 6: Phone number is invalid
    @Test
    public void testInValidPhone() {
        boolean expResult = false;
        boolean result = login.checkCellPhoneNumber("08966553");
        assertEquals(expResult, result);
    }

    // Test 7: Login is successful
    @Test
    public void testLoginSuccessful() {
        login.registerUser("kyl_1", "Ch&sec@ke99!", "+27838968976", "Kyle", "Smith");
        boolean expResult = true;
        boolean result = login.loginUser("kyl_1", "Ch&sec@ke99!");
        assertEquals(expResult, result);
    }

    // Test 8: Login is unsuccessful
    @Test
    public void testLoginUnsuccessful() {
        login.registerUser("kyl_1", "Ch&sec@ke99!", "+27838968976", "Kyle", "Smith");
        boolean expResult = false;
        boolean result = login.loginUser("kyl_1", "wrongpassword");
        assertEquals(expResult, result);
    }
}
    
    
      