package com.app;

import java.util.ArrayList;
import java.util.List;

/**
 * A class designed to hold information aobut contacts.
 * ContactId must not be longer than 10 characters, unchangeable, and not null.
 * firstName must not be longer than 10 characters and not null.
 * lastName must not be longer than 10 characters and not null.
 * phoneNum must be 10 characters and not null.
 * address must not be longer that 
 */

 public class Contact {

    private static List<String> existingIds = new ArrayList<>(); 
    private String contactId;
    private String firstName;
    private String lastName;
    private String phoneNum;
    private String address;

    /**
     * Constructor with all attributes
     */
    public Contact(String contactId, String firstName, String lastName, String phoneNum, String address) {

        // If statements to checking for valid inputs
        // Validate contactId 
        if(contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID does not meet specifications");
        }
        if (existingIds.contains(contactId)) {
            throw new IllegalArgumentException("Contact ID must be unique");
        }

        // Validate other fields
        if(firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Contact first name does not meet specifications");
        }
        if(lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Contact last name does not meet specifications");
        }
        if(phoneNum.length() != 10) {
            throw new IllegalArgumentException("Contact phone number does not meet specifications");
        }
        if(address == null || address.length() > 30) {
            throw new IllegalArgumentException("Contact address does not meet specifications");
        }

        /**
         * If specifications are met then contact object will be created
         * with entered agruments
         */
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.address = address;

        // Add contactId to the list
        existingIds.add(contactId);
    }

    /**
     * Method for getting contact ID
     * @return the contactId variable
     */
    public String getContactId() {
        return contactId;
    }

    /**
     * Method for getting contacts first name
     * @return the firstName variable
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Method for getting contacts last name
     * @return the lastName variable
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method for getting contacts phone number
     * @return the phoneNum variable
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * Method for getting contacts address
     * @return the address variable
     */
    public String getAddress() {
        return address;
    }

    /**
     * Method for getting the list of tasks
     * @return the existingIds List
     */
    public static List<String> getExistingIds() {
        return new ArrayList<>(existingIds);
    }

    /**
     * Method for setting contacts first name
     * @param firstName to be set as first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Method for setting contacts last name
     * @param lastName to be set as last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Method for setting contacts phone number
     * @param phoneNum to be set as phone number
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     * Method for setting contacts address
     * @param address to be set as address
     */
    public void setAddress(String address) {
        this.address = address;
    }
}