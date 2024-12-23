package com.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class AppointmentService {

    // List to hold Appointment objects
    private List<Appointment> appointments;
    
    public AppointmentService() {
        this.appointments = new ArrayList<>();
    }

    /**
     * Adds a new appointment with a unique ID.
     * 
     * @param appointmentId appointment unique ID
     * @param appointment date appointment date
     * @param taskDescription  appointment description
     * @throws IllegalArgumentException if any parameter fails validation
     */
    public void addAppointment(String appointmentId, Date appointmentDate, String appointmentDescription) {
        Appointment newAppointment = new Appointment(appointmentId, appointmentDate, appointmentDescription);
        // Add to local list if the constructor succeeds
        appointments.add(newAppointment);
    }

    /**
     * Deletes a appointment by ID.
     * 
     * @param appointmentId The ID of the appointment to delete
     * @return true if the appointment was removed, false otherwise
     */
    public boolean deleteAppointment(String appointmentId) {
        boolean removed = appointments.removeIf(appointment -> appointment.getAppointmentId().equals(appointmentId));
        if (removed) {
            // Remove ID from the global list
            Appointment.getExistingAppointments().remove(appointmentId);
        }
        return removed;
    }

    /**
     * Updates the fields of a task by ID.
     * 
     * @param appointmentId The ID of the appointment to update
     * @param appointmentDate New appointment Date
     * @param appointmentDescription  New appointment description
     * @throws IllegalArgumentException if the task ID is invalid or any update value fails validation
     */
    public void updateAppointment(String appointmentId, Date appointmentDate, String appointmentDescription) {
        Appointment appointment = findAppointmentById(appointmentId);
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment ID does not exist");
        }

        // Check for null entries
        if (appointmentDate != null) {
            appointment.setAppointmentDate(appointmentDate);
        }
        if (appointmentDescription != null) {
            appointment.setAppointmentDescription(appointmentDescription);
        }
    }

    /**
     * Finds a appointment by ID.
     * 
     * @param appointmentId The ID to search for
     * @return The matching Appointment object, or null if not found
     */
    private Appointment findAppointmentById(String appointmentId) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                return appointment;
            }
        }
        return null;
    }

    /**
     * Returns the list of all appointments.
     * 
     * @return List of appointments
     */
    public List<Appointment> getAllAppointments() {
        // Return a copy of the list to ensure immutability
        return new ArrayList<>(appointments);
    }
}