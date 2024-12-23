package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * A class designed to store appointment information
 * appointmentId is a unique ID, shall not be longer than 10 characters, shall not be null, and shall not be updated
 * appointmentDate shall not be in the past and shall not be null
 * appointmentDescription shall not be longer than 50 characters and shall not be null
 */

public class Appointment {
    
    private static List<String> existingAppointments = new ArrayList<>();
    private String appointmentId;
    private Date appointmentDate;
    private String appointmentDescription;

    /**
     * Constructor with all attributes
     */
    public Appointment(String appointmentId, Date appointmentDate, String appointmentDescription) {

        // If statements to checking for valid inputs
        // Validate appointmentId
        if(appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Appointment ID does not meet specifications");
        }
        if (existingAppointments.contains(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID must be unique");
        }

        // Validate date
        if(appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date cannot be in the past.");
        }
        
        // Validate Description
        if(appointmentDescription == null || appointmentDescription.length() > 50) {
            throw new IllegalArgumentException("Appointment Description does not meet specifications");
        }

        /**
         * If specifications are met then contact object will be created
         * with entered agruments
         */
        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.appointmentDescription = appointmentDescription;

         // Add contactId to the list
        existingAppointments.add(appointmentId);
    }

    /**
     * Method for getting appointment ID
     * @return the appointmentId variable
     */
    public String getAppointmentId() {
        return appointmentId;
    }

    /**
     * Method for getting appointment date
     * @return the appointmentDate variable
     */
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    /**
     * Method for getting appointment description
     * @return the appointmentDescription variable
     */
    public String getAppointmentDescription() {
        return appointmentDescription;
    }

    /**
     * Method for getting the list of appointment IDs
     * @return the eexistingAppointments List
     */
    public static List<String> getExistingAppointments() {
        return existingAppointments;
    }

    /**
     * Method for setting appointment date
     * @param appointmentDate to be set as appointment date
     */
    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    /**
     * Method for setting appointment descritpion
     * @param appointmentDate to be set as appointment description
     */
    public void setAppointmentDescription(String appointmentDescription) {
        this.appointmentDescription = appointmentDescription;
    }
}