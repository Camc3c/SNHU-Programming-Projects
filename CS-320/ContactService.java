package com.app;

import java.util.ArrayList;
import java.util.List;

public class ContactService {

    // List to hold Contact objects
    private List<Contact> contacts;

    public ContactService() {
        this.contacts = new ArrayList<>();
    }

    /**
     * Adds a new contact with a unique ID.
     * 
     * @param contactId Contact's unique ID
     * @param firstName Contact's first name
     * @param lastName  Contact's last name
     * @param phoneNum  Contact's phone number
     * @param address   Contact's address
     * @throws IllegalArgumentException if any parameter fails validation
     */
    public void addContact(String contactId, String firstName, String lastName, String phoneNum, String address) {
        Contact newContact = new Contact(contactId, firstName, lastName, phoneNum, address);
        // Add to local list if the constructor succeeds
        contacts.add(newContact);
    }

    /**
     * Deletes a contact by ID.
     * 
     * @param contactId The ID of the contact to delete
     * @return true if the contact was removed, false otherwise
     */
    public boolean deleteContact(String contactId) {
        boolean removed = contacts.removeIf(contact -> contact.getContactId().equals(contactId));
        if (removed) {
            // Remove ID from the global list
            Contact.getExistingIds().remove(contactId); 
        }
        return removed;
    }

    /**
     * Updates the fields of a contact by ID.
     * 
     * @param contactId The ID of the contact to update
     * @param firstName New first name (nullable if not updating)
     * @param lastName  New last name (nullable if not updating)
     * @param phoneNum  New phone number (nullable if not updating)
     * @param address   New address (nullable if not updating)
     * @throws IllegalArgumentException if the contact ID is invalid or any update value fails validation
     */
    public void updateContact(String contactId, String firstName, String lastName, String phoneNum, String address) {
        Contact contact = findContactById(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }

        // Check for null entries
        if (firstName != null) {
            contact.setFirstName(firstName);
        }
        if (lastName != null) {
            contact.setLastName(lastName);
        }
        if (phoneNum != null) {
            contact.setPhoneNum(phoneNum);
        }
        if (address != null) {
            contact.setAddress(address);
        }
    }

    /**
     * Finds a contact by ID.
     * 
     * @param contactId The ID to search for
     * @return The matching Contact object, or null if not found
     */
    private Contact findContactById(String contactId) {
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                return contact;
            }
        }
        return null;
    }

    /**
     * Returns the list of all contacts.
     * 
     * @return List of contacts
     */
    public List<Contact> getAllContacts() {
        // Return a copy of the list to ensure immutability
        return new ArrayList<>(contacts);
    }
}