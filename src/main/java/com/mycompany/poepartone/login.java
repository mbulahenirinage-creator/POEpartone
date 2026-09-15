/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepartone;

/**
 *
 * @author Student
 */

public class login {

    private String savedUsername;
    private String savedPassword;
    private String firstName;
    private String lastName;

    public boolean checkUsername(String username) {
        if (username.contains("_") && username.length() <= 5) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                hasCapital = true;
            }
            if (c >= '0' && c <= '9') {
                hasNumber = true;
            }
            if (c == '!' || c == '@' || c == '#' || c == '$' ||
                c == '%' || c == '^' || c == '&' || c == '*' ||
                c == '(' || c == ')' || c == '-' || c == '_' ||
                c == '=' || c == '+') {
                hasSpecial = true;
            }
        }

        if (hasCapital == true && hasNumber == true && hasSpecial == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkCellPhoneNumber(String phone) {
        if (phone.startsWith("+27") == false) {
            return false;
        }

        String rest = phone.substring(3);

        if (rest.length() != 9) {
            return false;
        }

        for (int i = 0; i < rest.length(); i++) {
            if (Character.isDigit(rest.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    public String registerUser(String username, String password,
                               String phone, String fName, String lName) {

        if (checkUsername(username) == false) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (checkPasswordComplexity(password) == false) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (checkCellPhoneNumber(phone) == false) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        savedUsername = username;
        savedPassword = password;
        firstName = fName;
        lastName = lName;

        return "User registered successfully!";
    }

    public boolean loginUser(String username, String password) {
        if (savedUsername == null) {
            return false;
        }
        if (savedUsername.equals(username) && savedPassword.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public String returnLoginStatus(String username, String password) {
        if (loginUser(username, password) == true) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
