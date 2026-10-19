/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepartone;

import java.util.ArrayList;
import java.util.Random;

public class Message {

    String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    String messageHash;
    private String sendStatus;

    // Store all messages
    public static ArrayList<Message> allMessages = new ArrayList<>();

    // Constructor
    public Message(int messageNumber, String recipient, String messageText) {
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }

    // Generate random 10-digit message ID
    private String generateMessageID() {
        Random rand = new Random();
        long id = 1000000000L + (long)(rand.nextDouble() * 9000000000L);
        return String.valueOf(id);
    }

    // Check message ID is not more than 10 characters
    public boolean checkMessageID() {
        if (messageID.length() <= 10) {
            return true;
        } else {
            return false;
        }
    }

    // Check recipient cell number
    public String checkRecipientCell() {
        if (recipient.startsWith("+") && recipient.length() <= 12) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    // Create message hash
    public String createMessageHash() {
        // First 2 digits of message ID
        String firstTwo = messageID.substring(0, 2);
        
        // First and last words of message
        String[] words = messageText.split(" ");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        
        // Build hash: first2:messageNumber:FIRSTWORDLASTWORD
        String hash = firstTwo + ":" + messageNumber + ":" + firstWord + lastWord;
        
        return hash.toUpperCase();
    }

    // Check message length
    public String checkMessageLength() {
        if (messageText.length() <= 250) {
            return "Message ready to send.";
        } else {
            int excess = messageText.length() - 250;
            return "Message exceeds 250 characters by " + excess + "; please reduce the size.";
        }
    }

    // Send, store, or discard message
    public String sentMessage(int choice) {
        if (choice == 1) {
            sendStatus = "Message successfully sent.";
            allMessages.add(this);
            return sendStatus;
        } else if (choice == 2) {
            sendStatus = "Press 0 to delete the message.";
            return sendStatus;
        } else if (choice == 3) {
            sendStatus = "Message successfully stored.";
            allMessages.add(this);
            return sendStatus;
        } else {
            return "Invalid choice.";
        }
    }

    // Print all messages
    public String printMessages() {
        String output = "";
        for (int i = 0; i < allMessages.size(); i++) {
            Message m = allMessages.get(i);
            output = output + "Message ID: " + m.messageID + "\n";
            output = output + "Message Hash: " + m.messageHash + "\n";
            output = output + "Recipient: " + m.recipient + "\n";
            output = output + "Message: " + m.messageText + "\n\n";
        }
        return output;
    }

    // Return total number of messages
    public int returnTotalMessages() {
        return allMessages.size();
    }

    // Getters for testing
    public String getMessageID() { return messageID; }
    public String getMessageHash() { return messageHash; }
    public String getRecipient() { return recipient; }
    public String getMessageText() { return messageText; }
    public int getMessageNumber() { return messageNumber; }
}