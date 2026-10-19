package com.mycompany.poepartone;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        login loginSystem = new login();

        System.out.println("=== WELCOME TO THE CHAT APP ===");
        System.out.println("\n--- REGISTER ---");
        
        System.out.print("Enter first name: ");
        String fName = input.nextLine();
        System.out.print("Enter last name: ");
        String lName = input.nextLine();
        System.out.print("Enter username: ");
        String user = input.nextLine();
        System.out.print("Enter password: ");
        String pass = input.nextLine();
        System.out.print("Enter phone (+27...): ");
        String phone = input.nextLine();

        String regResult = loginSystem.registerUser(user, pass, phone, fName, lName);
        System.out.println(regResult);

        if (regResult.equals("User registered successfully!")) {
            System.out.println("\n--- LOGIN ---");
            System.out.print("Username: ");
            String loginUser = input.nextLine();
            System.out.print("Password: ");
            String loginPass = input.nextLine();

            if (loginSystem.loginUser(loginUser, loginPass)) {
                System.out.println(loginSystem.returnLoginStatus(loginUser, loginPass));

                System.out.println("\n=== WELCOME TO QUICKCHAT ===");
                System.out.print("How many messages do you wish to enter? ");
                int numMessages = input.nextInt();
                input.nextLine(); 

                boolean running = true;

                while (running) {
                    System.out.println("\n--- MENU ---");
                    System.out.println("1) Send Messages");
                    System.out.println("2) Show recently sent messages");
                    System.out.println("3) Quit");
                    System.out.print("Choose: ");
                    int option = input.nextInt();
                    input.nextLine();

                    if (option == 1) {
                        for (int i = 1; i <= numMessages; i++) {
                            System.out.println("\n--- Message " + i + " ---");
                            System.out.print("Recipient (+27...): ");
                            String recipient = input.nextLine();
                            System.out.print("Message (max 250 chars): ");
                            String text = input.nextLine();

                            Message msg = new Message(i, recipient, text);

                            System.out.println(msg.checkRecipientCell());
                            String lengthCheck = msg.checkMessageLength();
                            System.out.println(lengthCheck);

                            if (lengthCheck.equals("Message ready to send.")) {
                                System.out.println("Hash: " + msg.getMessageHash());
                                System.out.print("1) Send  2) Discard  3) Store. Choose: ");
                                int choice = input.nextInt();
                                input.nextLine();
                                System.out.println(msg.sentMessage(choice));
                            }
                        }
                    } else if (option == 2) {
                        System.out.println("Coming Soon.");
                    } else if (option == 3) {
                        running = false;
                        System.out.println("Goodbye!");
                    } else {
                        System.out.println("Invalid option.");
                    }
                }
            } else {
                System.out.println("Login failed. Incorrect username or password.");
            }
        }
        input.close();
    }
}