/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepartone; 
import java.util.Scanner;
/**
 *
 * @author Student
 */


public class Main {
    
    public static void main(String[] args) {
        
        // Create a Scanner to read what the user types
        Scanner keyboard = new Scanner(System.in);
        
        // Create the Login system
        login loginSystem = new login();
        
        
        System.out.println("   WELCOME TO RINAYE'S CHAT APP   ");
       
        
        
        System.out.println("--- CREATE YOUR ACCOUNT ---");
        
        
        // Ask for first name
        System.out.print("Enter your first name: ");
        String firstName = keyboard.nextLine();
        
        // Ask for last name
        System.out.print("Enter your last name: ");
        String lastName = keyboard.nextLine();
        
        // Ask for username
        System.out.print("Enter username (must have _ and be 5 chars or less): ");
        String username = keyboard.nextLine();
        
        // Ask for password
        System.out.print("Enter password (8+ chars, capital, number, special): ");
        String password = keyboard.nextLine();
        
        // Ask for phone number
        System.out.print("Enter cell phone number (like +27831234567): ");
        String phone = keyboard.nextLine();
        
        System.out.println();
        System.out.println("--- REGISTRATION RESULT ---");
        
        // Register the user and save the result message
        String result = loginSystem.registerUser(username, password, phone, 
                                                  firstName, lastName);
        System.out.println(result);
        System.out.println();
        
        
        if (result.equals("User registered successfully!")) {
            
            System.out.println("--- LOGIN TO YOUR ACCOUNT ---");
            System.out.println();
            
            // Allow 3 login attempts
            int attemptsLeft = 3;
            boolean loggedIn = false;
            
            while (attemptsLeft > 0 && !loggedIn) {
                
                System.out.print("Enter username: ");
                String loginUsername = keyboard.nextLine();
                
                System.out.print("Enter password: ");
                String loginPassword = keyboard.nextLine();
                
                // Check if login is successful
                if (loginSystem.loginUser(loginUsername, loginPassword)) {
                    System.out.println();
                    System.out.println("--- LOGIN SUCCESSFUL! ---");
                    System.out.println(loginSystem.returnLoginStatus(loginUsername, loginPassword));
                    loggedIn = true;
                } else {
                    attemptsLeft--;
                    System.out.println("Username or password incorrect, please try again.");
                    System.out.println("Attempts remaining: " + attemptsLeft);
                    
                }
            }
            
            if (!loggedIn) {
                System.out.println("Too many failed attempts. You have been locked out.");
                System.out.println("Please restart the program to try again.");
            }
            
        } else {
            System.out.println("Registration failed. Please restart the program.");
        }
        
        
        keyboard.close();
    }
}
