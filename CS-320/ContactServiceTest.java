package com.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    @BeforeEach
    void clearExistingIds() {
        // Reset existingIds before each test
        Contact.getExistingIds().clear();
    }

    @Test
    void testValidContactCreation() {
        Contact contact = new Contact("456", "John", "Doe", "1234567890", "123 Elm Street");
        assertEquals("456", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhoneNum());
        assertEquals("123 Elm Street", contact.getAddress());
    }

    @Test
    void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "1234567890", "123 Elm Street"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Elm Street"));
    }

    @Test
    void testDuplicateContactId() {
        new Contact("123", "John", "Doe", "1234567890", "123 Elm Street");
        assertThrows(IllegalArgumentException.class, () -> new Contact("123", "Jane", "Smith", "0987654321", "456 Maple Avenue"));
    }

    @Test
    void testInvalidFieldValues() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("123", null, "Doe", "1234567890", "123 Elm Street"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("123", "John", null, "1234567890", "123 Elm Street"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("123", "John", "Doe", "12345678", "123 Elm Street"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("123", "John", "Doe", "1234567890", null));
    }

    @Test
    void testUpdateFields() {
        Contact contact = new Contact("456", "John", "Doe", "1234567890", "123 Elm Street");
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhoneNum("0987654321");
        contact.setAddress("456 Maple Avenue");

        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhoneNum());
        assertEquals("456 Maple Avenue", contact.getAddress());
    }
}