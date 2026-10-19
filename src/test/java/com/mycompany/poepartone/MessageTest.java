/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poepartone;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;


/**
 *
 * @author Student
 */



public class MessageTest {

    private Message message;

    @Before
    public void setUp() {
        message = new Message(1, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
    }

    @Test
    public void testMessageIDCreated() {
        assertEquals(true, message.checkMessageID());
    }

    @Test
    public void testMessageLengthValid() {
        assertEquals("Message ready to send.", message.checkMessageLength());
    }

    @Test
    public void testRecipientCellCorrect() {
        assertEquals("Cell phone number successfully captured.", message.checkRecipientCell());
    }

    @Test
    public void testMessageHashCreated() {
        assertNotNull(message.getMessageHash());
        assertTrue(message.getMessageHash().contains(":"));
    }

    @Test
    public void testSendMessage() {
        assertEquals("Message successfully sent.", message.sentMessage(1));
    }

    @Test
    public void testDisregardMessage() {
        assertEquals("Press 0 to delete the message.", message.sentMessage(2));
    }

    @Test
    public void testStoreMessage() {
        assertEquals("Message successfully stored.", message.sentMessage(3));
    }
}